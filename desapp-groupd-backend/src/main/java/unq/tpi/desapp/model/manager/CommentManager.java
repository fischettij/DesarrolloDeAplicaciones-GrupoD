package unq.tpi.desapp.model.manager;

import java.util.List;

import unq.tpi.desapp.model.Comment;

public class CommentManager {

	private List<Comment> comments;

	public CommentManager(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void add(Comment comment) {
		this.comments.add(comment);
	}

}
