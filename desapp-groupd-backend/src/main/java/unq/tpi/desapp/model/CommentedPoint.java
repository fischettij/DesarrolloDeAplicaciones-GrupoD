package unq.tpi.desapp.model;

public class CommentedPoint extends Entity {

	private User user;
	private Boolean isNegative;
	private String comment;

	public CommentedPoint(User someUser, Boolean isNegative, String someComment) {
		this.user = someUser;
		this.isNegative = isNegative;
		this.comment = someComment;
	}

	public Boolean isNegative() {
		return isNegative;
	}

	public String getComment() {
		return comment;
	}

	public User getUser() {
		return user;
	}

}
