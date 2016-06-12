package unq.tpi.desapp.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.request.RequestRoute;
import unq.tpi.desapp.services.RouteService;

@Path("/routes")
public class RouteRest {

	private RouteService routeService;

	public RouteService getRouteService() {
		return routeService;
	}

	public void setRouteService(RouteService routeService) {
		this.routeService = routeService;
	}

	@GET
	@Path("/lookFor/{requestRoute}")
	@Produces("application/json")
	public List<Route> lookForRoutes(@PathParam("requestRoute") final RequestRoute requestRoute) {
		return getRouteService().lookForRoutes(requestRoute);
	}

}
