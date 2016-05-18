package unq.tpi.desapp.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.request.LoginUser;
import unq.tpi.desapp.services.RegisterUserService;

@Path("/logins")
public class LoginRest {

	private RegisterUserService registerUserService;

	public RegisterUserService getRegisterUserService() {
		return registerUserService;
	}

	public void setRegisterUserService(RegisterUserService registerUserService) {
		this.registerUserService = registerUserService;
	}

	@POST
	@Path("/login")
	@Produces("application/json")
	public User login(LoginUser loginUser) {
		return getRegisterUserService().login(loginUser);
	}

}
