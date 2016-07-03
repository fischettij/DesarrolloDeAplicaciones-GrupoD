package unq.tpi.desapp.model;

import java.util.List;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

public class Route extends Entity {

	private static final long serialVersionUID = -3346088172414233280L;

	private String startPoint;
	private String endPoint;
	private Double startLatitud;
	private Double startLongitud;
	private Double endLatitud;
	private Double endLongitud;
	private Vehicle vehicle;
	private User owner;
	private Set<DaysOfWeekEnum> daysOfWeek;
	@JsonIgnore
	private List<SubscriptionRequest> subscriptionRequests;

	public Route() {
	}

	public Route(String startPoint, String endPoint, Double startLatitud, Double startLongitud, Double endLatitud,
			Double endLongitud, Vehicle vehicle, User owner, Set<DaysOfWeekEnum> daysOfWeek,
			List<SubscriptionRequest> subscriptionRequests) {
		super();
		this.setStartPoint(startPoint);
		this.setEndPoint(endPoint);
		this.startLatitud = startLatitud;
		this.startLongitud = startLongitud;
		this.endLatitud = endLatitud;
		this.endLongitud = endLongitud;
		this.vehicle = vehicle;
		this.owner = owner;
		this.daysOfWeek = daysOfWeek;
		this.subscriptionRequests = subscriptionRequests;
	}

	public void addSubscriptionRequest(SubscriptionRequest subscriptionRequest) {
		this.subscriptionRequests.add(subscriptionRequest);
	}

	public void acceptedSubscriptionRequest(SubscriptionRequest subscriptionRequest) {
		if (this.subscriptionRequests.contains(subscriptionRequest)) {
			subscriptionRequest.accepted(this);
		}
	}

	public void canceledSubscriptionRequest(SubscriptionRequest subscriptionRequest) {
		if (this.subscriptionRequests.contains(subscriptionRequest)) {
			subscriptionRequest.canceled(this);
			this.subscriptionRequests.remove(subscriptionRequest);
		}
	}

	@JsonIgnore
	public List<SubscriptionRequest> getSubscriptionRequests() {
		return subscriptionRequests;
	}

	@JsonProperty
	public void setSubscriptionRequests(List<SubscriptionRequest> subscriptionRequests) {
		this.subscriptionRequests = subscriptionRequests;
	}

	public Double getStartLatitud() {
		return startLatitud;
	}

	public void setStartLatitud(Double startLatitud) {
		this.startLatitud = startLatitud;
	}

	public Double getStartLongitud() {
		return startLongitud;
	}

	public void setStartLongitud(Double startLongitud) {
		this.startLongitud = startLongitud;
	}

	public Double getEndLatitud() {
		return endLatitud;
	}

	public void setEndLatitud(Double endLatitud) {
		this.endLatitud = endLatitud;
	}

	public Double getEndLongitud() {
		return endLongitud;
	}

	public void setEndLongitud(Double endLongitud) {
		this.endLongitud = endLongitud;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Set<DaysOfWeekEnum> getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setDaysOfWeek(Set<DaysOfWeekEnum> daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}

	public String getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public void canceledSubscriptionRequest(Long subscriptionID) {
		for (SubscriptionRequest subscription : this.getSubscriptionRequests()) {
			if (subscription.getId().equals(subscriptionID)) {
				this.canceledSubscriptionRequest(subscription);
				return;
			}
		}
	}

	public void acceptedSubscriptionRequest(Long subscriptionID) {
		for (SubscriptionRequest subscription : this.getSubscriptionRequests()) {
			if (subscription.getId().equals(subscriptionID)) {
				this.acceptedSubscriptionRequest(subscription);
				return;
			}
		}
	}

}
