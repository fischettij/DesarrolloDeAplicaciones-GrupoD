package unq.tpi.desapp.model.manager;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import unq.tpi.desapp.builders.CommentManagerBuilder;
import unq.tpi.desapp.model.Comment;

public class CommentManagerTest {

	@Test
	public void testAddComment() {
		Comment mockComment = mock(Comment.class);
		CommentManager commentManager = new CommentManagerBuilder().build();
		assertTrue(commentManager.getComments().isEmpty());

		commentManager.add(mockComment);
		assertEquals(commentManager.getComments().size(), 1);
	}

}
