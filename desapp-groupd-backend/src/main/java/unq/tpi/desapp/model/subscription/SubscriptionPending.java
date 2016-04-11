package unq.tpi.desapp.model.subscription;

import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.SubscriptionRequest;

public class SubscriptionPending extends SubscriptionState {

	@Override
	public void accepted(SubscriptionRequest subscriptionRequest, Route route) {
		subscriptionRequest.setSubscriptionState(new SubscriptionAccepted());
		subscriptionRequest.getCandidate().subscriptionRequestAccepted(route);

	}

}
