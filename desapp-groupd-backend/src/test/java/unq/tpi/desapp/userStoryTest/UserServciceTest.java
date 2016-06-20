package unq.tpi.desapp.userStoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import unq.tpi.desapp.builders.RouteBuilder;
import unq.tpi.desapp.builders.UserBuilder;
import unq.tpi.desapp.builders.VehicleBuilder;
import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.Vehicle;
import unq.tpi.desapp.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class UserServciceTest {

	@Autowired
	private UserService userService;

	@Test
	public void mappingTest() {

		User user = new UserBuilder().setName("Pepe").addAllManagers().build();

		userService.save(user);

		List<User> listOfSavedObjects = userService.retriveAll();
		assertFalse(listOfSavedObjects.isEmpty());
		assertEquals(listOfSavedObjects.size(), 1);
		assertEquals(listOfSavedObjects.get(0).getName(), "Pepe");

	}

	@Test
	public void addRouteToUser() throws Exception {
		Vehicle vehicle = new VehicleBuilder().build();
		User user = new UserBuilder().setName("Pepe").addAllManagers().build();
		
		userService.save(user);
		user = userService.getRepository().findAll().get(0);
		userService.addNewVehicle(user.getId(), vehicle);
		
		vehicle = userService.getVehicles(user.getId(), 1, 15).get(0);
		
		Route route = new RouteBuilder()
				.setVehicle(vehicle)
				.build();
		
		userService.addRouteToUser(user.getId(), route);
		assertEquals(1, userService.getRoutes(user.getId(), 1, 50).size());
	}

	@Before
	public void setUp() {
		userService.retriveAll().stream().forEach(user -> userService.delete(user));
	}

	@After
	public void tearDown() {
		userService.retriveAll().stream().forEach(user -> userService.delete(user));
	}
}
