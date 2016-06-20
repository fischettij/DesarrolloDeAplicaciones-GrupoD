package unq.tpi.desapp.repositories;

import unq.tpi.desapp.model.Product;

public class ProductRepository extends HibernateGenericDAO<Product> implements GenericRepository<Product> {

	private static final long serialVersionUID = -4406703442530340107L;

	@Override
	protected Class<Product> getDomainClass() {
		return Product.class;
	}
}
