package unq.tpi.desapp.model.inscription;

import unq.tpi.desapp.model.Entity;
import unq.tpi.desapp.model.Inscription;

public abstract class InscriptionState extends Entity {

	private static final long serialVersionUID = -7773177524292540269L;

	public abstract void accepted(Inscription inscription);

	public void subscriptionRequestDenied(Inscription inscription) {
	}

}
