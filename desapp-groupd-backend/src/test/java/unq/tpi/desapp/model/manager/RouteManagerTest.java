package unq.tpi.desapp.model.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import unq.tpi.desapp.builders.RouteManagerBuilder;
import unq.tpi.desapp.model.Route;

public class RouteManagerTest {

	@Test
	public void testAddRoute() throws Exception {
		Route mockRoute = mock(Route.class);
		RouteManager routeManager = new RouteManagerBuilder().build();
		assertTrue(routeManager.getRoutes().isEmpty());

		routeManager.add(mockRoute);

		assertEquals(routeManager.getRoutes().size(), 1);
	}

	@Test
	public void testRemoveRoute() throws Exception {
		Route mockRoute = mock(Route.class);
		RouteManager routeManager = new RouteManagerBuilder().build();
		assertTrue(routeManager.getRoutes().isEmpty());

		routeManager.add(mockRoute);
		assertEquals(routeManager.getRoutes().size(), 1);

		routeManager.remove(mockRoute);
		assertTrue(routeManager.getRoutes().isEmpty());
	}

}
