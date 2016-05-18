package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.Inscription;
import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.inscription.InscriptionPending;
import unq.tpi.desapp.model.inscription.InscriptionState;

public class InscriptionBuilder {

	private Route route;
	private InscriptionState inscriptionState;

	public InscriptionBuilder() {
		route = null;
		inscriptionState = new InscriptionPending();
	}

	public InscriptionBuilder setRoute(Route route) {
		this.route = route;
		return this;
	}

	public InscriptionBuilder setInscriptionState(InscriptionState inscriptionState) {
		this.inscriptionState = inscriptionState;
		return this;
	}

	public Inscription build() {
		return new Inscription(route, inscriptionState);
	}

}
