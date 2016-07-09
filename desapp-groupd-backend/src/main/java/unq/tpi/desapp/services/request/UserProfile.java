package unq.tpi.desapp.services.request;

import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.manager.ScoreManager;

public class UserProfile {

	public long id;
	public String name;
	public Integer score;
	
	public UserProfile(User user){
		this.id = user.getId();
		this.name = user.getName();
		this.score = user.managerImplementing(ScoreManager.class).getScore();
	}	
}
