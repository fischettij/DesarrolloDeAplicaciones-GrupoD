package unq.tpi.desapp.model.inscription;

import unq.tpi.desapp.model.Inscription;

public abstract class InscriptionState {

	public abstract void accepted(Inscription inscription);

	public void subscriptionRequestDenied(Inscription inscription) {
	}

}
