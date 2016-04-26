package unq.tpi.desapp.model;

public class Comment {

	private Integer id;
	private User user;
	private String message;

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

}
