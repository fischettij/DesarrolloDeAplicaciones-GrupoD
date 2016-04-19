package unq.tpi.desapp.builders;

import java.util.ArrayList;
import java.util.List;

import unq.tpi.desapp.model.Vehicle;
import unq.tpi.desapp.model.manager.VehicleManager;

public class VehicleManagerBuilder {

	private List<Vehicle> vehicles;

	public VehicleManagerBuilder() {
		this.vehicles = new ArrayList<Vehicle>();
	}

	public VehicleManagerBuilder setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
		return this;
	}

	public VehicleManager build() {
		return new VehicleManager(vehicles);
	}

}
