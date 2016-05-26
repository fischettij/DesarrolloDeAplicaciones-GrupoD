package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.request.LoginUser;

public class LoginUserBuilder {

	private String email;
	private String password;
	private String name;

	public LoginUserBuilder(){
		email = "user@gmail.com";
		password = "nicePassword";
		name = "name";
	}
	
	public LoginUserBuilder setEmail(String email) {
		this.email = email;
		return this;
	}

	public LoginUserBuilder setPassword(String password) {
		this.password = password;
		return this;
	}

	public LoginUserBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public LoginUser build() {
		return new LoginUser(name, email, password);
	}

}
