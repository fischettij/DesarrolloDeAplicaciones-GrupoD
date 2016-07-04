package unq.tpi.desapp.repositories;

import java.util.List;

import org.hibernate.Query;

import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.Vehicle;

public class UserRepository extends HibernateGenericDAO<User> implements GenericRepository<User> {

	private static final long serialVersionUID = -5045941197862742130L;

	@Override
	protected Class<User> getDomainClass() {
		return User.class;
	}

	public List<User> getUsersLike(String paramUserName) {
		String hql = "SELECT r " + " FROM " + this.getDomainClass().getName() + " r "
				+ " WHERE LOWER(r.name) LIKE LOWER(:userName)";

		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);

		query.setParameter("userName", "%" + paramUserName + "%");

		@SuppressWarnings("unchecked")
		List<User> foundUsers = query.list();

		return foundUsers;
	}

	public List<Vehicle> getVehicles(Long idManager, Integer pages, Integer quantity) {
		
		String hql = "SELECT r " + " FROM " + Vehicle.class.getName() + " r " + " WHERE ID_MANAGER = :idManager";

		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);

		query.setParameter("idManager", idManager);
		query.setFirstResult(pages * quantity);
		query.setMaxResults(quantity);

		@SuppressWarnings("unchecked")
		List<Vehicle> foundVehicles = query.list();

		return foundVehicles;
	}

	public Integer getCountVehiclesFor(Long idManager, Integer quantity) {
		String hql = "SELECT count(*) " + " FROM " + Vehicle.class.getName() + " r " + " WHERE ID_MANAGER = :idManager";

		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);

		query.setParameter("idManager", idManager);
		return (int) ((Long) query.uniqueResult() / quantity);
	}

}
