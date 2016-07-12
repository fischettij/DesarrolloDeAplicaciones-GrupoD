package unq.tpi.desapp.repositories;

import java.util.List;

import org.hibernate.Query;

import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.services.request.RequestRoute;

public class RouteRepository extends HibernateGenericDAO<Route> implements GenericRepository<Route> {

	private static final long serialVersionUID = 3607014819932471245L;

	@Override
	protected Class<Route> getDomainClass() {
		return Route.class;
	}
	
	private Query lookForRoutesQuery(String action, RequestRoute requestRoute) {
		String hql = action + "FROM " + this.getDomainClass().getName() + " r "
				+ "JOIN r.daysOfWeek days WHERE days IN (:setOfEnum)" + "AND r.startLatitud <= :routeStartingLatitud + "
				+ this.getDistance() + "AND r.startLatitud >= :routeStartingLatitud - " + this.getDistance()
				+ "AND r.startLongitud <= :routeStartingLongitud + " + this.getDistance()
				+ "AND r.startLongitud >= :routeStartingLongitud - " + this.getDistance()
				+ "AND r.endLatitud <= :routeEndingLatitud + " + this.getDistance()
				+ "AND r.endLatitud >= :routeEndingLatitud - " + this.getDistance()
				+ "AND r.endLongitud <= :routeEndingLongitud + " + this.getDistance()
				+ "AND r.endLongitud >= :routeEndingLongitud - " + this.getDistance();

		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameterList("setOfEnum", requestRoute.getDaysOfWeek());
		query.setParameter("routeStartingLatitud", requestRoute.getStartLatitud());
		query.setParameter("routeStartingLongitud", requestRoute.getStartLongitud());
		query.setParameter("routeEndingLatitud", requestRoute.getEndLatitud());
		query.setParameter("routeEndingLongitud", requestRoute.getEndLongitud());
		
		return query;
	}
	
	private Double getDistance() {
		return 0.08;
	}

	public List<Route> lookForRoutes(RequestRoute requestRoute, Integer page, Integer quantity) {
		Query query = lookForRoutesQuery("SELECT r ", requestRoute);
		query.setFirstResult(page * quantity);
		query.setMaxResults(quantity);
		return query.list();
	}

	public Integer getCountSearchRoutesFor(RequestRoute requestRoute, Integer quantity) {
		Query query = lookForRoutesQuery("SELECT count(*) ", requestRoute); 
		return (int) ((Long) query.uniqueResult() / quantity);
	}

}
