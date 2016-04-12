package unq.tpi.desapp.model;


public class CommentedPoint {

	private User user;
	private Integer point;
	private String comment;
		
	public CommentedPoint(User someUser, Integer point, String someComment) {
		this.user = someUser;
		this.point = point;
		this.comment = someComment;
	}

	public Integer getPoint() {
		return point;
	}

	public String getComment() {
		return comment;
	}

	public User getUser() {
		return user;
	}


}
