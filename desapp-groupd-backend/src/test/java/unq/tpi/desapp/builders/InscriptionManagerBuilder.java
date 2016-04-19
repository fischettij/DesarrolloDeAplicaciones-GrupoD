package unq.tpi.desapp.builders;

import java.util.ArrayList;
import java.util.List;

import unq.tpi.desapp.model.Inscription;
import unq.tpi.desapp.model.manager.InscriptionManager;

public class InscriptionManagerBuilder {

	private List<Inscription> inscriptions;

	public InscriptionManagerBuilder() {
		this.inscriptions = new ArrayList<Inscription>();
	}

	public InscriptionManagerBuilder setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
		return this;
	}

	public InscriptionManager build() {
		return new InscriptionManager(inscriptions);
	}

}
