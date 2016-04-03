package unq.tpi.desapp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import unq.tpi.desapp.builders.RouteBuilder;

public class RouteTest {

	@Test
	public void testAccessing() {
		Route route = new RouteBuilder()
				.setStartingPoint("Avenida Mitre 400")
				.setEndingPoint("Alberdi 30")
				.build();
		
		assertEquals(route.getStartingPoint(), "Avenida Mitre 400");
		assertEquals(route.getEndingPoint(), "Alberdi 30");
	}

}
