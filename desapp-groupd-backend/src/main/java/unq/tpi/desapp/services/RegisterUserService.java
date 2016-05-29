package unq.tpi.desapp.services;

import org.springframework.transaction.annotation.Transactional;

import unq.tpi.desapp.builders.UserBuilder;
import unq.tpi.desapp.exception.NotFoundException;
import unq.tpi.desapp.model.RegisterUser;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.request.LoginUser;

public class RegisterUserService extends GenericService<RegisterUser> {

	@Transactional
	public User login(LoginUser loginUser) throws NotFoundException {
		for (RegisterUser registerUser : this.retriveAll()) {
			if (registerUser.is(loginUser))
				return registerUser.getUser();
		}
		throw new NotFoundException("User doesn't exists");
	}	

	@Transactional
	public void register(LoginUser loginUser) {
		for (RegisterUser user : this.retriveAll()) {
			if (user.is(loginUser))
				throw new RuntimeException("User already exists");
		}
		RegisterUser registerUser = new RegisterUser(loginUser.getEmail(), loginUser.getPassword(),
				new UserBuilder().setName(loginUser.getName()).setStandarManagers().build());
		this.save(registerUser);

	}

}
