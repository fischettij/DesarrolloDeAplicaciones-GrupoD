package unq.tpi.desapp.model;

import java.util.List;

import unq.tpi.desapp.model.manager.Manager;

public class User extends Entity {

	private static final long serialVersionUID = 7181636845463109784L;

	private String name;
	List<Manager> managers;

	public User() {
	}

	public User(String name, List<Manager> managers) {
		this.name = name;
		this.managers = managers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@SuppressWarnings("unchecked")
	public <E extends Manager> E managerImplementing(Class<E> managerClass) {
		for (Manager manager : this.managers) {
			if (manager.isA(managerClass)) {
				return (E) manager;
			}
		}
		throw new RuntimeException("El usuario no conoce dicho manager");
	}

	public List<Manager> getManagers() {
		return managers;
	}

	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}
	
	public <E> void removeManager(Class<E> managerClass){
		Manager managerToRemove = null;
		for (Manager manager : this.managers) {
			if (manager.isA(managerClass)) {
				managerToRemove = manager;
			}
		}
		this.getManagers().remove(managerToRemove);
	}

}
