package unq.tpi.desapp.model;

import unq.tpi.desapp.model.subscription.SubscriptionState;

public class SubscriptionRequest extends Entity {

	private static final long serialVersionUID = 4469725679355349099L;

	private User candidate;
	private SubscriptionState subscriptionState;

	public SubscriptionRequest() {
	}

	public SubscriptionRequest(User candidate, SubscriptionState subscriptionState) {
		this.candidate = candidate;
		this.subscriptionState = subscriptionState;
	}

	public User getCandidate() {
		return candidate;
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

	public void setCandidate(User candidate) {
		this.candidate = candidate;
	}

}
