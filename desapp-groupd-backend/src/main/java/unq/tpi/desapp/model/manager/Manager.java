package unq.tpi.desapp.model.manager;

import unq.tpi.desapp.model.Entity;

public abstract class Manager extends Entity {

	public Boolean isA(Class managerClass) {
		return this.getClass().equals(managerClass);
	}

	public abstract String getManager();
}
