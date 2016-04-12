package unq.tpi.desapp.model;

import static org.junit.Assert.*;

import org.junit.Test;

import unq.tpi.desapp.builders.UserBuilder;

public class CommentedPointTest {

	private User someUser(){
		return (new UserBuilder()).build();
	}
	@Test
	public void testAccessing(){
		User someUser = this.someUser();
		Integer point = new Integer(3);
		String someComment = "Algun comentario";
		CommentedPoint commentedPoint = new CommentedPoint(someUser, point, someComment);
		
		assertEquals(commentedPoint.getUser(),someUser);
		assertEquals(commentedPoint.getPoint(),new Integer(3));
		assertEquals(commentedPoint.getComment(), someComment );
	}

}
