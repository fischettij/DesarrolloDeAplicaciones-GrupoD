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
import unq.tpi.desapp.model.manager.InscriptionManager;

public class SubscriptionPendingTest {

	@Test
	public void testAccepted() {
		User mockUser = mock(User.class);
		InscriptionManager mockManager = mock(InscriptionManager.class);
		SubscriptionRequest mockSubscriptionRequest = mock(SubscriptionRequest.class);
		
		when(mockSubscriptionRequest.getCandidate()).thenReturn(mockUser);
		when(mockUser.managerImplementing(InscriptionManager.class)).thenReturn(mockManager);
		Route mockRoute = mock(Route.class);

		SubscriptionPending subscriptionPending = new SubscriptionPending();

		subscriptionPending.accepted(mockSubscriptionRequest, mockRoute);
		verify(mockSubscriptionRequest).setSubscriptionState(any(SubscriptionAccepted.class));
		verify(mockUser).managerImplementing(InscriptionManager.class);
		verify(mockManager).requestAccepted(mockRoute);
		verifyZeroInteractions(mockRoute);
	}

	@Test
	public void testCanceled() {
		User mockUser = mock(User.class);
		InscriptionManager mockManager = mock(InscriptionManager.class);
		SubscriptionRequest mockSubscriptionRequest = mock(SubscriptionRequest.class);
		
		when(mockSubscriptionRequest.getCandidate()).thenReturn(mockUser);
		when(mockUser.managerImplementing(InscriptionManager.class)).thenReturn(mockManager);
		Route mockRoute = mock(Route.class);

		SubscriptionPending subscriptionPending = new SubscriptionPending();

		subscriptionPending.canceled(mockSubscriptionRequest, mockRoute);

		verify(mockUser).managerImplementing(InscriptionManager.class);
		verify(mockManager).requestDenied(mockRoute);
	}
}
