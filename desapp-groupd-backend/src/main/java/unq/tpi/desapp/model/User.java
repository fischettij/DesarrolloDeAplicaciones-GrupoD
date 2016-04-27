package unq.tpi.desapp.model;

import java.util.Collection;
import java.util.List;

import unq.tpi.desapp.model.manager.CommentManager;
import unq.tpi.desapp.model.manager.InscriptionManager;
import unq.tpi.desapp.model.manager.RouteManager;
import unq.tpi.desapp.model.manager.ScoreManager;
import unq.tpi.desapp.model.manager.VehicleManager;

public class User extends Entity {

	private String name;
	private VehicleManager vehicleManager;
	private RouteManager routeManager;
	private InscriptionManager inscriptionManager;
	private ScoreManager scoreManager;
	private CommentManager commentManager;

	public User(String name, VehicleManager vehicleManager, RouteManager routeManager,
			InscriptionManager inscriptionManager, ScoreManager scoreManager, CommentManager commentManager) {
		super();
		this.name = name;
		this.vehicleManager = vehicleManager;
		this.routeManager = routeManager;
		this.inscriptionManager = inscriptionManager;
		this.scoreManager = scoreManager;
		this.commentManager = commentManager;
	}

	public String getName() {
		return name;
	}

	public void addVehicle(Vehicle vehicle) throws Exception {
		this.vehicleManager.add(vehicle);
	}

	public void removeVehicle(Vehicle vehicle) {
		this.vehicleManager.remove(vehicle);
	}

	public List<Vehicle> getVehicles() {
		return this.vehicleManager.getVehicles();
	}

	public void addRoute(Route route) {
		this.routeManager.add(route);
	}

	public void removeRoute(Route route) {
		this.routeManager.remove(route);
	}

	public List<Route> getRoutes() {
		return this.routeManager.getRoutes();
	}

	public void addInscription(Inscription inscription) throws Exception {
		this.inscriptionManager.add(inscription);
	}

	public void removeInscription(Inscription inscription) {
		this.inscriptionManager.remove(inscription);
	}

	public void subscriptionRequestAccepted(Route route) {
		this.inscriptionManager.requestAccepted(route);
	}

	public void subscriptionRequestDenied(Route route) {
		this.inscriptionManager.requestDenied(route);
	}

	public List<Inscription> getInscriptions() {
		return this.inscriptionManager.getInscriptions();
	}

	public void addCommentedPoint(CommentedPoint commentedPoint) {
		this.scoreManager.add(commentedPoint);
	}

	public void sendCommentedPoint(User receiver, CommentedPoint commentedPoint) {
		receiver.addCommentedPoint(commentedPoint);
	}

	public Collection<CommentedPoint> getCommentedPoints() {
		return scoreManager.getComments();
	}

	public List<Comment> getComments() {
		return commentManager.getComments();
	}

	public void addComment(Comment aComment) {
		commentManager.add(aComment);
	}

}
