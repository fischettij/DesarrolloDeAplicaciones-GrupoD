package unq.tpi.desapp.model.manager;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import unq.tpi.desapp.model.Comment;

public class CommentManager extends Manager {

	@JsonIgnore
	private List<Comment> comments;

	public CommentManager() {
	}

	public CommentManager(List<Comment> comments) {
		this.comments = comments;
	}

	@JsonIgnore
	public List<Comment> getComments() {
		return comments;
	}

	public void add(Comment comment) {
		this.comments.add(comment);
	}

	@JsonProperty
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getManager() {
		return "CommentManager";
	}

}
