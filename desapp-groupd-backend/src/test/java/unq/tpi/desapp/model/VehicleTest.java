package unq.tpi.desapp.model;

import static org.junit.Assert.*;

import org.junit.Test;

import unq.tpi.desapp.builders.VehicleBuilder;
import unq.tpi.desapp.model.Vehicle;

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
