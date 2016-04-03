package unq.tpi.desapp;

import static org.junit.Assert.*;

import org.junit.Test;

import unq.tpi.desapp.builders.VehicleBuilder;

public class VehicleTest {

	@Test
	public void testAccessing() {
		Vehicle vehicle = new VehicleBuilder()
				.setModel("Peugeot 408")
				.setMaxNumberPassangers(5)
				.build();

		assertEquals(vehicle.getModel(), "Peugeot 408");
		assertEquals(vehicle.getMaxNumberPassangers(), (Integer) 5);
	}

}
