package unq.tpi.desapp.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import unq.tpi.desapp.model.request.LoginUser;
import unq.tpi.desapp.services.RegisterUserService;

@Path("/register")
public class RegisterRest {

	private RegisterUserService registerUserService;

	public RegisterUserService getRegisterUserService() {
		return registerUserService;
	}

	public void setRegisterUserService(RegisterUserService registerUserService) {
		this.registerUserService = registerUserService;
	}

	@POST
	@Path("/newuser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response register(LoginUser loginUser) {
		try {
			getRegisterUserService().register(loginUser);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().build();
		}

	}

}