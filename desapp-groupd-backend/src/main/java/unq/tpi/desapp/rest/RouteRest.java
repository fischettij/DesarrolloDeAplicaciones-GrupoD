package unq.tpi.desapp.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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

	@POST
	@Path("/lookfor")
	@Produces("application/json")
	@Consumes("application/json")
	public List<Route> lookForRoutes(RequestRoute requestRoute) {
		return getRouteService().lookForRoutes(requestRoute);
	}

}
