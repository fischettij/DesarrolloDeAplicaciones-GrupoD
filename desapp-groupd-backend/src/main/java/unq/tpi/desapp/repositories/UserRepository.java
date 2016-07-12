package unq.tpi.desapp.repositories;

import java.util.List;

import org.hibernate.Query;

import unq.tpi.desapp.model.Inscription;
import unq.tpi.desapp.model.Product;
import unq.tpi.desapp.model.Route;
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
	
	public List<Route> getRoutes(Long idManager, Integer pages, Integer quantity) {
		return paginationInTable(Route.class, idManager, pages, quantity);
	}

	public List<Vehicle> getVehicles(Long idManager, Integer pages, Integer quantity) {
		return paginationInTable(Vehicle.class, idManager, pages, quantity);
	}

	public List<Inscription> getInscriptions(Long idManager, Integer pages, int quantity) {
		return paginationInTable(Inscription.class, idManager, pages, quantity);
	}
	
	public List<Product> getProducts(Long idManager, Integer pages, Integer quantity) {
		return paginationInTable(Product.class, idManager, pages, quantity);
	}

	public Integer getCountVehiclesFor(Long idManager, Integer quantity) {
		return countElementsInTable(Vehicle.class.getName(), idManager, quantity);
	}
	
	public Integer getCountInscriptionsFor(Long idManager, int quantity) {
		return countElementsInTable(Inscription.class.getName(), idManager, quantity);
	}

	public Integer getCountMyRoutesFor(Long idManager, int quantity) {
		return countElementsInTable(Route.class.getName(), idManager, quantity);
	}
	
	public Integer getCountProductsFor(Long idManager, Integer quantity) {
		return countElementsInTable(Product.class.getName(), idManager, quantity);
	}

	private Integer countElementsInTable(String nameClass, Long idManager, int quantity) {
		String hql = "SELECT count(*) " + " FROM " + nameClass + " r " + " WHERE ID_MANAGER = :idManager";

		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);

		query.setParameter("idManager", idManager);
		return (int) ((Long) query.uniqueResult() / quantity);
	}
	
	private <E> List<E> paginationInTable(Class<E> class1, Long idManager, Integer pages, Integer quantity) {
		String hql = "SELECT r " + " FROM " + class1.getName() + " r " + " WHERE ID_MANAGER = :idManager";

		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);

		query.setParameter("idManager", idManager);
		query.setFirstResult(pages * quantity);
		query.setMaxResults(quantity);

		return query.list();
	}
		
}
