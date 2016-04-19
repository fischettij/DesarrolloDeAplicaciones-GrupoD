package unq.tpi.desapp.model.manager;

import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import unq.tpi.desapp.builders.InscriptionManagerBuilder;
import unq.tpi.desapp.model.Inscription;
import unq.tpi.desapp.model.Route;

public class InscriptionManagerTest {

	@Test
	public void testAddInscription() throws Exception {
		Inscription mockInscription = mock(Inscription.class);
		InscriptionManager inscriptionManager = new InscriptionManagerBuilder().build();
		assertTrue(inscriptionManager.getInscriptions().isEmpty());

		inscriptionManager.add(mockInscription);

		assertEquals(inscriptionManager.getInscriptions().size(), 1);
	}

	@Test(expected = Exception.class)
	public void testAddInscriptionTwoTimes() throws Exception {
		Inscription mockInscription = mock(Inscription.class);
		InscriptionManager inscriptionManager = new InscriptionManagerBuilder().build();
		assertTrue(inscriptionManager.getInscriptions().isEmpty());

		inscriptionManager.add(mockInscription);

		assertEquals(inscriptionManager.getInscriptions().size(), 1);
		inscriptionManager.add(mockInscription);
	}

	@Test
	public void testRemoveInscription() throws Exception {
		Inscription mockInscription = mock(Inscription.class);
		InscriptionManager inscriptionManager = new InscriptionManagerBuilder().build();
		assertTrue(inscriptionManager.getInscriptions().isEmpty());

		inscriptionManager.add(mockInscription);
		assertEquals(inscriptionManager.getInscriptions().size(), 1);

		inscriptionManager.remove(mockInscription);
		assertTrue(inscriptionManager.getInscriptions().isEmpty());
	}

	@Test
	public void testRequestAccepted() throws Exception {
		Route mockRoute = mock(Route.class);
		Inscription mockInscription = mock(Inscription.class);
		when(mockInscription.getRoute()).thenReturn(mockRoute);
		InscriptionManager inscriptionManager = new InscriptionManagerBuilder().build();
		inscriptionManager.add(mockInscription);

		inscriptionManager.requestAccepted(mockRoute);
		verify(mockInscription).accepted();
	}

	@Test
	public void testRequestDenied() throws Exception {
		Route mockRoute = mock(Route.class);
		Inscription mockInscription = mock(Inscription.class);
		when(mockInscription.getRoute()).thenReturn(mockRoute);
		InscriptionManager inscriptionManager = new InscriptionManagerBuilder().build();
		inscriptionManager.add(mockInscription);

		inscriptionManager.requestDenied(mockRoute);
		verify(mockInscription).subscriptionRequestDenied();
	}

}
