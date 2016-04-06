package unq.tpi.desapp;

import org.junit.Test;

import unq.tpi.desapp.builders.RouteBuilder;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RouteTest {

	@Test
	public void testAccessing() {
		Routine mockRoutine = mock(Routine.class);

		Route route = new RouteBuilder().setStartingPoint("Avenida Mitre 400").setEndingPoint("Alberdi 30")
				.setRoutine(mockRoutine).build();

		assertEquals(route.getStartingPoint(), "Avenida Mitre 400");
		assertEquals(route.getEndingPoint(), "Alberdi 30");
		assertEquals(route.getRoutine(), mockRoutine);
		assertTrue(route.getSubscribeRequests().isEmpty());
	}

}
