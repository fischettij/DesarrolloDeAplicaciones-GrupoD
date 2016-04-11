package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.Vehicle;

public class VehicleBuilder {
	
	private String model;
	private Integer maxNumberPassangers;
	
	public VehicleBuilder(){
		model = "";
		maxNumberPassangers = 0;
	}
	
	public VehicleBuilder setModel(String model){
		this.model = model;
		return this;
	}
	
	public VehicleBuilder setMaxNumberPassangers(Integer maxNumberPassangers){
		this.maxNumberPassangers = maxNumberPassangers;
		return this;
	}
	
	public Vehicle build(){
		return new Vehicle(model, maxNumberPassangers);
	}

}
