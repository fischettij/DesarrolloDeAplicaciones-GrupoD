package unq.tpi.desapp.model.request;

public class CommentedPointForUser {

	private long commentedUser;
	private boolean isNegative;
	private String comment;
	
	public CommentedPointForUser(){
	}
	
	public CommentedPointForUser(long commentedUser, boolean isNegative, String comment) {
		super();
		this.commentedUser = commentedUser;
		this.isNegative = isNegative;
		this.comment = comment;
	}

	public long getCommentedUser() {
		return commentedUser;
	}

	public void setCommentedUser(long id) {
		this.commentedUser = id;
	}

	public boolean getIsNegative() {
		return isNegative;
	}

	public void setIsNegative(boolean isNegative) {
		this.isNegative = isNegative;
	}

	public String getComment() {
		return comment;
	}
	
	public void setComment(String commet) {
		this.comment = commet;
	}
	
	 

}
