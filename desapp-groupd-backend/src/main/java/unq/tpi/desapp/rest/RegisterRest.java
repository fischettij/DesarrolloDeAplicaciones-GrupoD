package unq.tpi.desapp.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import unq.tpi.desapp.model.RegisterUser;
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
	@Path("/register")
	@Produces("application/json")
	public void register(LoginUser loginUser) {
		getRegisterUserService().register(loginUser);
	}

}
