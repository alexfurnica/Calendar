package tests;

import model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class TestCalendar {

    Calendar calendar;
    Calendar filledCalendar;
    Event e1;
    Event e2;
    Meeting m1;
    Meeting m2;
    Date d1;

    @Before
    public void setUp() {
        d1 = new Date(20, 10, 2020);
        calendar = new Calendar(
                d1,
                "john.salinger@bean.stalk"
        );

        filledCalendar = new Calendar(
                new Date(20, 10, 2020),
                "jill.salinger@bean.stalk"
        );

        e1 = new Event(new Date(20, 12, 2022), new Time(10, 10), "Event1");
        e2 = new Event(new Date(10, 12, 2022), new Time(10, 10), "Event2");
        m1 = new Meeting(new Date(15, 10, 2022), new Time(10, 10), "Meeting1");
        m2 = new Meeting(new Date(17, 11, 2022), new Time(10, 10), "Meeting2");

        filledCalendar.addEntry(e1);
        filledCalendar.addEntry(e2);
        filledCalendar.addEntry(m1);
        filledCalendar.addEntry(m2);
    }

    @Test
    public void testConstructor() {
        assertEquals(d1, calendar.getCurrentDate());
        assertEquals("john.salinger@bean.stalk", calendar.getOwnerEmail());
    }

    @Test
    public void testGetEmptyEntries() {
        assertEquals(new HashSet<>(), calendar.getEntries());
    }

    @Test
    public void testGetEmptyMeetings() {
        assertEquals(new HashSet<>(), calendar.getMeetings());
    }

    @Test
    public void testGetEmptyEvents() {
        assertEquals(new HashSet<>(), calendar.getEvents());
    }

    @Test
    public void testGetNonEmptyEntries() {
        Event e1 = new Event(new Date(20, 12, 2022), new Time(10, 10), "Personal");

        calendar.addEntry(e1);

        HashSet<Entry> array = new HashSet<>();
        array.add(e1);

        assertEquals(array, calendar.getEntries());
    }

    @Test
    public void testGetOneEntryByDate() {
        Event e1 = new Event(new Date(20, 12, 2022), new Time(10, 10), "Personal");
        Event e2 = new Event(new Date(10, 12, 2022), new Time(10, 10), "Personal");

        calendar.addEntry(e1);
        calendar.addEntry(e2);

        HashSet<Entry> array = new HashSet<>();
        array.add(e1);

        assertEquals(array, calendar.getEntriesByDate(new Date(20, 12, 2022)));
    }

    @Test
    public void testGetOneEntryByDateEmpty() {
        assertEquals(new HashSet<>(), calendar.getEntriesByDate(new Date(20, 12, 2022)));
    }

    @Test
    public void testGetEntryByLabelEmpty() {
        assertEquals(null, calendar.getEntryByLabel("Personal"));
    }

    @Test
    public void testGetEntryByLabelOne() {
        Entry e1 = new Event(new Date(10, 10, 2022), new Time(10, 10), "Test");
        calendar.addEntry(e1);
        assertEquals(e1, calendar.getEntryByLabel("Test"));
    }

    @Test
    public void testAddEntry() {
        assertEquals(calendar.getEntries().size(), 0);
        Entry e1 = new Event(new Date(10, 10, 2022), new Time(10, 10), "Test");
        calendar.addEntry(e1);
        assertEquals(1, calendar.getEntries().size());
    }

    @Test
    public void testAddEntryDuplicates() {
        assertEquals(calendar.getEntries().size(), 0);
        Entry e1 = new Event(new Date(10, 10, 2022), new Time(10, 10), "Test");
        calendar.addEntry(e1);
        calendar.addEntry(e1);
        assertEquals(1, calendar.getEntries().size());
    }

    @Test
    public void testGetEvents() {
        HashSet<Event> a1 = new HashSet<>();
        a1.add(e1);
        a1.add(e2);
        assertEquals(a1, filledCalendar.getEvents());
    }

    @Test
    public void testGetMeetings() {
        HashSet<Event> a1 = new HashSet<>();
        a1.add(m1);
        a1.add(m2);
        assertEquals(a1, filledCalendar.getMeetings());
    }

    @Test
    public void testRemoveEntryByLabel() {
        assertEquals(4, filledCalendar.getEntries().size());
        filledCalendar.removeEntryByLabel("Event1");
        assertEquals(3, filledCalendar.getEntries().size());
    }
}
