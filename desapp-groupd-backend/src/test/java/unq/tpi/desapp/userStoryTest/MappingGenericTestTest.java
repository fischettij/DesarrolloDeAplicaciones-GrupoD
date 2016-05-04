package unq.tpi.desapp.userStoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import unq.tpi.desapp.builders.RouteBuilder;
import unq.tpi.desapp.builders.RoutineBuilder;
import unq.tpi.desapp.builders.UserBuilder;
import unq.tpi.desapp.model.DayOfWeek;
import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class MappingGenericTestTest {

	@Autowired
	private UserService userService;

	@Test
	public void mappingTest() {

		User user = new UserBuilder().setName("Pepe").build();

		userService.save(user);

		List<User> listOfSavedObjects = userService.retriveAll();
		assertFalse(listOfSavedObjects.isEmpty());
		assertEquals(listOfSavedObjects.size(), 1);
		assertEquals(listOfSavedObjects.get(0).getId(), (Long) 1l);

	}

	@Test
	public void addRoutToUser(){
		Route route = new RouteBuilder()
				.setStartingPoint("Calle 1")
				.setEndingPoint("Calle2")
				.setRoutine(
						new RoutineBuilder().
								setStatingDate(new LocalDate())
								.setEndDate(new LocalDate())
								.setDaysOfWeek(new ArrayList<DayOfWeek>() {{
									add(new DayOfWeek("Lunes"));
								}}).build()).build();
		User user = new UserBuilder().setName("Pepe").build();
		userService.save(user);
		userService.addRouteToUser(user,route);
	}

	@After
	public void tearDown(){
		userService.retriveAll().stream().forEach(user -> userService.delete(user));
	}
}
