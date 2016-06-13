package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.SubscriptionRequest;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.subscription.SubscriptionPending;
import unq.tpi.desapp.model.subscription.SubscriptionState;

public class SubscriptionRequestBuilder {

	private User candidate;
	private SubscriptionState subscriptionState;

	public SubscriptionRequestBuilder() {
		candidate = new UserBuilder().build();
		subscriptionState = new SubscriptionPending();
	}

	public SubscriptionRequestBuilder setCandidate(User candidate) {
		this.candidate = candidate;
		return this;
	}

	public SubscriptionRequestBuilder setSubscriptionState(SubscriptionState subscriptionState) {
		this.subscriptionState = subscriptionState;
		return this;
	}

	public SubscriptionRequest build() {
		return new SubscriptionRequest(candidate, subscriptionState);
	}

}
