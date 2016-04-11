package unq.tpi.desapp.model;

import static org.junit.Assert.*;

import org.junit.Test;

import unq.tpi.desapp.builders.InscriptionBuilder;
import unq.tpi.desapp.model.Inscription;
import unq.tpi.desapp.model.inscription.InscriptionState;

import static org.mockito.Mockito.*;

public class InscriptionTest {

	@Test
	public void testAccessing() {
		Route mockRoute = mock(Route.class);
		InscriptionState mockInscriptionState = mock(InscriptionState.class);
		Inscription inscription = new InscriptionBuilder().setRoute(mockRoute).setInscriptionState(mockInscriptionState)
				.build();

		assertEquals(inscription.getRoute(), mockRoute);
		assertEquals(inscription.getInscriptionState(), mockInscriptionState);
	}

	@Test
	public void testContainsWithTheRoute() {
		Route mockRoute = mock(Route.class);
		Inscription inscription = new InscriptionBuilder().setRoute(mockRoute).build();

		assertTrue(inscription.contains(mockRoute));
	}

	@Test
	public void testContainsWithoutTheRoute() {
		Route mockRoute = mock(Route.class);
		Inscription inscription = new InscriptionBuilder().setRoute(mockRoute).build();

		assertFalse(inscription.contains(mock(Route.class)));
	}

	@Test
	public void testAccepted() {
		InscriptionState mockInscriptionState = mock(InscriptionState.class);
		Inscription inscription = new InscriptionBuilder().setInscriptionState(mockInscriptionState).build();

		inscription.accepted();

		verify(mockInscriptionState).accepted(inscription);

	}

	@Test
	public void testSubscriptionRequestDenied() {
		InscriptionState mockInscriptionState = mock(InscriptionState.class);
		Inscription inscription = new InscriptionBuilder().setInscriptionState(mockInscriptionState).build();

		inscription.subscriptionRequestDenied();

		verify(mockInscriptionState).subscriptionRequestDenied(inscription);

	}

}
