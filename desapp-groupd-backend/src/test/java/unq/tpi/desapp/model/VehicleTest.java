package unq.tpi.desapp.model;

import static org.junit.Assert.*;

import org.junit.Test;

import unq.tpi.desapp.builders.VehicleBuilder;

public class VehicleTest {

	@Test
	public void testAccessing() {
		Vehicle vehicle = new VehicleBuilder().setRegistrationNumber("CAR-001").setModel("Peugeot 408")
				.setMaxNumberPassangers(5).build();

		assertEquals(vehicle.getRegistrationNumber(), "CAR-001");
		assertEquals(vehicle.getModel(), "Peugeot 408");
		assertEquals(vehicle.getMaxNumberPassangers(), (Integer) 5);
	}

}
