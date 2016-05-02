package unq.tpi.desapp.model;

public class Comment extends Entity {

	private User user;
	private String message;

	public Comment(){}
	
	public Comment(User aUser, String aMessage) {
		this.user = aUser;
		this.message = aMessage;
	}

	public User getUser() {
		return user;
	}

	public String getMessage() {
		return message;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
