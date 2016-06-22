package unq.tpi.desapp.model.request;

import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.manager.ScoreManager;

public class UserProfile {

	public String name;
	public Integer score;
	
	public UserProfile(User user){
		this.name =user.getName();
		this.score = user.managerImplementing(ScoreManager.class).getScore();
	}	
}
