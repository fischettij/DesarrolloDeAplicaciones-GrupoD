package unq.tpi.desapp.model;

import java.util.List;

public class User {

	private String name;
	private List<Vehicle> vehicles;
	private List<Route> routes;
	private List<Inscription> inscriptions;

	public User(String name, List<Vehicle> vehicles, List<Route> routes, List<Inscription> inscriptions) {
		super();
		this.name = name;
		this.vehicles = vehicles;
		this.routes = routes;
		this.inscriptions = inscriptions;
	}

	public String getName() {
		return name;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void addVehicle(Vehicle vehicle) {
		this.vehicles.add(vehicle);
	}

	public void removeVehicle(Vehicle vehicle) {
		this.vehicles.remove(vehicle);
	}

	public void addRoute(Route route) {
		this.routes.add(route);
	}

	public void removeRoute(Route route) {
		this.routes.remove(route);
	}

	public void addInscription(Inscription inscription) {
		this.inscriptions.add(inscription);
	}

	public void removeInscription(Inscription inscription) {
		this.inscriptions.remove(inscription);
	}

	private Inscription lookForInscriptionWith(Route route) {
		for (Inscription inscription : this.inscriptions) {
			if (inscription.contains(route)) {
				return inscription;
			}
		}
		new RuntimeException();
		return null;
	}

	public void subscriptionRequestAccepted(Route route) {
		Inscription inscription = this.lookForInscriptionWith(route);
		inscription.accepted();
	}

	public void subscriptionRequestDenied(Route route) {
		Inscription inscription = this.lookForInscriptionWith(route);
		inscription.subscriptionRequestDenied();
		this.inscriptions.remove(inscription);

	}

}
