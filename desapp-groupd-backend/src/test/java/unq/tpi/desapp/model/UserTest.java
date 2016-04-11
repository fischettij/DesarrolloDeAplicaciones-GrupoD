package unq.tpi.desapp.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import unq.tpi.desapp.builders.UserBuilder;
import unq.tpi.desapp.model.Inscription;
import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.Vehicle;

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

	@Test
	public void testSubscriptionRequestAccepted() {
		Inscription mockInscription = mock(Inscription.class);
		Route mockRoute = mock(Route.class);
		when(mockInscription.contains(mockRoute)).thenReturn(true);

		User user = new UserBuilder().setInscriptions(new ArrayList<Inscription>(Arrays.asList(mockInscription)))
				.build();

		user.subscriptionRequestAccepted(mockRoute);
		verify(mockInscription).accepted();
	}

	@Test(expected = RuntimeException.class)
	public void testSubscriptionRequestAcceptedWithoutInscription() {
		Inscription mockInscription = mock(Inscription.class);
		Route mockRoute = mock(Route.class);
		when(mockInscription.contains(mockRoute)).thenReturn(true);

		User user = new UserBuilder().build();

		user.subscriptionRequestAccepted(mockRoute);
	}

	@Test(expected = RuntimeException.class)
	public void testSubscriptionRequestAcceptedWithDiferentRoute() {
		Inscription mockInscription = mock(Inscription.class);
		Route mockRoute = mock(Route.class);
		when(mockInscription.contains(mockRoute)).thenReturn(true);

		User user = new UserBuilder().build();

		user.subscriptionRequestAccepted(mock(Route.class));
	}

	@Test
	public void testSubscriptionRequestDenied() {
		Inscription mockInscription = mock(Inscription.class);
		Route mockRoute = mock(Route.class);
		when(mockInscription.contains(mockRoute)).thenReturn(true);

		User user = new UserBuilder().setInscriptions(new ArrayList<Inscription>(Arrays.asList(mockInscription)))
				.build();

		user.subscriptionRequestDenied(mockRoute);
		verify(mockInscription).subscriptionRequestDenied();
	}

	@Test(expected = RuntimeException.class)
	public void testSubscriptionRequestDeniedWithoutInscription() {
		Route mockRoute = mock(Route.class);

		User user = new UserBuilder().build();

		user.subscriptionRequestDenied(mockRoute);
	}

	@Test(expected = RuntimeException.class)
	public void testSubscriptionRequestDeniedWithDiferentRoute() {
		Inscription mockInscription = mock(Inscription.class);
		Route mockRoute = mock(Route.class);
		when(mockInscription.contains(mockRoute)).thenReturn(true);

		User user = new UserBuilder().build();

		user.subscriptionRequestDenied(mock(Route.class));
	}

}
