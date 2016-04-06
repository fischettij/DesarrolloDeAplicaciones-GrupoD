package unq.tpi.desapp;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;

import unq.tpi.desapp.builders.SubscribeRequestBuilder;

public class SubscribeRequestTest {

	@Test
	public void testAccessing() {
		User user = mock(User.class);

		SubscribeRequest subscribeRequest = new SubscribeRequestBuilder().setCandidate(user).setMapPoint("Alberdi 30")
				.setMessage("hola").build();

		assertEquals(subscribeRequest.getCandidate(), user);
		assertEquals(subscribeRequest.getMessage(), "hola");
		assertEquals(subscribeRequest.getMapPoint(), "Alberdi 30");
	}

}
