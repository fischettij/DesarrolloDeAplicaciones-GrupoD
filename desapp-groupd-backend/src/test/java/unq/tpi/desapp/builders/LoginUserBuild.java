package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.request.LoginUser;

public class LoginUserBuild {

	private String email;
	private String password;
	private String name;

	public LoginUserBuild setEmail(String email) {
		this.email = email;
		return this;
	}

	public LoginUserBuild setPassword(String password) {
		this.password = password;
		return this;
	}

	public LoginUser build() {
		return new LoginUser(name, email, password);
	}

	public LoginUserBuild setName(String name) {
		this.name = name;
		return this;
	}

}
