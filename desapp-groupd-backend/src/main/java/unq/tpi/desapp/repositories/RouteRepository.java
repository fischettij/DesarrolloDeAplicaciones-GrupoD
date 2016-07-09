package unq.tpi.desapp.repositories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.services.request.RequestRoute;

public class RouteRepository extends HibernateGenericDAO<Route> implements GenericRepository<Route> {

	private static final long serialVersionUID = 3607014819932471245L;

	@Override
	protected Class<Route> getDomainClass() {
		return Route.class;
	}

	public Set<Route> lookForRoutes(RequestRoute requestRoute) {
		String hql = "SELECT r " + "FROM " + this.getDomainClass().getName() + " r "
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

		@SuppressWarnings("unchecked")
		List<Route> foundRoute = query.list();

		return new HashSet<Route>(foundRoute);

	}

	private Double getDistance() {
		return 0.08;
	}

}
