package unq.tpi.desapp.model.subscription;

import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.SubscriptionRequest;

public class SubscriptionAccepted extends SubscriptionState {

	private static final long serialVersionUID = 8895228965793147327L;

	public SubscriptionAccepted() {
	}

	@Override
	public void accepted(SubscriptionRequest subscriptionRequest, Route route) {
	}
	
	public String getName(){
		return "Accepted";
	}

}
