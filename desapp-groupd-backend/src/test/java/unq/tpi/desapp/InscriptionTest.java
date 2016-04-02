package unq.tpi.desapp;

import static org.junit.Assert.*;

import org.junit.Test;

import unq.tpi.desapp.builders.InscriptionBuilder;
import static org.mockito.Mockito.*;

public class InscriptionTest {

	@Test
	public void test() {
		Route mockRoute = mock(Route.class);
		Inscription inscription = new InscriptionBuilder()
				.setRoute(mockRoute)
				.build();

		assertEquals(inscription.getRoute(), mockRoute);
	}

}
