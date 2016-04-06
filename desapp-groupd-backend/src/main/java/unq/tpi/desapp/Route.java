package unq.tpi.desapp;

import java.util.List;

public class Route {

	private String startingPoint;
	private String endingPoint;
	private Routine routine;
	private List<SubscribeRequest> subscribeRequests;

	public Route(String startingPoint, String endingPoint, Routine routine, List<SubscribeRequest> subscribeRequests) {
		super();
		this.startingPoint = startingPoint;
		this.endingPoint = endingPoint;
		this.routine = routine;
		this.subscribeRequests = subscribeRequests;
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

	public Routine getRoutine() {
		return routine;
	}

	public void setRoutine(Routine routine) {
		this.routine = routine;
	}

	public List<SubscribeRequest> getSubscribeRequests() {
		return subscribeRequests;
	}

	public void setSubscribeRequests(List<SubscribeRequest> subscribeRequests) {
		this.subscribeRequests = subscribeRequests;
	}

}
