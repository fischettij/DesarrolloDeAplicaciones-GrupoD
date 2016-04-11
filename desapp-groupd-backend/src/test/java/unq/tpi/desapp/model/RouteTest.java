package unq.tpi.desapp.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import unq.tpi.desapp.builders.RouteBuilder;
import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.SubscriptionRequest;

public class RouteTest {

	@Test
	public void testAccessing() {
		Routine mockRoutine = mock(Routine.class);

		Route route = new RouteBuilder().setStartingPoint("Avenida Mitre 400").setEndingPoint("Alberdi 30")
				.setRoutine(mockRoutine).build();

		assertEquals(route.getStartingPoint(), "Avenida Mitre 400");
		assertEquals(route.getEndingPoint(), "Alberdi 30");
		assertEquals(route.getRoutine(), mockRoutine);
		assertTrue(route.getSubscriptionRequests().isEmpty());
	}

	@Test
	public void testAddSubscription() {
		SubscriptionRequest mockSubscriptionRequest = mock(SubscriptionRequest.class);

		Route route = new RouteBuilder().build();

		route.addSubscriptionRequest(mockSubscriptionRequest);

		assertFalse(route.getSubscriptionRequests().isEmpty());
		assertEquals(route.getSubscriptionRequests().size(), 1);
	}

	@Test
	public void testSubscriptionRequestAccepted() {
		SubscriptionRequest mockSubscriptionRequest = mock(SubscriptionRequest.class);

		Route route = new RouteBuilder().setSubscriptionRequests(Arrays.asList(mockSubscriptionRequest)).build();

		route.acceptedSubscriptionRequest(mockSubscriptionRequest);

		verify(mockSubscriptionRequest).accepted(route);
	}

	@Test
	public void testSubscriptionRequestAcceptedWithoutSubscription() {
		SubscriptionRequest mockSubscriptionRequest = mock(SubscriptionRequest.class);

		Route route = new RouteBuilder().build();

		route.acceptedSubscriptionRequest(mockSubscriptionRequest);

		verify(mockSubscriptionRequest, never()).accepted(route);
	}

	@Test
	public void testCanceledSubscriptionRequest() {
		SubscriptionRequest mockSubscriptionRequest = mock(SubscriptionRequest.class);

		Route route = new RouteBuilder()
				.setSubscriptionRequests(new ArrayList<SubscriptionRequest>(Arrays.asList(mockSubscriptionRequest)))
				.build();

		assertEquals(route.getSubscriptionRequests().size(), 1);

		route.canceledSubscriptionRequest(mockSubscriptionRequest);

		verify(mockSubscriptionRequest).canceled(route);
		assertTrue(route.getSubscriptionRequests().isEmpty());

	}

	@Test
	public void testCanceledSubscriptionRequestWithoutSubscription() {
		SubscriptionRequest mockSubscriptionRequest = mock(SubscriptionRequest.class);

		Route route = new RouteBuilder().build();

		route.canceledSubscriptionRequest(mockSubscriptionRequest);

		verify(mockSubscriptionRequest, never()).canceled(route);
	}

}
