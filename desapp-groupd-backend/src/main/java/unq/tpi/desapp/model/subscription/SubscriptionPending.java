package unq.tpi.desapp.model.subscription;

import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.SubscriptionRequest;
import unq.tpi.desapp.model.manager.InscriptionManager;

public class SubscriptionPending extends SubscriptionState {

	private static final long serialVersionUID = -1556644719663209187L;

	public SubscriptionPending() {
	}

	@Override
	public void accepted(SubscriptionRequest subscriptionRequest, Route route) {
		subscriptionRequest.setSubscriptionState(new SubscriptionAccepted());
		subscriptionRequest.getCandidate().managerImplementing(InscriptionManager.class).requestAccepted(route);
	}

}
