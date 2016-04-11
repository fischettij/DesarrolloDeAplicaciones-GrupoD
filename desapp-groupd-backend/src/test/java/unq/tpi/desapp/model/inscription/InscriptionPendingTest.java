package unq.tpi.desapp.model.inscription;

import static org.mockito.Mockito.*;

import org.junit.Test;

import unq.tpi.desapp.model.Inscription;

public class InscriptionPendingTest {

	@Test
	public void testAccepted() {
		Inscription mockInscription = mock(Inscription.class);

		InscriptionPending inscriptionPending = new InscriptionPending();

		inscriptionPending.accepted(mockInscription);
		verify(mockInscription).setInscriptionState(any(InscriptionAccepted.class));
	}

	@Test
	public void testSubscriptionRequestDenied() {
		Inscription mockInscription = mock(Inscription.class);

		InscriptionPending inscriptionPending = new InscriptionPending();

		inscriptionPending.subscriptionRequestDenied(mockInscription);
		verifyZeroInteractions(mockInscription);
	}

}
