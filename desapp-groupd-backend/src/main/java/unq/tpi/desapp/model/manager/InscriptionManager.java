package unq.tpi.desapp.model.manager;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import unq.tpi.desapp.model.Inscription;
import unq.tpi.desapp.model.Route;

public class InscriptionManager extends Manager {

	private static final long serialVersionUID = -3498209227418559363L;

	@JsonIgnore
	private List<Inscription> inscriptions;

	public InscriptionManager() {
	}

	public InscriptionManager(List<Inscription> inscriptions) {
		super();
		this.inscriptions = inscriptions;
	}

	@JsonIgnore
	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void add(Inscription inscription) throws Exception {
		if (this.includes(inscription.getRoute())) {
			throw new Exception("Ya contienes una Inscripcion para esa ruta");
		}
		this.inscriptions.add(inscription);
	}

	public void remove(Inscription inscription) {
		this.inscriptions.remove(inscription);
	}

	private boolean includes(Route route) {
		return this.inscriptions.stream().anyMatch(aInscription -> aInscription.getRoute() == route);
	}

	private Inscription lookFor(Route route) {
		return this.inscriptions.stream().filter(aInscription -> aInscription.getRoute() == route).findFirst().get();
	}

	public void requestAccepted(Route route) {
		this.lookFor(route).accepted();
	}

	public void requestDenied(Route route) {
		Inscription inscription = this.lookFor(route);
		inscription.subscriptionRequestDenied();
		this.remove(inscription);
	}

	@JsonProperty
	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public String getManager() {
		return "InscriptionManager";
	}

}
