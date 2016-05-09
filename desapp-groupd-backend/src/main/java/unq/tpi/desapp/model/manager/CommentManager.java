package unq.tpi.desapp.model.manager;

import java.util.List;

import unq.tpi.desapp.model.Comment;
import unq.tpi.desapp.model.Entity;

public class CommentManager extends Manager {

	private List<Comment> comments;
	
	public CommentManager() {
	}

	public CommentManager(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void add(Comment comment) {
		this.comments.add(comment);
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
