package unq.tpi.desapp.model.manager;

import java.util.List;

import unq.tpi.desapp.model.Vehicle;

public class VehicleManager {

	private List<Vehicle> vehicles;

	public VehicleManager(List<Vehicle> vehicles) {
		super();
		this.vehicles = vehicles;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	private Boolean includes(Vehicle vehicle) {
		return this.vehicles.stream()
				.anyMatch(aVehicle -> aVehicle.getRegistrationNumber() == vehicle.getRegistrationNumber());
	}

	public void add(Vehicle vehicle) throws Exception {
		if (this.includes(vehicle)) {
			throw new Exception("Ya contienes un auto registrado bajo esa matricula");
		}
		this.vehicles.add(vehicle);
	}

	public void remove(Vehicle vehicle) {
		this.vehicles.remove(vehicle);
	}

}
