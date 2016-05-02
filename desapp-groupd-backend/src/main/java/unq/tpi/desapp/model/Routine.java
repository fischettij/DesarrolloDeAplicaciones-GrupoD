package unq.tpi.desapp.model;

import java.util.List;

import org.joda.time.LocalDate;

public class Routine extends Entity {

	private LocalDate startingDate;
	private LocalDate endDate;
	private List<DayOfWeek> daysOfWeek;
	
	public Routine() {
	}

	public Routine(LocalDate startingDate, LocalDate endDate, List<DayOfWeek> daysOfWeek) {
		this.startingDate = startingDate;
		this.endDate = endDate;
		this.daysOfWeek = daysOfWeek;
	}

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public List<DayOfWeek> getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public void setDaysOfWeek(List<DayOfWeek> daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}

}
