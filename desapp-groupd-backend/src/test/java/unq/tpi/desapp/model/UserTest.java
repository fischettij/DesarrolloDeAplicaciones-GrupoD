package unq.tpi.desapp.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import unq.tpi.desapp.builders.UserBuilder;
import unq.tpi.desapp.model.manager.Manager;

public class UserTest {

	@Test
	public void testAccessing() {
		User user = new UserBuilder().setName("Usuario1").build();
		assertEquals(user.getName(), "Usuario1");
		assertTrue(user.getManagers().isEmpty());
	}

	@Test
	public void testManagerImplementing() {
		Manager mockManager = mock(Manager.class);
		when(mockManager.isA(Manager.class)).thenReturn(true);
		User user = new UserBuilder().addManager(mockManager).build();

		user.managerImplementing(Manager.class);
		verify(mockManager).isA(Manager.class);
	}

	@Test(expected = RuntimeException.class)
	public void testManagerImplementingWithoutManager() {
		User user = new UserBuilder().build();
		user.managerImplementing(Manager.class);
	}

}
