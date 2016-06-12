package unq.tpi.desapp.model;

import org.joda.time.DateTime;

public class Comment extends Entity {

	private static final long serialVersionUID = 7288274647260324215L;

	private User user;
	private String message;
	private DateTime date;

	public Comment() {
	}

	public Comment(User aUser, String aMessage, DateTime date) {
		this.user = aUser;
		this.message = aMessage;
		this.setDate(date);
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

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

}
