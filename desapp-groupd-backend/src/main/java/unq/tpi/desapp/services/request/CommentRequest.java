package unq.tpi.desapp.services.request;

import org.joda.time.DateTime;

import unq.tpi.desapp.model.Comment;

public class CommentRequest {

	private long userId;
	private String userName;
	private String message;
	private DateTime date;
	
	public CommentRequest(){
	};

	public CommentRequest(Comment comment) {
		this.userId = comment.getUser().getId();
		this.userName = comment.getUser().getName();
		this.message = comment.getMessage();
		this.date = comment.getDate();
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userID) {
		this.userId = userID;
	}
	
	public void setUserName(String name){
		this.userName = name;
	}
	
	public String getUserName(){
		return this.userName;
	}

	public String getMessage() {
		return message;
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
