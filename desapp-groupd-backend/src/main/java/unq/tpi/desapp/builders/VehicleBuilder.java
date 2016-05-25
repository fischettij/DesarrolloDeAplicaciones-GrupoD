package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.Vehicle;

public class VehicleBuilder {

	private String registrationNumber;
	private String model;
	private Integer maxNumberPassangers;

	public VehicleBuilder() {
		registrationNumber = "ABC-105";
		model = "Porsche Carrera GT";
		maxNumberPassangers = 2;
	}

	public VehicleBuilder setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
		return this;
	}

	public VehicleBuilder setModel(String model) {
		this.model = model;
		return this;
	}

	public VehicleBuilder setMaxNumberPassangers(Integer maxNumberPassangers) {
		this.maxNumberPassangers = maxNumberPassangers;
		return this;
	}

	public Vehicle build() {
		return new Vehicle(registrationNumber, model, maxNumberPassangers);
	}

}
