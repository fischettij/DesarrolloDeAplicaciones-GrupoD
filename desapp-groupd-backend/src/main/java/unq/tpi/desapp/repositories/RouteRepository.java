package unq.tpi.desapp.repositories;

import java.util.List;

import org.hibernate.Query;

import unq.tpi.desapp.model.DaysOfWeekEnum;
import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.request.RequestRoute;

public class RouteRepository extends HibernateGenericDAO<Route> implements GenericRepository<Route> {

	private static final long serialVersionUID = 3607014819932471245L;

	@Override
	protected Class<Route> getDomainClass() {
		return Route.class;
	}

	public List<Route> lookForRoutes(RequestRoute requestRoute) {
		String hql = "SELECT r " + "FORM " + this.getDomainClass().getName() + " r "
				+ "join r.daysOfWeek daysOfWeek WHERE daysOfWeek IN " + this.getDays(requestRoute)
				+ "AND r.starLatitud <= :routeStartingLatitud + " + this.getDistance()
				+ "AND r.startLatitud >= :routeStartingLatitud - " + this.getDistance()
				+ "AND r.startLongitud <= :routeStartingLongitud + " + this.getDistance()
				+ "AND r.startLongitud >= :routeStartingLongitud - " + this.getDistance()
				+ "AND r.endLatitud <= :routeEndingLatitud + " + this.getDistance()
				+ "AND r.endLatitud >= :routeEndingLatitud - " + this.getDistance()
				+ "AND r.endLongitud <= :routeEndingLongitud + " + this.getDistance()
				+ "AND r.endLongitud >= :routeEndingLongitud - " + this.getDistance();

		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);

		query.setParameter("routeStartingLatitud", "%" + requestRoute.getStartLatitud() + "%");
		query.setParameter("routeStartingLatitud", "%" + requestRoute.getStartLongitud() + "%");
		query.setParameter("routeStartingLatitud", "%" + requestRoute.getEndLatitud() + "%");
		query.setParameter("routeStartingLatitud", "%" + requestRoute.getEndLongitud() + "%");

		@SuppressWarnings("unchecked")
		List<Route> foundRoute = query.list();

		return foundRoute;

	}

	private String getDays(RequestRoute requestRoute) {
		String ret = "(";
		for (DaysOfWeekEnum daysOfWeekEnum : requestRoute.getDaysOfWeek()) {
			ret = ret + "\"" + daysOfWeekEnum + "\"";
		}
		return ret + ")";
	}

	private String getDistance() {
		return "0.08";
	}

}
