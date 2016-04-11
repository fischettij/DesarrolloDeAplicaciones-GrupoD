package unq.tpi.desapp.model.inscription;

import static org.mockito.Mockito.*;

import org.junit.Test;

import unq.tpi.desapp.model.Inscription;

public class InscriptionAcceptedTest {

	@Test
	public void testAccepted() {
		Inscription mockInscription = mock(Inscription.class);

		InscriptionAccepted inscriptionAccepted = new InscriptionAccepted();

		inscriptionAccepted.accepted(mockInscription);
		verifyZeroInteractions(mockInscription);
	}

	@Test
	public void testSubscriptionRequestDenied() {
		Inscription mockInscription = mock(Inscription.class);

		InscriptionAccepted inscriptionAccepted = new InscriptionAccepted();

		inscriptionAccepted.subscriptionRequestDenied(mockInscription);
		verifyZeroInteractions(mockInscription);
	}

}
