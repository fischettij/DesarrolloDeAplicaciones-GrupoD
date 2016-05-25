package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.RegisterUser;
import unq.tpi.desapp.model.User;

public class RegisterUserBuilder {

	private String email;
	private String password;
	private User user;

	public RegisterUserBuilder(){
		email = "user@gmail.com";
		password = "nicePassword";
		user = new UserBuilder().build();
	}
	
	public RegisterUserBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public RegisterUserBuilder setPassword(String password) {
		this.password = password;
		return this;
	}

	public RegisterUserBuilder setUser(User user) {
		this.user = user;
		return this;
	}

	public RegisterUser build() {
		return new RegisterUser(email, password, user);
	}

}
