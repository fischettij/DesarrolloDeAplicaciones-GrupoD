package unq.tpi.desapp.builders;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDate;

import unq.tpi.desapp.Routine;

public class RoutineBuilder {

	private LocalDate startingDate;
	private LocalDate endDate;
	private List<DateTimeConstants> daysOfWeek;

	public RoutineBuilder() {
		startingDate = new LocalDate();
		endDate = startingDate.plusDays(1);
		daysOfWeek = new ArrayList<DateTimeConstants>();
	}

	public RoutineBuilder setStatingDate(LocalDate startingDate) {
		this.startingDate = startingDate;
		return this;
	}

	public RoutineBuilder setEndDate(LocalDate endDate) {
		this.endDate = endDate;
		return this;
	}

	public RoutineBuilder setDaysOfWeek(List<DateTimeConstants> daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
		return this;
	}

	public Routine build() {
		return new Routine(startingDate, endDate, daysOfWeek);
	}

}
