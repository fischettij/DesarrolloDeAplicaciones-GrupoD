package unq.tpi.desapp.model.manager;

import java.util.List;

import unq.tpi.desapp.model.Entity;
import unq.tpi.desapp.model.Route;

public class RouteManager extends Manager {

	private List<Route> routes;
	
	public RouteManager() {
	}

	public RouteManager(List<Route> routes) {
		super();
		this.routes = routes;
	}

	public List<Route> getRoutes() {
		return routes;
	}

	public void add(Route route) {
		this.routes.add(route);
	}

	public void remove(Route route) {
		this.routes.remove(route);
	}

	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

}
