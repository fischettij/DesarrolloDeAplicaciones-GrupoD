package unq.tpi.desapp.userStoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import unq.tpi.desapp.builders.ScoreManagerBuilder;
import unq.tpi.desapp.builders.UserBuilder;
import unq.tpi.desapp.model.CommentedPoint;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.manager.CommentManager;
import unq.tpi.desapp.model.manager.ScoreManager;

public class UserRateUserStoryTest {

	public User userNamed(String name) {
		UserBuilder builder = new UserBuilder();
		builder.setName(name);
		builder.addManager(new ScoreManagerBuilder().build());
		return builder.build();
	}

	@Test
	public void someUserScoreAnotherUser() {
		User someUser = this.userNamed("Some User");
		User anotherUser = this.userNamed("Another User");

		assertTrue(someUser.managerImplementing(ScoreManager.class).getCommentedPoints().isEmpty());

		CommentedPoint commentedPoint = new CommentedPoint(anotherUser, false, "Insert Comment Here");
		someUser.managerImplementing(ScoreManager.class).add(commentedPoint);

		assertEquals(someUser.managerImplementing(ScoreManager.class).getCommentedPoints().size(), 1);
		assertTrue(someUser.managerImplementing(ScoreManager.class).getCommentedPoints().contains(commentedPoint));
	}

	@Test
	public void canNotHaveMoreThanOnePointFromTheSameUser() {
		User someUser = this.userNamed("Some User");
		User anotherUser = this.userNamed("Another User");

		CommentedPoint commentedPoint = new CommentedPoint(anotherUser, false, "Insert Comment Here");
		someUser.managerImplementing(ScoreManager.class).add(commentedPoint);

		CommentedPoint anotherCommentedPoint = new CommentedPoint(anotherUser, false, "Insert New Comment Here");
		someUser.managerImplementing(ScoreManager.class).add(anotherCommentedPoint);

		assertEquals(someUser.managerImplementing(ScoreManager.class).getCommentedPoints().size(), 1);
		assertFalse(someUser.managerImplementing(ScoreManager.class).getCommentedPoints().contains(commentedPoint));
		assertTrue(
				someUser.managerImplementing(ScoreManager.class).getCommentedPoints().contains(anotherCommentedPoint));
	}

	@Test
	public void moreThanOneUserCanRate() {
		User someUser = this.userNamed("Some User");
		User anotherUser = this.userNamed("Another User");
		User thirdUser = this.userNamed("Third User");

		CommentedPoint anotherUserPoint = new CommentedPoint(anotherUser, false, "Insert Comment Here");
		CommentedPoint thirdUserPoint = new CommentedPoint(thirdUser, false, "Insert Comment Here");
		someUser.managerImplementing(ScoreManager.class).add(anotherUserPoint);
		someUser.managerImplementing(ScoreManager.class).add(thirdUserPoint);

		assertEquals(someUser.managerImplementing(ScoreManager.class).getCommentedPoints().size(), 2);
		assertTrue(someUser.managerImplementing(ScoreManager.class).getCommentedPoints().contains(anotherUserPoint));
		assertTrue(someUser.managerImplementing(ScoreManager.class).getCommentedPoints().contains(thirdUserPoint));
	}

}
