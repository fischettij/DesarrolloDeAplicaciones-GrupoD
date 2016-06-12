package unq.tpi.desapp.builders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import unq.tpi.desapp.model.DaysOfWeekEnum;
import unq.tpi.desapp.model.Route;
import unq.tpi.desapp.model.SubscriptionRequest;
import unq.tpi.desapp.model.User;
import unq.tpi.desapp.model.Vehicle;
import unq.tpi.desapp.model.request.RequestRoute;

public class RouteBuilder {

	private Double startLatitud;
	private Double startLongitud;
	private Double endLatitud;
	private Double endLongitud;
	private Vehicle vehicle;
	private User owner;
	private Set<DaysOfWeekEnum> daysOfWeek;
	private List<SubscriptionRequest> subscriptionRequests;

	public RouteBuilder() {
		startLatitud = -34.726121;
		startLongitud = -58.279362;
		endLatitud = -34.610811;
		endLongitud = -58.379066;
		vehicle = new VehicleBuilder().build();
		owner = new UserBuilder().build();
		daysOfWeek = new HashSet<DaysOfWeekEnum>();
		daysOfWeek.add(DaysOfWeekEnum.MON);
		subscriptionRequests = new ArrayList<SubscriptionRequest>();
	}

	public Route build() {
		return new Route(startLatitud, startLongitud, endLatitud, endLongitud, vehicle, owner, daysOfWeek,
				subscriptionRequests);
	}

	public RouteBuilder setDaysOfWeek(Set<DaysOfWeekEnum> daysOfWeekEnum) {
		this.daysOfWeek = daysOfWeekEnum;
		return this;
	}

	public RouteBuilder setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
		return this;
	}

	public RouteBuilder setSubscriptionRequests(List<SubscriptionRequest> subscribeRequests) {
		this.subscriptionRequests = subscribeRequests;
		return this;
	}

	public RouteBuilder setStartLatitud(Double startLatitud) {
		this.startLatitud = startLatitud;
		return this;
	}

	public RouteBuilder setStartLongitud(Double startLongitud) {
		this.startLongitud = startLongitud;
		return this;
	}

	public RouteBuilder setEndLatitud(Double endLatitud) {
		this.endLatitud = endLatitud;
		return this;
	}

	public RouteBuilder setEndLongitud(Double endLongitud) {
		this.endLongitud = endLongitud;
		return this;
	}

	public RouteBuilder setOwner(User owner) {
		this.owner = owner;
		return this;
	}

	public Route buildWith(RequestRoute requestRoute, Vehicle vehicle2, User user) {
		return new Route(requestRoute.getStartLatitud(), requestRoute.getStartLongitud(), requestRoute.getEndLatitud(),
				requestRoute.getEndLongitud(), vehicle2, user, requestRoute.getDaysOfWeek(), subscriptionRequests);
	}

}
