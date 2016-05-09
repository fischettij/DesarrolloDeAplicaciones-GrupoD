package unq.tpi.desapp.model.subscription;

import unq.tpi.desapp.model.Entity;
import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.SubscriptionRequest;
import unq.tpi.desapp.model.manager.InscriptionManager;

public abstract class SubscriptionState extends Entity {

	public abstract void accepted(SubscriptionRequest subscriptionRequest, Route route);

	public void canceled(SubscriptionRequest subscriptionRequest, Route route) {
		subscriptionRequest.getCandidate().managerImplementing(InscriptionManager.class).requestDenied(route);
	}

}
