package unq.tpi.desapp.repositories;

import unq.tpi.desapp.model.RegisterUser;

public class RegisterUserRepository extends HibernateGenericDAO<RegisterUser> implements GenericRepository<RegisterUser> {

	@Override
	protected Class<RegisterUser> getDomainClass() {
		return RegisterUser.class;
	}
}
