package unq.tpi.desapp.model.manager;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import unq.tpi.desapp.model.Vehicle;

public class VehicleManager extends Manager {

	private static final long serialVersionUID = -7030874564566090755L;

	@JsonIgnore
	private List<Vehicle> vehicles;

	public VehicleManager() {
	}

	public VehicleManager(List<Vehicle> vehicles) {
		super();
		this.vehicles = vehicles;
	}

	@JsonIgnore
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

	@JsonProperty
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public String getManager() {
		return "VehicleManager";
	}

	public Vehicle find(Long idVehicle) {
		return this.vehicles.stream().filter(aVehicle -> aVehicle.getId() == idVehicle).findFirst().get();
	}

}
