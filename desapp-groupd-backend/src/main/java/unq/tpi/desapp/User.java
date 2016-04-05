package unq.tpi.desapp;

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

	public void setName(String name) {
		this.name = name;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	public List<Inscription> getInscriptions() {
		return inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
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
}
