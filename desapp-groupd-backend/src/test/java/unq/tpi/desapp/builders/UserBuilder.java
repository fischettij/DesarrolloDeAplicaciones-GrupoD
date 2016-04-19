package unq.tpi.desapp.builders;

import java.util.ArrayList;

import unq.tpi.desapp.model.Comment;
import unq.tpi.desapp.model.CommentedPoint;
import unq.tpi.desapp.model.Inscription;
import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.Vehicle;
import unq.tpi.desapp.model.manager.CommentManager;
import unq.tpi.desapp.model.manager.InscriptionManager;
import unq.tpi.desapp.model.manager.RouteManager;
import unq.tpi.desapp.model.manager.ScoreManager;
import unq.tpi.desapp.model.manager.VehicleManager;

public class UserBuilder {

	private String name;
	private VehicleManager vehicleManager;
	private RouteManager routeManager;
	private InscriptionManager inscriptionManager;
	private ScoreManager scoreManager;
	private CommentManager commentManager;

	public UserBuilder() {
		name = "";
		vehicleManager = new VehicleManager(new ArrayList<Vehicle>());
		routeManager = new RouteManager(new ArrayList<Route>());
		inscriptionManager = new InscriptionManager(new ArrayList<Inscription>());
		scoreManager = new ScoreManager(0, new ArrayList<CommentedPoint>(), 0);
		commentManager = new CommentManager(new ArrayList<Comment>());
	}

	public UserBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public UserBuilder setVehicleManager(VehicleManager vehicleManager) {
		this.vehicleManager = vehicleManager;
		return this;
	}

	public UserBuilder setInscriptionManager(InscriptionManager inscriptionManager) {
		this.inscriptionManager = inscriptionManager;
		return this;
	}

	public UserBuilder setRouteManager(RouteManager routeManager) {
		this.routeManager = routeManager;
		return this;
	}

	public UserBuilder setScoreManager(ScoreManager scoreManager) {
		this.scoreManager = scoreManager;
		return this;
	}

	public UserBuilder setCommentManager(CommentManager commentManager) {
		this.commentManager = commentManager;
		return this;
	}

	public User build() {
		return new User(name, vehicleManager, routeManager, inscriptionManager, scoreManager, commentManager);
	}

}
