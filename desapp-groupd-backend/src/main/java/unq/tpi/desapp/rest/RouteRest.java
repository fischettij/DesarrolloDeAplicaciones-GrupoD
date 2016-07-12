package unq.tpi.desapp.rest;

import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.SubscriptionRequest;
import unq.tpi.desapp.services.RouteService;
import unq.tpi.desapp.services.request.RequestRoute;

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
	@Path("/lookfor/{page}")
	@Produces("application/json")
	@Consumes("application/json")
	public List<Route> lookForRoutes(@PathParam("page") final Integer page, RequestRoute requestRoute) {
		return getRouteService().lookForRoutes(requestRoute, page, 10);
	}
	
	@GET
	@Path("/subscriptionrequests/{id}")
	@Produces("application/json")
	public List<SubscriptionRequest> subscriptionFor(@PathParam("id") final Long id) {
		return getRouteService().subscriptionFor(id);
	}

	@POST
	@Path("/howMuchSearchRoutes")
	@Consumes("application/json")
	@Produces("application/json")
	public Integer howMuchSearchRoutes(RequestRoute requestRoute) {
		return getRouteService().getCountSearchRoutesFor(requestRoute, 10);
	}
	
}
