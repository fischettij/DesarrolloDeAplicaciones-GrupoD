package unq.tpi.desapp.model.manager;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

import unq.tpi.desapp.builders.ScoreManagerBuilder;
import unq.tpi.desapp.model.CommentedPoint;
import unq.tpi.desapp.model.User;

public class ScoreManagerTest {

	@Test
	public void testAddPositiveComment() {
		CommentedPoint mockCommentedPoint = mock(CommentedPoint.class);
		ScoreManager scoreManager = new ScoreManagerBuilder().build();
		scoreManager.add(mockCommentedPoint);
		verify(mockCommentedPoint).increasePoints(scoreManager);
	}

	@Test
	public void testAddPositiveCommentTwoTimesWithTheSameUser() {
		User mockUser = mock(User.class);
		CommentedPoint mockCommentedPoint = mock(CommentedPoint.class);
		when(mockCommentedPoint.getUser()).thenReturn(mockUser);
		ScoreManager scoreManager = new ScoreManagerBuilder().build();
		scoreManager.add(mockCommentedPoint);
		scoreManager.add(mockCommentedPoint);
		verify(mockCommentedPoint, times(2)).increasePoints(scoreManager);;
		verify(mockCommentedPoint).decreasePoint(scoreManager);
	}

	@Test
	public void testAddNegativeComment() {
		CommentedPoint mockCommentedPoint = mock(CommentedPoint.class);
		ScoreManager scoreManager = new ScoreManagerBuilder().build();
		scoreManager.add(mockCommentedPoint);
		verify(mockCommentedPoint).increasePoints(scoreManager);
	}

	@Test
	public void testAddNegativeCommentTwoTimes() {
		User mockUser = mock(User.class);
		User mockAnotherUser = mock(User.class);
		CommentedPoint mockCommentedPoint = mock(CommentedPoint.class);
		when(mockCommentedPoint.getUser()).thenReturn(mockUser, mockAnotherUser);
		ScoreManager scoreManager = new ScoreManagerBuilder().build();
		scoreManager.add(mockCommentedPoint);
		scoreManager.add(mockCommentedPoint);
		verify(mockCommentedPoint, times(2)).increasePoints(scoreManager);
	}

	@Test
	public void testAddNegativeCommentTwoTimesWithTheSameUser() {
		User mockUser = mock(User.class);
		CommentedPoint mockCommentedPoint = mock(CommentedPoint.class);
		when(mockCommentedPoint.getUser()).thenReturn(mockUser);
		ScoreManager scoreManager = new ScoreManagerBuilder().build();
		scoreManager.add(mockCommentedPoint);
		scoreManager.add(mockCommentedPoint);
		verify(mockCommentedPoint, times(2)).increasePoints(scoreManager);
		verify(mockCommentedPoint).decreasePoint(scoreManager);
		
	}

}
