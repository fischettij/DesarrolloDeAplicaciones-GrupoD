package unq.tpi.desapp.builders;

import unq.tpi.desapp.Inscription;
import unq.tpi.desapp.Route;

public class InscriptionBuilder {

	private Route route;

	public InscriptionBuilder() {
		route = null;
	}

	public InscriptionBuilder setRoute(Route route) {
		this.route = route;
		return this;
	}

	public Inscription build() {
		return new Inscription(route);
	}

}
