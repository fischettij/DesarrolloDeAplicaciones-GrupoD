package unq.tpi.desapp.model;

public class Vehicle {

	private String model;
	private Integer maxNumberPassangers;

	public Vehicle(String model, Integer maxNumberPassangers) {
		this.model = model;
		this.maxNumberPassangers = maxNumberPassangers;
	}

	public String getModel() {
		return model;
	}

	public Integer getMaxNumberPassangers() {
		return maxNumberPassangers;
	}

}
