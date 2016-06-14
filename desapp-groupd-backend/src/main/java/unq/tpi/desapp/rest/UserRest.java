package unq.tpi.desapp.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import unq.tpi.desapp.model.Product;
import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.Vehicle;
import unq.tpi.desapp.model.request.RequestRoute;
import unq.tpi.desapp.services.UserService;

@Path("/users")
public class UserRest {

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@GET
	@Path("/all")
	@Produces("application/json")
	public List<User> getUsers() {
		return getUserService().retriveAll();
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public User getUser(@PathParam("id") final Long id) {
		return getUserService().getUser(id);
	}

	@GET
	@Path("/{id}/vehicles/{page}")
	@Produces("application/json")
	public List<Vehicle> getVehicles(@PathParam("id") final Long id, @PathParam("page") final Integer page) {
		return getUserService().getVehicles(id, page, 20);
	}

	@POST
	@Path("/{id}/newvehicle")
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addVehicle(@PathParam("id") final Long id, Vehicle vehicle) {
		try {
			getUserService().addNewVehicle(id, vehicle);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@GET
	@Path("/like/{userName}")
	@Produces("application/json")
	public List<User> getUsersLike(@PathParam("userName") final String userName) {
		return getUserService().getUsersLike(userName);
	}

	@POST
	@Path("/{id}/newroute")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addRoute(@PathParam("id") final Long id, RequestRoute requestRoute) {
		try {
			getUserService().addNewRoute(id, requestRoute);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@GET
	@Path("/{id}/routes/{page}")
	@Produces("application/json")
	public List<Route> getRoutes(@PathParam("id") final Long id, @PathParam("page") final Integer page) {
		return getUserService().getRoutes(id, page, 20);
	}

	@POST
	@Path("/{id}/newproduct")
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProduct(@PathParam("id") final Long id, Product product) {
		try {
			getUserService().addNewProduct(id, product);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}

	@GET
	@Path("/{id}/products/{page}")
	@Produces("application/json")
	public List<Product> getProducts(@PathParam("id") final Long id, @PathParam("page") final Integer page) {
		return getUserService().getProducts(id, page, 20);
	}

	@POST
	@Path("/{id}/suscribeRoute/{idRoute}/from/{idOwner}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response subscribeToRoute(@PathParam("id") final Long id, @PathParam("idRoute") final Long idRoute,
			@PathParam("idOwner") final Long idOwner) {
		try {
			getUserService().subscribeToRoute(id, idRoute,idOwner);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
	
	@POST
	@Path("/{id}/removeproduct")
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response removeProduct(@PathParam("id") final Long id, Product product) {
		try {
			getUserService().removeProduct(id, product);
			return Response.ok().build();
		}catch (Exception e) {
			return Response.serverError().build();
		}		
	}
	
}
