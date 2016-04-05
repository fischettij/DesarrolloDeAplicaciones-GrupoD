package unq.tpi.desapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.Arrays;

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

	@Test
	public void testAddNewRoute() {
		User user = new UserBuilder().build();
		assertTrue(user.getRoutes().isEmpty());

		Route mockRoute = mock(Route.class);
		user.addRoute(mockRoute);

		assertTrue(user.getRoutes().contains(mockRoute));
	}

	@Test
	public void testRemoveRoute() {
		Route mockRoute = mock(Route.class);
		User user = new UserBuilder().setRoutes(new ArrayList<Route>(Arrays.asList(mockRoute))).build();

		assertTrue(user.getRoutes().contains(mockRoute));

		user.removeRoute(mockRoute);

		assertTrue(user.getRoutes().isEmpty());
	}

	@Test
	public void testAddNewVehicle() {
		User user = new UserBuilder().build();
		assertTrue(user.getVehicles().isEmpty());

		Vehicle mockVehicle = mock(Vehicle.class);
		user.addVehicle(mockVehicle);

		assertTrue(user.getVehicles().contains(mockVehicle));
	}

	@Test
	public void testRemoveVehicle() {
		Vehicle mockVehicle = mock(Vehicle.class);
		User user = new UserBuilder().setVehicles(new ArrayList<Vehicle>(Arrays.asList(mockVehicle))).build();

		assertTrue(user.getVehicles().contains(mockVehicle));

		user.removeVehicle(mockVehicle);

		assertTrue(user.getVehicles().isEmpty());
	}

	@Test
	public void testAddNewInscription() {
		User user = new UserBuilder().build();
		assertTrue(user.getInscriptions().isEmpty());

		Inscription mockInscription = mock(Inscription.class);
		user.addInscription(mockInscription);

		assertTrue(user.getInscriptions().contains(mockInscription));
	}

	@Test
	public void testRemoveInscription() {
		Inscription mockInscription = mock(Inscription.class);
		User user = new UserBuilder().setInscriptions(new ArrayList<Inscription>(Arrays.asList(mockInscription)))
				.build();

		assertTrue(user.getInscriptions().contains(mockInscription));

		user.removeInscription(mockInscription);

		assertTrue(user.getInscriptions().isEmpty());
	}

}
