package unq.tpi.desapp.builders;

import java.util.ArrayList;
import java.util.List;

import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.manager.VehicleManager;

public class SystemBuilder {

	public List<User> build() {

		List<User> users = new ArrayList<User>();

		User user1 = new UserBuilder().setName("user1").addAllManagers().build();
		User user2 = new UserBuilder().setName("user2").addAllManagers().build();

		users.add(user1);
		users.add(user2);

		try {
			user1.managerImplementing(VehicleManager.class).add(new VehicleBuilder().build());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return users;

	}

}
