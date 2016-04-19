package unq.tpi.desapp.model.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import unq.tpi.desapp.builders.VehicleManagerBuilder;
import unq.tpi.desapp.model.Vehicle;

public class VahicleManagerTest {

	@Test
	public void testAddVehicle() throws Exception {
		Vehicle mockVehicle = mock(Vehicle.class);
		VehicleManager vehicleManager = new VehicleManagerBuilder().build();
		assertTrue(vehicleManager.getVehicles().isEmpty());

		vehicleManager.add(mockVehicle);

		assertEquals(vehicleManager.getVehicles().size(), 1);
	}

	@Test(expected = Exception.class)
	public void testAddVehicleTwoTimes() throws Exception {
		Vehicle mockVehicle = mock(Vehicle.class);
		when(mockVehicle.getRegistrationNumber()).thenReturn("CAR-001");
		VehicleManager vehicleManager = new VehicleManagerBuilder().build();
		assertTrue(vehicleManager.getVehicles().isEmpty());

		vehicleManager.add(mockVehicle);
		assertEquals(vehicleManager.getVehicles().size(), 1);

		vehicleManager.add(mockVehicle);
	}

	@Test
	public void testRemoveVehicle() throws Exception {
		Vehicle mockVehicle = mock(Vehicle.class);
		VehicleManager vehicleManager = new VehicleManagerBuilder().build();
		assertTrue(vehicleManager.getVehicles().isEmpty());

		vehicleManager.add(mockVehicle);
		assertEquals(vehicleManager.getVehicles().size(), 1);

		vehicleManager.remove(mockVehicle);
		assertTrue(vehicleManager.getVehicles().isEmpty());
	}

}
