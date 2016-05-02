package unq.tpi.desapp.model;

import java.util.List;

public class Route extends Entity {

	private String startingPoint;
	private String endingPoint;
	private Routine routine;
	private List<SubscriptionRequest> subscriptionRequests;
	
	public Route() {
	}

	public Route(String startingPoint, String endingPoint, Routine routine,
			List<SubscriptionRequest> subscriptionRequests) {
		super();
		this.startingPoint = startingPoint;
		this.endingPoint = endingPoint;
		this.routine = routine;
		this.subscriptionRequests = subscriptionRequests;
	}

	public String getEndingPoint() {
		return endingPoint;
	}

	public String getStartingPoint() {
		return startingPoint;
	}

	public Routine getRoutine() {
		return routine;
	}

	public List<SubscriptionRequest> getSubscriptionRequests() {
		return subscriptionRequests;
	}

	public void addSubscriptionRequest(SubscriptionRequest subscriptionRequest) {
		this.subscriptionRequests.add(subscriptionRequest);
	}

	public void acceptedSubscriptionRequest(SubscriptionRequest subscriptionRequest) {
		if (this.subscriptionRequests.contains(subscriptionRequest)) {
			subscriptionRequest.accepted(this);
		}
	}

	public void canceledSubscriptionRequest(SubscriptionRequest subscriptionRequest) {
		if (this.subscriptionRequests.contains(subscriptionRequest)) {
			subscriptionRequest.canceled(this);
			this.subscriptionRequests.remove(subscriptionRequest);
		}
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}

	public void setEndingPoint(String endingPoint) {
		this.endingPoint = endingPoint;
	}

	public void setRoutine(Routine routine) {
		this.routine = routine;
	}

	public void setSubscriptionRequests(List<SubscriptionRequest> subscriptionRequests) {
		this.subscriptionRequests = subscriptionRequests;
	}

}
