package unq.tpi.desapp.services.request;

import unq.tpi.desapp.model.CommentedPoint;

public class CommentedPointRequest {

	private long userId;
	private String userName;
	private boolean isNegative;
	private String comment;
	
	public CommentedPointRequest(){
	}

	public CommentedPointRequest(CommentedPoint commentedPoint){
		this.userId = commentedPoint.getUser().getId(); 
		this.userName = commentedPoint.getUser().getName();
		this.isNegative = commentedPoint.getIsNegative();
		this.comment = commentedPoint.getComment();
	}
	
	public CommentedPointRequest(long userId, String userName,
			boolean isNegative, String comment) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.isNegative = isNegative;
		this.comment = comment;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
