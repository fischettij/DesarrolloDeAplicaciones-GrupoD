package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.RegisterUser;
import unq.tpi.desapp.model.User;

public class RegisterUserBuild {

	private String email;
	private String password;
	private User user;

	public RegisterUserBuild setEmail(String email) {
		this.email = email;
		return this;
	}

	public RegisterUserBuild setPassword(String password) {
		this.password = password;
		return this;
	}

	public RegisterUserBuild setUser(User user) {
		this.user = user;
		return this;
	}

	public RegisterUser build() {
		return new RegisterUser(email, password, user);
	}

}
