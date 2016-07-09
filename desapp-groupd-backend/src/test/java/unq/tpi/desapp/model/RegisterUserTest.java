package unq.tpi.desapp.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import unq.tpi.desapp.services.request.LoginUser;

public class RegisterUserTest {

	@Test
	public void testAccessing() {
		User user = mock(User.class);
		RegisterUser registerUser = new RegisterUser("asd@asd", "password", user);
		assertEquals(registerUser.getEmail(), "asd@asd");
		assertEquals(registerUser.getPassword(), "password");
		assertEquals(registerUser.getUser(), user);
	}

	@Test
	public void testIsARegisterUserWhenIsTheSame(){
		User user = mock(User.class);
		RegisterUser registerUser = new RegisterUser("asd@asd", "password", user);
		assertTrue(registerUser.is(registerUser));
	}
	
	@Test
	public void testIsARegisterUserWhenOnlyEmailIsTheSame(){
		User user = mock(User.class);
		RegisterUser registerUser = new RegisterUser("asd@asd", "password", user);
		RegisterUser anotherRegisterUser = new RegisterUser("asd@asd", "password2", user);
		assertFalse(registerUser.is(anotherRegisterUser));
	}
	
	@Test
	public void testIsARegisterUserWhenAreDifferent(){
		User user = mock(User.class);
		RegisterUser registerUser = new RegisterUser("asd@asd", "password", user);
		RegisterUser anotherRegisterUser = new RegisterUser("ddd@ddd", "password2", user);
		assertFalse(registerUser.is(anotherRegisterUser));
	}
	
	@Test
	public void testIsALoginUserWhenIsTheSame(){
		User user = mock(User.class);
		RegisterUser registerUser = new RegisterUser("asd@asd", "password", user);
		LoginUser mockLoginUser = mock(LoginUser.class);
		when(mockLoginUser.getEmail()).thenReturn("asd@asd");
		when(mockLoginUser.getPassword()).thenReturn("password");
		assertTrue(registerUser.is(mockLoginUser));
	}
	
	@Test
	public void testIsALoginUserWhenOnlyEmailIsTheSame(){
		User user = mock(User.class);
		RegisterUser registerUser = new RegisterUser("asd@asd", "password", user);
		LoginUser mockLoginUser = mock(LoginUser.class);
		when(mockLoginUser.getEmail()).thenReturn("asd@asd");
		when(mockLoginUser.getPassword()).thenReturn("password2");
		assertFalse(registerUser.is(mockLoginUser));
	}
	
	@Test
	public void testIsALoginUserWhenAreDifferent(){
		User user = mock(User.class);
		RegisterUser registerUser = new RegisterUser("asd@asd", "password", user);
		LoginUser mockLoginUser = mock(LoginUser.class);
		when(mockLoginUser.getEmail()).thenReturn("ddd@ddd");
		when(mockLoginUser.getPassword()).thenReturn("password2");
		assertFalse(registerUser.is(mockLoginUser));
	}
	
}
