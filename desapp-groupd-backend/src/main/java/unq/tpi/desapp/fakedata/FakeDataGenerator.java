package unq.tpi.desapp.fakedata;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import unq.tpi.desapp.exception.NotFoundException;
import unq.tpi.desapp.model.DaysOfWeekEnum;
import unq.tpi.desapp.model.Product;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.Vehicle;
import unq.tpi.desapp.services.RegisterUserService;
import unq.tpi.desapp.services.UserService;
import unq.tpi.desapp.services.request.CommentedPointRequest;
import unq.tpi.desapp.services.request.LoginUser;
import unq.tpi.desapp.services.request.RequestRoute;

public class FakeDataGenerator  {
	
	private RegisterUserService registerUserService; 
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public RegisterUserService getRegisterUserService() {
		return registerUserService;
	}

	public void setRegisterUserService(RegisterUserService registerUserService) {
		this.registerUserService = registerUserService;
	}

	public void setUp() throws Exception{
		createAdminUser();
		createUsers();
		createProducts();
		addUsersVehicles();
		addRoutes();
		rateUsers();
	}	
	
	private void createUsers(){
		LoginUser newUser = new LoginUser("Leonardo DiCaprio","leo.dicaprio@hollywood.com","quieroUnOscar");
		getRegisterUserService().register(newUser);		
		newUser = new LoginUser("Megan Fox","fox@firefox.com","transformers");
		getRegisterUserService().register(newUser);		
		newUser = new LoginUser("Fernando Gago","ferchu@soyboca.com.ar","quieroLaCopa");
		getRegisterUserService().register(newUser);		
		newUser = new LoginUser("Julia Roberts","la.roberts@gmail.com","quieroUnOscar");
		getRegisterUserService().register(newUser);		
		newUser = new LoginUser("Julio Grondona","arse_capo@gmail.com","libertadores");
		getRegisterUserService().register(newUser);
	}	
	private User diCaprio() throws NotFoundException{return getRegisterUserService().login(new LoginUser("","leo.dicaprio@hollywood.com","quieroUnOscar"));}	
	private User meganFox() throws NotFoundException{return getRegisterUserService().login(new LoginUser("","fox@firefox.com","transformers"));}
	private User fernandoGago() throws NotFoundException{return getRegisterUserService().login(new LoginUser("","ferchu@soyboca.com.ar","quieroLaCopa"));}
	private User juliaRoberts() throws NotFoundException{return getRegisterUserService().login(new LoginUser("","la.roberts@gmail.com","quieroUnOscar"));}
	private User julioGrondona() throws NotFoundException{return getRegisterUserService().login(new LoginUser("","arse_capo@gmail.com","libertadores"));}
	
	private void createAdminUser(){
		LoginUser adminUser = new LoginUser("admin","admin@a.com","admin");
		getRegisterUserService().registerAdmin(adminUser);
	}
	
	private void createProducts() throws Exception {
		User user = getRegisterUserService().login(new LoginUser("", "admin@a.com", "admin"));
		getUserService().addNewProduct(user.getId(), new Product("Tv Led 32", 10000, 4));
		getUserService().addNewProduct(user.getId(), new Product("2x1 Cine 3D", 500, 30));
		getUserService().addNewProduct(user.getId(), new Product("40Lts YPF Infinia", 1000, 100));
		getUserService().addNewProduct(user.getId(), new Product("Cena Gratis", 9000, 24));
		getUserService().addNewProduct(user.getId(), new Product("Pendrive 16Gb", 800, 51));
	}
	
	private String randomVehicleIdentificationNumber(){
		Random rn = new Random();
		int n = 999 + 1;
		int i = rn.nextInt() % n;
		return String.valueOf(i);
	}
	
	private void addUsersVehicles() throws Exception{
		List<User> users = getUserService().retriveAll();		
		for (User user : users) {
			getUserService().addNewVehicle(user.getId(), new Vehicle("RWZ-".concat(randomVehicleIdentificationNumber()), "Twingo", 4));
			getUserService().addNewVehicle(user.getId(), new Vehicle("YVZ-".concat(randomVehicleIdentificationNumber()), "Ferrari Testarossa", 2));
			getUserService().addNewVehicle(user.getId(), new Vehicle("PRA-".concat(randomVehicleIdentificationNumber()), "Mustang 2016", 4));			
		}
	}
	
	private void addRoutes() throws NotFoundException{
		//Ruta de DiCaprio
		User user = diCaprio();
		Set<DaysOfWeekEnum> daySet = new TreeSet<DaysOfWeekEnum>();
		daySet.add(DaysOfWeekEnum.SUN);
		RequestRoute route = 
				new RequestRoute(	"Capital Federal, Ciudad Autónoma de Buenos Aires",
									"Universidad Nacional de Quilmes, Bernal, Buenos Aires",
									new Double("-34.603680"), 
									new Double("-58.381557"), 
									new Double("-34.706104"), 
									new Double("-58.277017"), 
									getUserService().getAllVehicles(user.getId()).get(0).getId(), 
									daySet);
		getUserService().addNewRoute(user.getId(), route);
		// Ruta de Megan Fox
		user = meganFox();
		daySet = new TreeSet<DaysOfWeekEnum>();
		daySet.add(DaysOfWeekEnum.THU);
		daySet.add(DaysOfWeekEnum.FRI);
		daySet.add(DaysOfWeekEnum.SAT);
		route = 
				new RequestRoute(	"Calle 148 y 8 berazategui",
									"El Bosque, Quilmes Oeste, Buenos Aires",
									new Double("-34.755692"), 
									new Double("-58.214016"), 
									new Double("-34.750719"), 
									new Double("-58.268984"), 
									getUserService().getAllVehicles(user.getId()).get(0).getId(), 
									daySet);
		getUserService().addNewRoute(user.getId(), route);
		// Ruta de Fernando Gago 
		user = fernandoGago();
		daySet = new TreeSet<DaysOfWeekEnum>();
		daySet.add(DaysOfWeekEnum.MON);
		daySet.add(DaysOfWeekEnum.TUE);
		daySet.add(DaysOfWeekEnum.WED);
		daySet.add(DaysOfWeekEnum.THU);
		daySet.add(DaysOfWeekEnum.FRI);
		route = 
				new RequestRoute(	"Hilton Buenos Aires",
									"La Bombonera - Brandsen, Buenos Aires", 
									new Double("-34.605719"), 
									new Double("-58.363661"),
									new Double("-34.635613"), 
									new Double("-58.364746"), 
									getUserService().getAllVehicles(user.getId()).get(0).getId(), 
									daySet);
		getUserService().addNewRoute(user.getId(), route);
		
		// Ruta de Julia Roberts
		user = juliaRoberts();
		daySet = new TreeSet<DaysOfWeekEnum>();
		daySet.add(DaysOfWeekEnum.FRI);
		daySet.add(DaysOfWeekEnum.SAT);
		daySet.add(DaysOfWeekEnum.MON);
		route = 
				new RequestRoute(	"Ezpeleta, Buenos Aires",
									"Teatro Ópera Allianz - Avenida Corrientes, Buenos Aires, Ciudad Autónoma de Buenos Aires",
									new Double("-34.748472"), 
									new Double("-58.238199"),
									new Double("-34.603803"), 
									new Double("-58.379083"), 
									getUserService().getAllVehicles(user.getId()).get(0).getId(), 
									daySet);
		getUserService().addNewRoute(user.getId(), route);
		// Ruta de Julio Grondona
		// RUTA 1
		user = julioGrondona();
		daySet.add(DaysOfWeekEnum.MON);
		daySet.add(DaysOfWeekEnum.TUE);
		daySet.add(DaysOfWeekEnum.WED);
		daySet.add(DaysOfWeekEnum.THU);
		daySet.add(DaysOfWeekEnum.FRI);
		route = 
				new RequestRoute(	"Av General Las Heras 2104, C1127AAQ CABA",
									"Asociación del Futbol Argentino - Viamonte, Buenos Aires, Ciudad Autónoma de Buenos Aires",
									new Double("-34.589144"), 
									new Double("-58.395096"),
									new Double("-34.600599"), 
									new Double("-58.386181"), 
									getUserService().getAllVehicles(user.getId()).get(0).getId(), 
									daySet);
		getUserService().addNewRoute(user.getId(), route);
		// RUTA 2
		daySet.add(DaysOfWeekEnum.MON);
		daySet.add(DaysOfWeekEnum.TUE);
		daySet.add(DaysOfWeekEnum.WED);
		daySet.add(DaysOfWeekEnum.THU);
		daySet.add(DaysOfWeekEnum.FRI);
		route = 
				new RequestRoute(	"Asociación del Futbol Argentino - Viamonte, Buenos Aires, Ciudad Autónoma de Buenos Aires",
									"Av General Las Heras 2104, C1127AAQ CABA",
									new Double("-34.600599"), 
									new Double("-58.386181"), 
									new Double("-34.589144"), 
									new Double("-58.395096"),
									getUserService().getAllVehicles(user.getId()).get(0).getId(), 
									daySet);
		getUserService().addNewRoute(user.getId(), route);
		// RUTA 3
		daySet.add(DaysOfWeekEnum.SAT);
		route = 
				new RequestRoute(	"Av General Las Heras 2104, C1127AAQ CABA",
									"Club Arsenal, Sarandí, Buenos Aires",
									new Double("-34.589144"), 
									new Double("-58.395096"),
									new Double("-34.678552"), 
									new Double("-58.340562"), 
									getUserService().getAllVehicles(user.getId()).get(0).getId(), 
									daySet);
		getUserService().addNewRoute(user.getId(), route);
		// RUTA 4
		daySet.add(DaysOfWeekEnum.SAT);
		route = 
				new RequestRoute(	"Club Arsenal, Sarandí, Buenos Aires",
									"Av General Las Heras 2104, C1127AAQ CABA",
									new Double("-34.678552"), 
									new Double("-58.340562"), 
									new Double("-34.589144"), 
									new Double("-58.395096"),
									getUserService().getAllVehicles(user.getId()).get(0).getId(), 
									daySet);
		getUserService().addNewRoute(user.getId(), route);
		// RUTA 4
		daySet.add(DaysOfWeekEnum.MON);
		route = 
				new RequestRoute(	"Av General Las Heras 2104, C1127AAQ CABA",
									"Lagos de Palermo - Avenida Infanta Isabel, Buenos Aires, Ciudad Autónoma de Buenos Aires",
									new Double("-34.589144"), 
									new Double("-58.395096"),
									new Double("-34.570936"), 
									new Double("-58.416426"), 
									getUserService().getAllVehicles(user.getId()).get(0).getId(), 
									daySet);
		getUserService().addNewRoute(user.getId(), route);
		// RUTA 5
		daySet.add(DaysOfWeekEnum.MON);
		route = 
				new RequestRoute(	"Lagos de Palermo - Avenida Infanta Isabel, Buenos Aires, Ciudad Autónoma de Buenos Aires",
									"Av General Las Heras 2104, C1127AAQ CABA",									
									new Double("-34.570936"), 
									new Double("-58.416426"), 
									new Double("-34.589144"), 
									new Double("-58.395096"),
									getUserService().getAllVehicles(user.getId()).get(0).getId(), 
									daySet);
		getUserService().addNewRoute(user.getId(), route);		
	}
	
	public void rateUsers() throws NotFoundException{
		// Puntos a Megan Fox
		getUserService().rateUser(	meganFox().getId(),
									new CommentedPointRequest(	diCaprio().getId(), 
																diCaprio().getName(), 
																false, 
																"Buenas rutas para ir a bailar"));
		getUserService().rateUser(	meganFox().getId(),
									new CommentedPointRequest(	julioGrondona().getId(), 
																julioGrondona().getName(), 
																false, 
																"Maneja Bien"));
		getUserService().rateUser(	meganFox().getId(),
									new CommentedPointRequest(	juliaRoberts().getId(), 
																juliaRoberts().getName(), 
																false, 
																"Muy simpatica para ir charnaldo"));
		getUserService().rateUser(	meganFox().getId(),
									new CommentedPointRequest(	fernandoGago().getId(), 
																fernandoGago().getName(), 
																true, 
																"No esquiva los posos"));
		// Puntos a Di Cario
		getUserService().rateUser(	diCaprio().getId(),
									new CommentedPointRequest(	juliaRoberts().getId(), 
																juliaRoberts().getName(), 
																false, 
																"Buen conductor y guapo"));
		getUserService().rateUser(	diCaprio().getId(),
									new CommentedPointRequest(	julioGrondona().getId(),
																julioGrondona().getName(), 
																false, 
																"Es copado"));
	}
}

