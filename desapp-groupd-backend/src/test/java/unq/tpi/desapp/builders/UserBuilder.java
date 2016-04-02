package unq.tpi.desapp.builders;

import java.util.ArrayList;
import java.util.List;

import unq.tpi.desapp.Inscription;
import unq.tpi.desapp.Route;
import unq.tpi.desapp.User;
import unq.tpi.desapp.Vehicle;

public class UserBuilder {

	private String name;
	private List<Vehicle> vehicles;
	private List<Inscription> inscriptions;
	private List<Route> routes;

	public UserBuilder() {
		name = "";
		vehicles = new ArrayList<Vehicle>();
		inscriptions = new ArrayList<Inscription>();
		routes = new ArrayList<Route>();
	}

	public UserBuilder setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
		return this;
	}

	public UserBuilder setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
		return this;
	}

	public UserBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public UserBuilder setRoutes(List<Route> routes) {
		this.routes = routes;
		return this;
	}

	public User build() {
		return new User(name, vehicles, routes, inscriptions);
	}

}
