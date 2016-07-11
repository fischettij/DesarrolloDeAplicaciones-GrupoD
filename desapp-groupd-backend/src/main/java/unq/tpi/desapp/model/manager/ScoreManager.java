package unq.tpi.desapp.model.manager;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import unq.tpi.desapp.model.CommentedPoint;
import unq.tpi.desapp.model.Product;
import unq.tpi.desapp.model.User;

public class ScoreManager extends Manager {

	private static final long serialVersionUID = 5210193007832017618L;

	@JsonIgnore
	private List<CommentedPoint> commentedPoints;
	@JsonIgnore
	private Integer amountOfPositiveComments;
	@JsonIgnore
	private Integer amountOfNegativeComments;
	@JsonIgnore
	private Integer usedPoints;

	public ScoreManager() {
	}

	public ScoreManager(List<CommentedPoint> commentedPoints, Integer amountOfPositiveComments,
			Integer amountOfNegativeComments) {
		super();
		this.commentedPoints = commentedPoints;
		this.amountOfPositiveComments = amountOfPositiveComments;
		this.amountOfNegativeComments = amountOfNegativeComments;
		this.usedPoints = 0;
	}

	public void add(CommentedPoint commentedPoint) {
		this.removeCommentFromUser(commentedPoint.getUser());
		commentedPoint.increasePoints(this);
		this.commentedPoints.add(commentedPoint);
	}

	public void increasePositiveCommentedPoint() {
		this.amountOfPositiveComments += 1;
	}

	public void increaseNegativeCommentedPoint() {
		this.amountOfNegativeComments += 1;
	}

	public void decreasePositiveCommentedPoint() {
		this.amountOfPositiveComments -= 1;
	}

	public void decreaseNegativeCommentedPoint() {
		this.amountOfNegativeComments -= 1;
	}

	private void removeCommentFromUser(User user) {
		CommentedPoint commentToRemove = null;
		for (CommentedPoint commentedPoint : this.getCommentedPoints()) {
			if (commentedPoint.getUser().equals(user)) {
				commentToRemove = commentedPoint;
				commentedPoint.decreasePoint(this);
				break;
			}
		}
		this.getCommentedPoints().remove(commentToRemove);
	}

	public Integer getScore() {
		return this.getAmountOfPositiveComments() * 500 - this.getAmountOfPositiveComments() / 2 * 1000;
	}

	@JsonIgnore
	public Integer getAmountOfNegativeComments() {
		return amountOfNegativeComments;
	}

	@JsonProperty
	public void setAmountOfNegativeComments(Integer amountOfNegativeComments) {
		this.amountOfNegativeComments = amountOfNegativeComments;
	}

	@JsonIgnore
	public List<CommentedPoint> getCommentedPoints() {
		return commentedPoints;
	}

	@JsonProperty
	public void setCommentedPoints(List<CommentedPoint> commentedPoints) {
		this.commentedPoints = commentedPoints;
	}

	public String getManager() {
		return "ScoreManager";
	}

	@JsonIgnore
	public Integer getAmountOfPositiveComments() {
		return amountOfPositiveComments;
	}

	@JsonProperty
	public void setAmountOfPositiveComments(Integer amountOfPositiveComments) {
		this.amountOfPositiveComments = amountOfPositiveComments;
	}

	public Integer getUsedPoints() {
		return usedPoints;
	}

	public void setUsedPoints(Integer usedPoints) {
		this.usedPoints = usedPoints;
	}

	public void purchaseProduct(Product product) {
		if ((this.getScore() - this.usedPoints - product.getRequiredPoints()) >= 0) {
			this.usedPoints = this.usedPoints + product.getRequiredPoints();
			product.removeStock(1);
		} else {
			// TIRAR EXCEPCION
		}
	}

}
