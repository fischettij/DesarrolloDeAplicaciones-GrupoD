package unq.tpi.desapp.model.manager;

import unq.tpi.desapp.model.Entity;

public abstract class Manager extends Entity {

	private static final long serialVersionUID = 2777102715490647048L;

	@SuppressWarnings("rawtypes")
	public Boolean isA(Class managerClass) {
		return this.getClass().equals(managerClass);
	}

	public abstract String getManager();
}
