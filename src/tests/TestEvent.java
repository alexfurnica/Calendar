package tests;

import model.Date;
import model.Event;
import model.Reminder;
import model.Time;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEvent {

    Event event;

    @Before
    public void setUp() {
        event = new Event(
                new Date(20, 10, 2020),
                new Time(10, 10),
                "Work"
        );
    }

    @Test
    public void testNoReminderSet() {
        Reminder reminder;

        assertEquals(event.getReminder(), null);
    }

    @Test
    public void testSetReminder() {
        Reminder reminder = new Reminder(
                new Date(21, 10, 2020),
                new Time(10, 11),
                "Making sure",
                "Don't forget about this meeting"
        );
        event.setReminder(reminder);
        assertEquals(event.getReminder(), reminder);
    }
}
