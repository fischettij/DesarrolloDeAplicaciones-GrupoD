package unq.tpi.desapp.builders;

import java.util.ArrayList;
import java.util.List;

import unq.tpi.desapp.model.CommentedPoint;
import unq.tpi.desapp.model.manager.ScoreManager;

public class ScoreManagerBuilder {

	private Integer score;
	private List<CommentedPoint> comments;
	private Integer amountOfNegativeComments;

	public ScoreManagerBuilder() {
		super();
		this.score = 0;
		this.comments = new ArrayList<CommentedPoint>();
		this.amountOfNegativeComments = 0;
	}

	public ScoreManagerBuilder setScore(Integer score) {
		this.score = score;
		return this;
	}

	public ScoreManagerBuilder setComments(List<CommentedPoint> comments) {
		this.comments = comments;
		return this;
	}

	public ScoreManagerBuilder setAmountOfNegativeComments(Integer amountOfNegativeComments) {
		this.amountOfNegativeComments = amountOfNegativeComments;
		return this;
	}

	public ScoreManager build() {
		return new ScoreManager(score, comments, amountOfNegativeComments);
	}

}
