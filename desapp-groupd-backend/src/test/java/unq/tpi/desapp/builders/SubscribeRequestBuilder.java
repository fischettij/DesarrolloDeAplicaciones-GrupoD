package unq.tpi.desapp.builders;

import unq.tpi.desapp.SubscribeRequest;
import unq.tpi.desapp.User;

public class SubscribeRequestBuilder {

	private User candidate;
	private String mapPoint;
	private String message;

	public SubscribeRequestBuilder() {
		candidate = new UserBuilder().build();
		mapPoint = "";
		message = "";
	}

	public SubscribeRequestBuilder setCandidate(User candidate) {
		this.candidate = candidate;
		return this;
	}

	public SubscribeRequestBuilder setMapPoint(String mapPoint) {
		this.mapPoint = mapPoint;
		return this;
	}

	public SubscribeRequestBuilder setMessage(String message) {
		this.message = message;
		return this;
	}
	
	public SubscribeRequest build(){
		return new SubscribeRequest(candidate, mapPoint, message);
	}

}
