package unq.tpi.desapp;

import junit.framework.TestCase;

public class VehicleTests extends TestCase {

	public void testAccessing(){
		Integer five = 5;
		Vehicle vehicle = new Vehicle("Peugeot 408", five);
		
		assertEquals(vehicle.getModel(), "Peugeot 408");
		assertEquals(vehicle.getMaxNumberPassangers(), five);
		
	}
	
}
