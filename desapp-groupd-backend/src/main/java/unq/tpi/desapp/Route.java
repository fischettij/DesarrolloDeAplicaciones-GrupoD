package unq.tpi.desapp;

public class Route {

	private String startingPoint;
	private String endingPoint;

	public Route(String startingPoint, String endingPoint) {
		super();
		this.startingPoint = startingPoint;
		this.endingPoint = endingPoint;
	}

	public String getEndingPoint() {
		return endingPoint;
	}

	public void setEndingPoint(String endingPoint) {
		this.endingPoint = endingPoint;
	}

	public String getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}

}
