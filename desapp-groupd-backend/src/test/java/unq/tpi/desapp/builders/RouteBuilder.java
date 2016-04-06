package unq.tpi.desapp.builders;

import java.util.ArrayList;
import java.util.List;

import unq.tpi.desapp.Route;
import unq.tpi.desapp.Routine;
import unq.tpi.desapp.SubscribeRequest;

public class RouteBuilder {

	private String startPoint;
	private String endPoint;
	private Routine routine;
	private List<SubscribeRequest> subscribeRequests;

	public RouteBuilder() {
		startPoint = "";
		endPoint = "";
		routine = new RoutineBuilder().build();
		subscribeRequests = new ArrayList<SubscribeRequest>();
	}

	public RouteBuilder setStartingPoint(String startingPoint) {
		startPoint = startingPoint;
		return this;
	}

	public RouteBuilder setEndingPoint(String endingingPoint) {
		endPoint = endingingPoint;
		return this;
	}

	public RouteBuilder setRoutine(Routine routine) {
		this.routine = routine;
		return this;
	}

	public RouteBuilder setSubscribeRequests(List<SubscribeRequest> subscribeRequests) {
		this.subscribeRequests = subscribeRequests;
		return this;
	}

	public Route build() {
		return new Route(startPoint, endPoint, routine, subscribeRequests);
	}

}
