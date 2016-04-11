package unq.tpi.desapp.model;

import unq.tpi.desapp.model.subscription.SubscriptionState;

public class SubscriptionRequest {

	private User candidate;
	private String mapPoint;
	private String message;
	private SubscriptionState subscriptionState;

	public SubscriptionRequest(User candidate, String mapPoint, String message, SubscriptionState subscriptionState) {
		this.candidate = candidate;
		this.mapPoint = mapPoint;
		this.message = message;
		this.subscriptionState = subscriptionState;
	}

	public User getCandidate() {
		return candidate;
	}

	public String getMapPoint() {
		return mapPoint;
	}

	public String getMessage() {
		return message;
	}

	public SubscriptionState getSubscriptionState() {
		return subscriptionState;
	}

	public void setSubscriptionState(SubscriptionState subscriptionState) {
		this.subscriptionState = subscriptionState;
	}

	public void accepted(Route route) {
		this.subscriptionState.accepted(this, route);
	}

	public void canceled(Route route) {
		this.subscriptionState.canceled(this, route);
	}

}
