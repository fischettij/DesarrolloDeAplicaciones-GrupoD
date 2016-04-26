package unq.tpi.desapp.userStoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import unq.tpi.desapp.builders.UserBuilder;
import unq.tpi.desapp.model.CommentedPoint;
import unq.tpi.desapp.model.User;

public class UserRateUserStoryTest {

	public User userNamed(String name) {
		UserBuilder builder = new UserBuilder();
		builder.setName(name);

		return builder.build();
	}

	@Test
	public void someUserScoreAnotherUser() {
		User someUser = this.userNamed("Some User");
		User anotherUser = this.userNamed("Another User");

		assertTrue(someUser.getCommentedPoints().isEmpty());

		CommentedPoint commentedPoint = new CommentedPoint(anotherUser, false, "Insert Comment Here");
		someUser.addCommentedPoint(commentedPoint);

		assertEquals(someUser.getCommentedPoints().size(), 1);
		assertTrue(someUser.getCommentedPoints().contains(commentedPoint));
	}

	@Test
	public void canNotHaveMoreThanOnePointFromTheSameUser()  {
		User someUser = this.userNamed("Some User");
		User anotherUser = this.userNamed("Another User");

		CommentedPoint commentedPoint = new CommentedPoint(anotherUser, false, "Insert Comment Here");
		someUser.addCommentedPoint(commentedPoint);

		CommentedPoint anotherCommentedPoint = new CommentedPoint(anotherUser, false, "Insert New Comment Here");
		someUser.addCommentedPoint(anotherCommentedPoint);

		assertEquals(someUser.getCommentedPoints().size(), 1);
		assertFalse(someUser.getCommentedPoints().contains(commentedPoint));
		assertTrue(someUser.getCommentedPoints().contains(anotherCommentedPoint));
	}

	@Test
	public void moreThanOneUserCanRate() {
		User someUser = this.userNamed("Some User");
		User anotherUser = this.userNamed("Another User");
		User thirdUser = this.userNamed("Third User");

		CommentedPoint anotherUserPoint = new CommentedPoint(anotherUser, false, "Insert Comment Here");
		CommentedPoint thirdUserPoint = new CommentedPoint(thirdUser, false, "Insert Comment Here");
		someUser.addCommentedPoint(anotherUserPoint);
		someUser.addCommentedPoint(thirdUserPoint);

		assertEquals(someUser.getCommentedPoints().size(), 2);
		assertTrue(someUser.getCommentedPoints().contains(anotherUserPoint));
		assertTrue(someUser.getCommentedPoints().contains(thirdUserPoint));
	}

}
