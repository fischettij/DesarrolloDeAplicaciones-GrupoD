package unq.tpi.desapp.repositories;

import java.util.List;

import org.hibernate.Query;

import unq.tpi.desapp.model.Product;

public class ProductRepository extends HibernateGenericDAO<Product> implements GenericRepository<Product> {

	private static final long serialVersionUID = -4406703442530340107L;

	@Override
	protected Class<Product> getDomainClass() {
		return Product.class;
	}
	
	public List<Product>getProducts(Integer page, Integer quantity){
		return paginationInTable(Product.class, page, quantity);
	}
	
	public Integer getCountProducts(int quantity) {
		Query query = getQuery(Product.class, "SELECT count(*)");
		return (int) ((Long) query.uniqueResult() / quantity);
	}
	
	private <E> List<E> paginationInTable(Class<E> class1, Integer pages, Integer quantity) {
		Query query = getQuery(class1, "SELECT r ");
		query.setFirstResult(pages * quantity);
		query.setMaxResults(quantity);
		return query.list();
	}

	private <E> Query getQuery(Class<E> class1, String condition) {
		String hql = condition + " FROM " + class1.getName() + " r ";
		Query query = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		return query;
	}
	
}
