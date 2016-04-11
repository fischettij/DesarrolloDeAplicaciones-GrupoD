package unq.tpi.desapp.model.subscription;

import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.SubscriptionRequest;

public abstract class SubscriptionState {

	public abstract void accepted(SubscriptionRequest subscriptionRequest, Route route);

	public void canceled(SubscriptionRequest subscriptionRequest, Route route) {
		subscriptionRequest.getCandidate().subscriptionRequestDenied(route);
	}

}
