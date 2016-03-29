package unq.tpi.desapp;

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

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getMaxNumberPassangers() {
		return maxNumberPassangers;
	}

	public void setMaxNumberPassangers(Integer maxNumberPassangers) {
		this.maxNumberPassangers = maxNumberPassangers;
	}

}
