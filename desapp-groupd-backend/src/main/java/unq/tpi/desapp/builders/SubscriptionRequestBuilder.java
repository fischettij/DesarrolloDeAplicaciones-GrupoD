package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.SubscriptionRequest;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.subscription.SubscriptionPending;
import unq.tpi.desapp.model.subscription.SubscriptionState;

public class SubscriptionRequestBuilder {

	private User candidate;
	private String mapPoint;
	private String message;
	private SubscriptionState subscriptionState;

	public SubscriptionRequestBuilder() {
		candidate = new UserBuilder().build();
		mapPoint = "Roque Sáenz Peña 352";
		message = "Roque Sáenz Peña 150";
		subscriptionState = new SubscriptionPending();
	}

	public SubscriptionRequestBuilder setCandidate(User candidate) {
		this.candidate = candidate;
		return this;
	}

	public SubscriptionRequestBuilder setMapPoint(String mapPoint) {
		this.mapPoint = mapPoint;
		return this;
	}

	public SubscriptionRequestBuilder setMessage(String message) {
		this.message = message;
		return this;
	}

	public SubscriptionRequestBuilder setSubscriptionState(SubscriptionState subscriptionState) {
		this.subscriptionState = subscriptionState;
		return this;
	}

	public SubscriptionRequest build() {
		return new SubscriptionRequest(candidate, mapPoint, message, subscriptionState);
	}

}
