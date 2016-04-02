package unq.tpi.desapp.builders;

import unq.tpi.desapp.Route;

public class RouteBuilder {

	private String startPoint;
	private String endPoint;

	public RouteBuilder() {
		startPoint = "";
		endPoint = "";
	}

	public RouteBuilder setStartingPoint(String startingPoint) {
		startPoint = startingPoint;
		return this;
	}

	public RouteBuilder setEndingPoint(String endingingPoint) {
		endPoint = endingingPoint;
		return this;
	}

	public Route build() {
		return new Route(startPoint, endPoint);
	}

}
