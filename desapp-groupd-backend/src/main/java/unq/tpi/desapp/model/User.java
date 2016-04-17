package unq.tpi.desapp.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import unq.tpi.desapp.exceptions.InvalidAction;

public class User {

	private String name;
	private List<Vehicle> vehicles;
	private List<Route> routes;
	private List<Inscription> inscriptions;
	private HashMap<User, CommentedPoint> commentedPoints;

	public User(String name, List<Vehicle> vehicles, List<Route> routes, List<Inscription> inscriptions) {
		super();
		this.name = name;
		this.vehicles = vehicles;
		this.routes = routes;
		this.inscriptions = inscriptions;
		this.commentedPoints = new HashMap<User,CommentedPoint>();
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

	public void addInscription(Inscription inscription){
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

	public void addCommentedPoint(CommentedPoint commentedPoint) throws InvalidAction{
		if (commentedPoint.getUser() == this){  throw new InvalidAction("No se puede puntuar uno mismo");} 
		commentedPoints.put(commentedPoint.getUser(),commentedPoint);
	}

	public Collection<CommentedPoint> getCommentedPoints() {	
		return commentedPoints.values();
	}

}
