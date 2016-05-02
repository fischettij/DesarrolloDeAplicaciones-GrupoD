package unq.tpi.desapp.repositories;

import unq.tpi.desapp.model.User;

public class UserRepository extends HibernateGenericDAO<User> implements GenericRepository<User> {

	@Override
	protected Class<User> getDomainClass() {
		return User.class;
	}
}
