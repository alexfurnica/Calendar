package tests;

import model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestCalendar {

    Calendar calendar;

    @Before
    public void setUp() {
        calendar = new Calendar(
                new Date(20, 10, 2020),
                "john.salinger@bean.stalk"
        );
    }

    @Test
    public void testConstructor() {
        assertEquals(calendar.getCurrentDate(), new Date(20, 10, 2020));
        assertEquals(calendar.getOwnerEmail(), "john.salinger@bean.stalk");
    }

    @Test
    public void testGetEmptyEntries() {
        assertEquals(calendar.getEntries(), new ArrayList<>());
    }

    @Test
    public void testGetEmptyMeetings() {
        assertEquals(calendar.getMeetings(), new ArrayList<>());
    }

    @Test
    public void testGetEmptyEvents() {
        assertEquals(calendar.getEvents(), new ArrayList<>());
    }

    @Test
    public void testGetNonEmptyEntries() {
        Event e1 = new Event(new Date(20, 12, 2022), new Time(10, 10), "Personal");

        calendar.addEntry(e1);

        ArrayList<Entry> array = new ArrayList<>();
        array.add(e1);

        assertEquals(calendar.getEntries(), array);
    }

    @Test
    public void testGetOneEntryByDate() {
        Event e1 = new Event(new Date(20, 12, 2022), new Time(10, 10), "Personal");
        Event e2 = new Event(new Date(10, 12, 2022), new Time(10, 10), "Personal");

        calendar.addEntry(e1);
        calendar.addEntry(e2);

        ArrayList<Entry> array = new ArrayList<>();
        array.add(e1);

        assertEquals(calendar.getEntriesByDate(new Date(20, 12, 2022)), array);
    }
}
