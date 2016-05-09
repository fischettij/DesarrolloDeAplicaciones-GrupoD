package unq.tpi.desapp.builders;

import java.util.ArrayList;
import java.util.List;

import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.manager.Manager;

public class UserBuilder {

	private String name;
	private List<Manager> managers;

	public UserBuilder() {
		name = "";
		managers = new ArrayList<Manager>();
	}

	public UserBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public UserBuilder setManager(List<Manager> managers) {
		this.managers = managers;
		return this;
	}

	public UserBuilder addManager(Manager manager) {
		this.managers.add(manager);
		return this;
	}

	public User build() {
		return new User(name, managers);
	}
	
	public UserBuilder addAllManagers(){
		this.addManager(new VehicleManagerBuilder().build());
		this.addManager(new CommentManagerBuilder().build());
		this.addManager(new RouteManagerBuilder().build());
		this.addManager(new InscriptionManagerBuilder().build());
		this.addManager(new ScoreManagerBuilder().build());
		return this;
		
	}

}
