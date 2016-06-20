package unq.tpi.desapp.model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.joda.time.DateTime;
import org.junit.Test;

public class CommentTest {

	@Test
	public void testAccessing() {
		User someUser = mock(User.class);
		String someMassage = "Algun comentario";
		DateTime today = new DateTime();
		Comment comment = new Comment(someUser, someMassage, today);

		assertEquals(comment.getUser(), someUser);
		assertEquals(comment.getDate(), today);
		assertEquals(comment.getMessage(), someMassage);
	}

}
