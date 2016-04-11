package unq.tpi.desapp.model.subscription;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.junit.Test;

import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.SubscriptionRequest;
import unq.tpi.desapp.model.User;

public class SubscriptionAcceptedTest {

	@Test
	public void testAccepted() {
		SubscriptionRequest mockSubscriptionRequest = mock(SubscriptionRequest.class);
		Route mockRoute = mock(Route.class);

		SubscriptionAccepted subscriptionAccepted = new SubscriptionAccepted();

		subscriptionAccepted.accepted(mockSubscriptionRequest, mockRoute);
		verifyZeroInteractions(mockSubscriptionRequest);
		verifyZeroInteractions(mockRoute);
	}

	@Test
	public void testCanceled() {
		SubscriptionRequest mockSubscriptionRequest = mock(SubscriptionRequest.class);
		User mockUser = mock(User.class);
		when(mockSubscriptionRequest.getCandidate()).thenReturn(mockUser);
		Route mockRoute = mock(Route.class);

		SubscriptionAccepted subscriptionAccepted = new SubscriptionAccepted();

		subscriptionAccepted.canceled(mockSubscriptionRequest, mockRoute);

		verify(mockUser).subscriptionRequestDenied(mockRoute);
	}
}
