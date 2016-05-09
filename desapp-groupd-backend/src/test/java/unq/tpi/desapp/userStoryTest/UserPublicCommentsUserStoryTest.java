package unq.tpi.desapp.userStoryTest;

import static org.junit.Assert.*;

import org.junit.Test;

import unq.tpi.desapp.builders.CommentManagerBuilder;
import unq.tpi.desapp.builders.UserBuilder;
import unq.tpi.desapp.model.Comment;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.manager.CommentManager;

public class UserPublicCommentsUserStoryTest {

	public User userNamed(String name) {
		UserBuilder builder = new UserBuilder().setName(name).addManager(new CommentManagerBuilder().build());
		return builder.build();
	}

	@Test
	public void aUserReceivesPublicCommentsFromOhers() {
		User someUser = userNamed("Somer User");
		User anotherUser = userNamed("Another User");
		User thirdUser = userNamed("Third User");

		assertEquals(someUser.managerImplementing(CommentManager.class).getComments().size(), 0);

		Comment anotherUserComment = new Comment(anotherUser, "you have a good car");
		someUser.managerImplementing(CommentManager.class).add(anotherUserComment);
		assertEquals(someUser.managerImplementing(CommentManager.class).getComments().size(), 1);
		assertTrue(someUser.managerImplementing(CommentManager.class).getComments().contains(anotherUserComment));

		Comment thirdUserComment = new Comment(thirdUser, "you have a good car");
		someUser.managerImplementing(CommentManager.class).add(thirdUserComment);
		assertEquals(someUser.managerImplementing(CommentManager.class).getComments().size(), 2);
		assertTrue(someUser.managerImplementing(CommentManager.class).getComments().contains(thirdUserComment));
	}

}
