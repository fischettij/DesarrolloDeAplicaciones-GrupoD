package unq.tpi.desapp.model;

import unq.tpi.desapp.model.inscription.InscriptionState;

public class Inscription {

	private Route route;
	private InscriptionState inscriptionState;

	public Inscription(Route route, InscriptionState inscriptionState) {
		this.route = route;
		this.inscriptionState = inscriptionState;
	}

	public InscriptionState getInscriptionState() {
		return inscriptionState;
	}

	public Route getRoute() {
		return route;
	}

	public boolean contains(Route route) {
		return this.route.equals(route);
	}

	public void accepted() {
		this.inscriptionState.accepted(this);
	}

	public void subscriptionRequestDenied() {
		this.inscriptionState.subscriptionRequestDenied(this);
	}

	public void setInscriptionState(InscriptionState inscriptionState) {
		this.inscriptionState = inscriptionState;

	}

}
