package unq.tpi.desapp.model;

import java.util.List;

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

public class Routine {

	private Integer id;
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

	public LocalDate getEndDate() {
		return endDate;
	}

	public List<DateTimeConstants> getDaysOfWeek() {
		return daysOfWeek;
	}

}
