package unq.tpi.desapp.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class CommentedPointTest {

	@Test
	public void testAccessing() {
		User someUser = mock(User.class);
		Boolean isNegative = true;
		String someComment = "Algun comentario";
		CommentedPoint commentedPoint = new CommentedPoint(someUser, isNegative, someComment);

		assertEquals(commentedPoint.getUser(), someUser);
		assertTrue(commentedPoint.isNegative());
		assertEquals(commentedPoint.getComment(), someComment);
	}

}
