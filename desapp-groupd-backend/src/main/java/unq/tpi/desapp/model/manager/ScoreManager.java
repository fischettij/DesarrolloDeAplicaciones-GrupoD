package unq.tpi.desapp.model.manager;

import java.util.List;

import unq.tpi.desapp.model.CommentedPoint;
import unq.tpi.desapp.model.Entity;
import unq.tpi.desapp.model.User;

public class ScoreManager extends Entity {

	private Integer score;
	private List<CommentedPoint> comments;
	private Integer amountOfNegativeComments;
	
	public ScoreManager() {
	}

	public ScoreManager(Integer score, List<CommentedPoint> comments, Integer amountOfNegativeComments) {
		super();
		this.score = score;
		this.comments = comments;
		this.amountOfNegativeComments = amountOfNegativeComments;
	}

	public void add(CommentedPoint commentedPoint) {
		if (this.includesUser(commentedPoint)) {
			this.replaceComment(commentedPoint);
		} else {
			if (commentedPoint.isNegative()) {
				this.amountOfNegativeComments += 1;
				this.executePendingComments();
			} else {
				this.score += 500;
			}
			this.comments.add(commentedPoint);
		}
	}

	private Boolean includesUser(CommentedPoint commentedPoint) {
		return this.comments.stream().anyMatch(comment -> comment.getUser() == commentedPoint.getUser());
	}

	private void executePendingComments() {
		if (amountOfNegativeComments == 2) {
			this.amountOfNegativeComments = 0;
			this.score -= 1000;
		}
	}

	private CommentedPoint lookFor(User user) {
		return this.comments.stream().filter(comment -> comment.getUser() == user).findFirst().get();
	}

	private void replaceComment(CommentedPoint commentedPoint) {
		CommentedPoint comment = this.lookFor(commentedPoint.getUser());
		if (comment.isNegative()) {
			if (amountOfNegativeComments == 1) {
				amountOfNegativeComments -= 1;
			} else {
				score += 500;
			}
		} else {
			score -= 500;
		}
		this.comments.remove(comment);
		this.add(commentedPoint);
	}

	public Integer getScore() {
		return score;
	}

	public List<CommentedPoint> getComments() {
		return comments;
	}

	public Integer getAmountOfNegativeComments() {
		return amountOfNegativeComments;
	}

	public void setAmountOfNegativeComments(Integer amountOfNegativeComments) {
		this.amountOfNegativeComments = amountOfNegativeComments;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public void setComments(List<CommentedPoint> comments) {
		this.comments = comments;
	}

}