package unq.tpi.desapp.services.request;

import java.util.Set;

import unq.tpi.desapp.model.DaysOfWeekEnum;

public class RequestRoute {

	private String startPoint;
	private String endPoint;
	private Double startLatitud;
	private Double startLongitud;
	private Double endLatitud;
	private Double endLongitud;
	private Long idVehicle;
	private Set<DaysOfWeekEnum> daysOfWeek;

	public RequestRoute() {
		super();
	}

	public RequestRoute(String startPoint, String endPoint, Double startLatitud, Double startLongitud,
			Double endLatitud, Double endLongitud, Long idVehicle, Set<DaysOfWeekEnum> daysOfWeek) {
		super();
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.startLatitud = startLatitud;
		this.startLongitud = startLongitud;
		this.endLatitud = endLatitud;
		this.endLongitud = endLongitud;
		this.idVehicle = idVehicle;
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

	public Long getIdVehicle() {
		return idVehicle;
	}

	public void setIdVehicle(Long idVehicle) {
		this.idVehicle = idVehicle;
	}

	public Set<DaysOfWeekEnum> getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setDaysOfWeek(Set<DaysOfWeekEnum> daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}

}
