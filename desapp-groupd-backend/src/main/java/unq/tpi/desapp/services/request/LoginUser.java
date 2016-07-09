package unq.tpi.desapp.services.request;

public class LoginUser {

	private String email;
	private String password;
	private String name;

	public LoginUser(String name, String email, String password) {
		this.setName(name);
		this.email = email;
		this.password = password;
	}

	public LoginUser() {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
