package unq.tpi.desapp.repositories;

import unq.tpi.desapp.model.Product;

public class ProductRepository extends HibernateGenericDAO<Product> implements GenericRepository<Product> {

	@Override
	protected Class<Product> getDomainClass() {
		return Product.class;
	}
}
