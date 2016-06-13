package unq.tpi.desapp.model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

import unq.tpi.desapp.builders.SubscriptionRequestBuilder;
import unq.tpi.desapp.model.subscription.SubscriptionState;

public class SubscriptionRequestTest {

	@Test
	public void testAccessing() {
		User mockUser = mock(User.class);
		SubscriptionState mockSubscriptionState = mock(SubscriptionState.class);

		SubscriptionRequest subscriptionRequest = new SubscriptionRequestBuilder().setCandidate(mockUser)
				.setSubscriptionState(mockSubscriptionState).build();

		assertEquals(subscriptionRequest.getCandidate(), mockUser);
		assertEquals(subscriptionRequest.getSubscriptionState(), mockSubscriptionState);
	}

	@Test
	public void testAccepted() {
		SubscriptionState mockSubscriptionState = mock(SubscriptionState.class);
		Route mockRoute = mock(Route.class);

		SubscriptionRequest subscriptionRequest = new SubscriptionRequestBuilder()
				.setSubscriptionState(mockSubscriptionState).build();

		subscriptionRequest.accepted(mockRoute);

		verify(mockSubscriptionState).accepted(subscriptionRequest, mockRoute);

	}

	@Test
	public void testCanceled() {
		SubscriptionState mockSubscriptionState = mock(SubscriptionState.class);
		Route mockRoute = mock(Route.class);

		SubscriptionRequest subscriptionRequest = new SubscriptionRequestBuilder()
				.setSubscriptionState(mockSubscriptionState).build();

		subscriptionRequest.canceled(mockRoute);

		verify(mockSubscriptionState).canceled(subscriptionRequest, mockRoute);

	}

}
