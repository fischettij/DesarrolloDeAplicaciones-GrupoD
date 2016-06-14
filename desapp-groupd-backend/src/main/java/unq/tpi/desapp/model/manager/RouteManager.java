package unq.tpi.desapp.model.manager;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import unq.tpi.desapp.model.Route;

public class RouteManager extends Manager {

	private static final long serialVersionUID = 5717094686794873317L;

	@JsonIgnore
	private List<Route> routes;

	public RouteManager() {
	}

	public RouteManager(List<Route> routes) {
		super();
		this.routes = routes;
	}

	@JsonIgnore
	public List<Route> getRoutes() {
		return routes;
	}

	public void add(Route route) {
		this.routes.add(route);
	}

	public void remove(Route route) {
		this.routes.remove(route);
	}

	@JsonProperty
	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}

	public String getManager() {
		return "RouteManager";
	}

	public Route find(Long id) throws Exception {
		for (Route route: this.getRoutes()){
			if(route.getId().equals(id)){return route;}
		}
		throw new Exception();
	}

}
