package unq.tpi.desapp;

import static org.junit.Assert.*;

import org.junit.Test;

import unq.tpi.desapp.builders.UserBuilder;

public class UserTest {

	@Test
	public void testAccessing() {
		User user = new UserBuilder().setName("Usuario1").build();
		assertEquals(user.getName(), "Usuario1");
		assertTrue(user.getRoutes().isEmpty());
		assertTrue(user.getInscriptions().isEmpty());
		assertTrue(user.getVehicles().isEmpty());
	}

}
