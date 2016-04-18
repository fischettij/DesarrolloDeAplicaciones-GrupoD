package unq.tpi.desapp.model;

public class Comment {

	private User user;
	private String message;
	
	public Comment(User aUser,String aMessage){
		this.user = aUser;
		this.message = aMessage;
	}
	
}
