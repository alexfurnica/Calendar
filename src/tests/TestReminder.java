package tests;

import model.Date;
import model.Reminder;
import model.Time;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestReminder {

    Reminder reminder;

    @Before
    public void setUp() {
        reminder = new Reminder(
                new Date(20,10,2020),
                new Time(10, 20),
                "Personal",
                "Eat enemies"
        );
    }

    @Test
    public void testConstructor() {
        assertEquals(reminder.getNote(), "Eat enemies");
        assertEquals(reminder.getDate(), new Date(20,10,2020));
        assertEquals(reminder.getTime(), new Time(10, 20));
        assertEquals(reminder.getLabel(), "Personal");
    }

    @Test
    public void testGetNote() {
        assertEquals(reminder.getNote(), "Eat enemies");
    }

    @Test
    public void testSetNote() {
        reminder.setNote("Clean dishes");
        assertEquals(reminder.getNote(), "Clean dishes");
    }

    @Test
    public void testNoIntervalSet() {
        assertEquals(reminder.getInterval(), 0);
        assertEquals(reminder.isRepeating(), false);
    }

    @Test
    public void testSetInterval() {
        reminder.setInterval(10);
        assertEquals(reminder.getInterval(), 10);
        assertEquals(reminder.isRepeating(), true);
    }
}
