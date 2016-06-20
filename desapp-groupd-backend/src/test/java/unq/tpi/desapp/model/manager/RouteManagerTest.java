package unq.tpi.desapp.model.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import unq.tpi.desapp.builders.RouteManagerBuilder;
import unq.tpi.desapp.exception.NotFoundException;
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

	@Test
	public void testFind() throws NotFoundException {
		Route mockRoute = mock(Route.class);
		when(mockRoute.getId()).thenReturn(1l);
		RouteManager routeManager = new RouteManagerBuilder().build();
		routeManager.add(mockRoute);
		assertEquals(mockRoute, routeManager.find(1l));
	}

	@Test(expected = NotFoundException.class)
	public void testFindWithOutRoute() throws NotFoundException {
		Route mockRoute = mock(Route.class);
		when(mockRoute.getId()).thenReturn(2l);
		RouteManager routeManager = new RouteManagerBuilder().build();
		routeManager.add(mockRoute);
		routeManager.find(1l);
	}

}
