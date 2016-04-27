package unq.tpi.desapp.model.inscription;

import unq.tpi.desapp.model.Entity;
import unq.tpi.desapp.model.Inscription;

public abstract class InscriptionState extends Entity {

	public abstract void accepted(Inscription inscription);

	public void subscriptionRequestDenied(Inscription inscription) {
	}

}
