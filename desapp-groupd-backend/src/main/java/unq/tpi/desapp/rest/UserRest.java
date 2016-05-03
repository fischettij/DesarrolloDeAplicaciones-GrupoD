package unq.tpi.desapp.rest;

import java.util.List;

import java.util.List;
import java.util.Set;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.commons.lang.StringUtils;
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
	
}
