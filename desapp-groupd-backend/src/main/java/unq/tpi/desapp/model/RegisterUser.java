package unq.tpi.desapp.model;

import unq.tpi.desapp.model.request.LoginUser;

public class RegisterUser extends Entity {

	private String email;
	private String password;
	private User user;

	public RegisterUser() {
	}

	public RegisterUser(String email, String password, User user) {
		this.email = email;
		this.password = password;
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean is(LoginUser loginUser) {
		return this.email.equals(loginUser.getEmail()) && this.password.equals(loginUser.getPassword());
	}

	public Boolean is(RegisterUser registerUser) {
		return this.email == registerUser.getEmail() && this.password == registerUser.getPassword();
	}
}
