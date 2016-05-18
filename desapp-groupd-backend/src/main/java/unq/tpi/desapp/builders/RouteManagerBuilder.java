package unq.tpi.desapp.builders;

import java.util.ArrayList;
import java.util.List;

import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.manager.RouteManager;

public class RouteManagerBuilder {

	private List<Route> routes;

	public RouteManagerBuilder() {
		this.routes = new ArrayList<Route>();
	}

	public RouteManagerBuilder setRoutes(List<Route> routes) {
		this.routes = routes;
		return this;
	}

	public RouteManager build() {
		return new RouteManager(routes);
	}

}
