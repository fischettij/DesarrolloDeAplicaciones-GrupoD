package unq.tpi.desapp.model;

import java.util.List;

import unq.tpi.desapp.model.manager.Manager;

public class User extends Entity {

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

}
