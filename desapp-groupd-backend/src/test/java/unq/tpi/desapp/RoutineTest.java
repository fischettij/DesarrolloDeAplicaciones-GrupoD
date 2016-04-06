package unq.tpi.desapp;

import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.junit.Test;

import unq.tpi.desapp.builders.RoutineBuilder;

public class RoutineTest {

	@Test
	public void testAccessing() {
		LocalDate startingDate = new LocalDate();
		LocalDate endDate = startingDate.plusMonths(1);

		Routine routine = new RoutineBuilder().setStatingDate(startingDate).setEndDate(endDate).build();

		assertEquals(routine.getStartingDate(), startingDate);
		assertEquals(routine.getEndDate(), endDate);
		assertTrue(routine.getDaysOfWeek().isEmpty());

	}

}
