package unq.tpi.desapp.model;

public class CommentedPoint extends Entity {

	private static final long serialVersionUID = 2096581432717097874L;

	private User user;
	private Boolean isNegative;
	private String comment;

	public CommentedPoint() {
	}

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

	public Boolean getIsNegative() {
		return isNegative;
	}

	public void setIsNegative(Boolean isNegative) {
		this.isNegative = isNegative;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

}
