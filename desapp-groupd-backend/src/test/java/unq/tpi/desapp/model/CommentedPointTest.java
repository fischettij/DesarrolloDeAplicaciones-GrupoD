package unq.tpi.desapp.model;

import static org.junit.Assert.*;

import org.junit.Test;

import unq.tpi.desapp.builders.UserBuilder;

public class CommentedPointTest {

	private User someUser() {
		return (new UserBuilder()).build();
	}

	@Test
	public void testAccessing() {
		User someUser = this.someUser();
		Boolean isNegative = true;
		String someComment = "Algun comentario";
		CommentedPoint commentedPoint = new CommentedPoint(someUser, isNegative, someComment);

		assertEquals(commentedPoint.getUser(), someUser);
		assertTrue(commentedPoint.isNegative());
		assertEquals(commentedPoint.getComment(), someComment);
	}

}
