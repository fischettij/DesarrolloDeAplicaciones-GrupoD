package unq.tpi.desapp.repositories;

import unq.tpi.desapp.model.RegisterUser;

public class RegisterUserRepository extends HibernateGenericDAO<RegisterUser>
		implements GenericRepository<RegisterUser> {

	private static final long serialVersionUID = -4719734785626291563L;

	@Override
	protected Class<RegisterUser> getDomainClass() {
		return RegisterUser.class;
	}
}
