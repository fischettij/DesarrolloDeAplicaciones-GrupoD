package unq.tpi.desapp.model;

import unq.tpi.desapp.model.inscription.InscriptionState;

public class Inscription extends Entity {

	private static final long serialVersionUID = -3561213472825124843L;
	
	private Route route;
	private InscriptionState inscriptionState;

	public Inscription() {
	}

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

	public void setRoute(Route route) {
		this.route = route;
	}

}
