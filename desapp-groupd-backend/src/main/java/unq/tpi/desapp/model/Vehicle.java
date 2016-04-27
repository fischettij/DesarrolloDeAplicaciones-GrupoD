package unq.tpi.desapp.model;

public class Vehicle extends Entity {

	private String model;
	private Integer maxNumberPassangers;
	private String registrationNumber;

	public Vehicle(String registrationNumber, String model, Integer maxNumberPassangers) {
		this.registrationNumber = registrationNumber;
		this.model = model;
		this.maxNumberPassangers = maxNumberPassangers;
	}

	public String getModel() {
		return model;
	}

	public Integer getMaxNumberPassangers() {
		return maxNumberPassangers;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

}
