package unq.tpi.desapp.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

import unq.tpi.desapp.builders.UserBuilder;
import unq.tpi.desapp.model.manager.CommentManager;
import unq.tpi.desapp.model.manager.InscriptionManager;
import unq.tpi.desapp.model.manager.RouteManager;
import unq.tpi.desapp.model.manager.ScoreManager;
import unq.tpi.desapp.model.manager.VehicleManager;

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
		RouteManager mockRouteManager = mock(RouteManager.class);
		Route mockRoute = mock(Route.class);
		User user = new UserBuilder().setRouteManager(mockRouteManager).build();

		user.removeRoute(mockRoute);
		verify(mockRouteManager).remove(mockRoute);
	}

	@Test
	public void testAddNewVehicle() throws Exception {
		User user = new UserBuilder().build();
		assertTrue(user.getVehicles().isEmpty());

		Vehicle mockVehicle = mock(Vehicle.class);
		user.addVehicle(mockVehicle);

		assertTrue(user.getVehicles().contains(mockVehicle));
	}

	@Test
	public void testRemoveVehicle() {
		VehicleManager mockVehicleManager = mock(VehicleManager.class);
		Vehicle mockVehicle = mock(Vehicle.class);
		User user = new UserBuilder().setVehicleManager(mockVehicleManager).build();

		user.removeVehicle(mockVehicle);
		verify(mockVehicleManager).remove(mockVehicle);
	}

	@Test
	public void testAddNewInscription() throws Exception {
		User user = new UserBuilder().build();
		assertTrue(user.getInscriptions().isEmpty());

		Inscription mockInscription = mock(Inscription.class);
		user.addInscription(mockInscription);

		assertTrue(user.getInscriptions().contains(mockInscription));
	}

	@Test
	public void testRemoveInscription() {
		Inscription mockInscription = mock(Inscription.class);
		InscriptionManager mockInscriptionManager = mock(InscriptionManager.class);
		User user = new UserBuilder().setInscriptionManager(mockInscriptionManager).build();

		user.removeInscription(mockInscription);
		verify(mockInscriptionManager).remove(mockInscription);
	}

	@Test
	public void testSubscriptionRequestAccepted() {
		InscriptionManager mockInscriptionManager = mock(InscriptionManager.class);
		Route mockRoute = mock(Route.class);
		User user = new UserBuilder().setInscriptionManager(mockInscriptionManager).build();

		user.subscriptionRequestAccepted(mockRoute);
		verify(mockInscriptionManager).requestAccepted(mockRoute);
	}

	@Test
	public void testSubscriptionRequestDenied() {
		InscriptionManager mockInscriptionManager = mock(InscriptionManager.class);
		Route mockRoute = mock(Route.class);
		User user = new UserBuilder().setInscriptionManager(mockInscriptionManager).build();

		user.subscriptionRequestDenied(mockRoute);
		verify(mockInscriptionManager).requestDenied(mockRoute);
	}

	@Test
	public void testAddCommentedPoint() {
		CommentedPoint mockCommentedPoint = mock(CommentedPoint.class);
		ScoreManager mockScoreManager = mock(ScoreManager.class);
		User user = new UserBuilder().setScoreManager(mockScoreManager).build();

		user.addCommentedPoint(mockCommentedPoint);
		verify(mockScoreManager).add(mockCommentedPoint);
	}

	@Test
	public void testSendCommentedPoint() {
		User mockUserReceiver = mock(User.class);
		CommentedPoint mockCommentedPoint = mock(CommentedPoint.class);
		ScoreManager mockScoreManager = mock(ScoreManager.class);
		User user = new UserBuilder().setScoreManager(mockScoreManager).build();

		user.sendCommentedPoint(mockUserReceiver, mockCommentedPoint);
		verify(mockUserReceiver).addCommentedPoint(mockCommentedPoint);
	}

	@Test
	public void testAddComment() {
		Comment mockComment = mock(Comment.class);
		CommentManager mockCommentManager = mock(CommentManager.class);
		User user = new UserBuilder().setCommentManager(mockCommentManager).build();

		user.addComment(mockComment);
		verify(mockCommentManager).add(mockComment);
	}
}
