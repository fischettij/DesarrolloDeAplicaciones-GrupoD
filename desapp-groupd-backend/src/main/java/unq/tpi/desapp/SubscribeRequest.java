package unq.tpi.desapp;

public class SubscribeRequest {

	private User candidate;
	private String mapPoint;
	private String message;

	public SubscribeRequest(User candidate, String mapPoint, String message) {
		this.candidate = candidate;
		this.mapPoint = mapPoint;
		this.message = message;
	}

	public User getCandidate() {
		return candidate;
	}

	public void setCandidate(User candidate) {
		this.candidate = candidate;
	}

	public String getMapPoint() {
		return mapPoint;
	}

	public void setMapPoint(String mapPoint) {
		this.mapPoint = mapPoint;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
