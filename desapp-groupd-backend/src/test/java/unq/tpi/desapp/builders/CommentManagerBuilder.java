package unq.tpi.desapp.builders;

import java.util.ArrayList;
import java.util.List;

import unq.tpi.desapp.model.Comment;
import unq.tpi.desapp.model.manager.CommentManager;

public class CommentManagerBuilder {

	private List<Comment> comments;

	public CommentManagerBuilder() {
		this.comments = new ArrayList<Comment>();
	}

	public CommentManagerBuilder setComments(List<Comment> comments) {
		this.comments = comments;
		return this;
	}

	public CommentManager build() {
		return new CommentManager(comments);
	}

}
