package unq.tpi.desapp.model.manager;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import unq.tpi.desapp.builders.ScoreManagerBuilder;
import unq.tpi.desapp.model.CommentedPoint;
import unq.tpi.desapp.model.User;

public class ScoreManagerTest {

	@Test
	public void testAddPositiveComment() {
		CommentedPoint mockCommentedPoint = mock(CommentedPoint.class);
		when(mockCommentedPoint.isNegative()).thenReturn(false);
		ScoreManager scoreManager = new ScoreManagerBuilder().build();
		scoreManager.add(mockCommentedPoint);

		assertEquals(scoreManager.getScore(), new Integer(500));
	}

	@Test
	public void testAddPositiveCommentTwoTimesWithTheSameUser() {
		User mockUser = mock(User.class);
		CommentedPoint mockCommentedPoint = mock(CommentedPoint.class);
		when(mockCommentedPoint.isNegative()).thenReturn(false);
		when(mockCommentedPoint.getUser()).thenReturn(mockUser);
		ScoreManager scoreManager = new ScoreManagerBuilder().build();
		scoreManager.add(mockCommentedPoint);
		scoreManager.add(mockCommentedPoint);

		assertEquals(scoreManager.getScore(), new Integer(500));
	}

	@Test
	public void testAddNegativeComment() {
		CommentedPoint mockCommentedPoint = mock(CommentedPoint.class);
		when(mockCommentedPoint.isNegative()).thenReturn(true);
		ScoreManager scoreManager = new ScoreManagerBuilder().build();
		scoreManager.add(mockCommentedPoint);

		assertEquals(scoreManager.getScore(), new Integer(0));
	}

	@Test
	public void testAddNegativeCommentTwoTimes() {
		User mockUser = mock(User.class);
		User mockAnotherUser = mock(User.class);
		CommentedPoint mockCommentedPoint = mock(CommentedPoint.class);
		when(mockCommentedPoint.isNegative()).thenReturn(true);
		when(mockCommentedPoint.getUser()).thenReturn(mockUser, mockAnotherUser);
		ScoreManager scoreManager = new ScoreManagerBuilder().build();
		scoreManager.add(mockCommentedPoint);
		scoreManager.add(mockCommentedPoint);

		assertEquals(scoreManager.getScore(), new Integer(-1000));
	}

	@Test
	public void testAddNegativeCommentTwoTimesWithTheSameUser() {
		User mockUser = mock(User.class);
		CommentedPoint mockCommentedPoint = mock(CommentedPoint.class);
		when(mockCommentedPoint.isNegative()).thenReturn(true);
		when(mockCommentedPoint.getUser()).thenReturn(mockUser);
		ScoreManager scoreManager = new ScoreManagerBuilder().build();
		scoreManager.add(mockCommentedPoint);
		scoreManager.add(mockCommentedPoint);

		assertEquals(scoreManager.getScore(), new Integer(0));
	}

}
