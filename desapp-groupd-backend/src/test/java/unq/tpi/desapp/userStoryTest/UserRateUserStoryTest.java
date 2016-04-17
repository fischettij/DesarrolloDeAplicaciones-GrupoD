package unq.tpi.desapp.userStoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import unq.tpi.desapp.builders.UserBuilder;
import unq.tpi.desapp.exceptions.InvalidAction;
import unq.tpi.desapp.model.CommentedPoint;
import unq.tpi.desapp.model.User;

public class UserRateUserStoryTest {

	
	public User userNamed(String name){
		UserBuilder builder = new UserBuilder();
		builder.setName(name);
		
		return builder.build();
	}
	
	@Test
	public void someUserScoreAnotherUser() throws InvalidAction {
		User someUser = this.userNamed("Some User");
		User anotherUser = this.userNamed("Another User");
		
		assertTrue(someUser.getCommentedPoints().isEmpty());
		
		CommentedPoint commentedPoint = new CommentedPoint(anotherUser, new Integer(4), "Insert Comment Here");
		someUser.addCommentedPoint(commentedPoint);
		
		assertEquals(someUser.getCommentedPoints().size(), 1);
		assertTrue(someUser.getCommentedPoints().contains(commentedPoint));
	}

	@Test
	public void canNotHaveMoreThanOnePointFromTheSameUser() throws InvalidAction {
		User someUser = this.userNamed("Some User");
		User anotherUser = this.userNamed("Another User");
		
		CommentedPoint commentedPoint = new CommentedPoint(anotherUser, new Integer(4), "Insert Comment Here");
		someUser.addCommentedPoint(commentedPoint);
		
		CommentedPoint anotherCommentedPoint = new CommentedPoint(anotherUser, new Integer(3), "Insert New Comment Here");
		someUser.addCommentedPoint(anotherCommentedPoint);
		
		assertEquals(someUser.getCommentedPoints().size(), 1);
		assertFalse(someUser.getCommentedPoints().contains(commentedPoint));
		assertTrue(someUser.getCommentedPoints().contains(anotherCommentedPoint));
	}
	
	
	@Test
	public void moreThanOneUserCanRate() throws InvalidAction{
		User someUser = this.userNamed("Some User");
		User anotherUser = this.userNamed("Another User");
		User thirdUser = this.userNamed("Third User");
		
		CommentedPoint anotherUserPoint = new CommentedPoint(anotherUser, new Integer(4), "Insert Comment Here");
		CommentedPoint thirdUserPoint = new CommentedPoint(thirdUser, new Integer(5), "Insert Comment Here");
		someUser.addCommentedPoint(anotherUserPoint);
		someUser.addCommentedPoint(thirdUserPoint);
		
		assertEquals(someUser.getCommentedPoints().size(), 2);
		assertTrue(someUser.getCommentedPoints().contains(anotherUserPoint));
		assertTrue(someUser.getCommentedPoints().contains(thirdUserPoint));			
	}
	
	@Test(expected=InvalidAction.class)
	public void aUserCanNotsScoreItself() throws InvalidAction{
		User someUser = this.userNamed("Some User");
		CommentedPoint someUserPoint = new CommentedPoint(someUser, new Integer(4), "Insert Comment Here");
		
		someUser.addCommentedPoint(someUserPoint);
	}
}
