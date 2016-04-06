package unq.tpi.desapp;

import java.util.List;

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

public class Routine {

	private LocalDate startingDate;
	private LocalDate endDate;
	private List<DateTimeConstants> daysOfWeek;

	public Routine(LocalDate startingDate, LocalDate endDate, List<DateTimeConstants> daysOfWeek) {
		this.startingDate = startingDate;
		this.endDate = endDate;
		this.daysOfWeek = daysOfWeek;
	}

	public LocalDate getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public List<DateTimeConstants> getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setDaysOfWeek(List<DateTimeConstants> daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}

}
