package unq.tpi.desapp.userStoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import unq.tpi.desapp.builders.LoginUserBuilder;
import unq.tpi.desapp.exception.NotFoundException;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.request.LoginUser;
import unq.tpi.desapp.services.RegisterUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class RegisterUserServiceTest {

	@Autowired
	private RegisterUserService registerUserService;

	@Test
	public void mappingTest() throws NotFoundException {

		LoginUser loginUser = new LoginUserBuilder().setEmail("lala@lala.com").setPassword("supersecreto")
				.setName("Pepe").build();

		registerUserService.register(loginUser);
		assertEquals(registerUserService.retriveAll().size(), 1);

		User userLogin = registerUserService.login(loginUser);
		assertEquals(userLogin.getName(), "Pepe");

	}

	@Test(expected = RuntimeException.class)
	public void registerTwoTimesTheSameUser() {

		LoginUser loginUser = new LoginUserBuilder().setEmail("lala@lala.com").setPassword("supersecreto")
				.setName("Pepe").build();

		registerUserService.register(loginUser);
		assertEquals(registerUserService.retriveAll().size(), 1);
		registerUserService.register(loginUser);

	}

	@Test(expected = NotFoundException.class)
	public void loginWithOutUser() throws NotFoundException {

		assertTrue(registerUserService.retriveAll().isEmpty());

		LoginUser loginUser = new LoginUserBuilder().setEmail("lala@lala.com").setPassword("supersecreto").build();
		registerUserService.login(loginUser);

	}

	@Before
	public void setUp() {
		registerUserService.retriveAll().stream().forEach(user -> registerUserService.delete(user));
	}

	@After
	public void tearDown() {
		registerUserService.retriveAll().stream().forEach(user -> registerUserService.delete(user));
	}
}