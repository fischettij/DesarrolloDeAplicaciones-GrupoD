package unq.tpi.desapp.model.subscription;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.junit.Test;

import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.SubscriptionRequest;
import unq.tpi.desapp.model.User;

public class SubscriptionPendingTest {

	@Test
	public void testAccepted() {
		SubscriptionRequest mockSubscriptionRequest = mock(SubscriptionRequest.class);
		User mockUser = mock(User.class);
		when(mockSubscriptionRequest.getCandidate()).thenReturn(mockUser);
		Route mockRoute = mock(Route.class);

		SubscriptionPending subscriptionPending = new SubscriptionPending();

		subscriptionPending.accepted(mockSubscriptionRequest, mockRoute);
		verify(mockSubscriptionRequest).setSubscriptionState(any(SubscriptionAccepted.class));
		verify(mockUser).subscriptionRequestAccepted(mockRoute);
		verifyZeroInteractions(mockRoute);
	}

	@Test
	public void testCanceled() {
		SubscriptionRequest mockSubscriptionRequest = mock(SubscriptionRequest.class);
		User mockUser = mock(User.class);
		when(mockSubscriptionRequest.getCandidate()).thenReturn(mockUser);
		Route mockRoute = mock(Route.class);

		SubscriptionPending subscriptionPending = new SubscriptionPending();

		subscriptionPending.canceled(mockSubscriptionRequest, mockRoute);

		verify(mockUser).subscriptionRequestDenied(mockRoute);
	}
}
