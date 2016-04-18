package unq.tpi.desapp.userStoryTest;

import static org.junit.Assert.*;

import org.junit.Test;

import unq.tpi.desapp.builders.UserBuilder;
import unq.tpi.desapp.model.Comment;
import unq.tpi.desapp.model.User;

public class UserPublicCommentsUserStoryTest {

	public User userNamed(String name){
		UserBuilder builder = new UserBuilder();
		builder.setName(name);
		
		return builder.build();
	}
	
	@Test
	public void aUserReceivesPublicCommentsFromOhers() {
		User someUser = userNamed("Somer User");
		User anotherUser = userNamed("Another User");
		User thirdUser = userNamed("Third User");
		
		assertEquals(someUser.getComments().size(),0);
		
		Comment anotherUserComment = new Comment(anotherUser,"you have a good car");
		someUser.addComment(anotherUserComment);
		assertEquals(someUser.getComments().size(),1);
		assertTrue(someUser.getComments().contains(anotherUserComment));
		
		Comment thirdUserComment = new Comment(thirdUser,"you have a good car");
		someUser.addComment(thirdUserComment);
		assertEquals(someUser.getComments().size(),2);
		assertTrue(someUser.getComments().contains(thirdUserComment));
	}

}
