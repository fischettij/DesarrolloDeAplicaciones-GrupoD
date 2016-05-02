package unq.tpi.desapp.model;

public class Vehicle extends Entity {

	private String model;
	private Integer maxNumberPassangers;
	private String registrationNumber;
	
	public Vehicle() {
	}

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

	public void setModel(String model) {
		this.model = model;
	}

	public void setMaxNumberPassangers(Integer maxNumberPassangers) {
		this.maxNumberPassangers = maxNumberPassangers;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

}
