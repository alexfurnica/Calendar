package tests;

import model.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestCalendar {

    Calendar calendar;
    Calendar filledCalendar;
    Event e1;
    Event e2;
    Meeting m1;
    Meeting m2;

    @Before
    public void setUp() {
        calendar = new Calendar(
                new Date(20, 10, 2020),
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

    @Test
    public void testGetOneEntryByDateEmpty() {
        assertEquals(calendar.getEntriesByDate(new Date(20, 12, 2022)), null);
    }

    @Test
    public void testGetEntryByLabelEmpty() {
        assertEquals(calendar.getEntryByLabel("Personal"), null);
    }

    @Test
    public void testGetEntryByLabelOne() {
        Entry e1 = new Event(new Date(10, 10, 2022), new Time(10, 10), "Test");
        calendar.addEntry(e1);
        assertEquals(calendar.getEntryByLabel("Test"), e1);
    }

    @Test
    public void testAddEntry() {
        assertEquals(calendar.getEntries().size(), 0);
        Entry e1 = new Event(new Date(10, 10, 2022), new Time(10, 10), "Test");
        calendar.addEntry(e1);
        assertEquals(calendar.getEntries().size(), 1);
    }

    @Test
    public void testAddEntryDuplicates() {
        assertEquals(calendar.getEntries().size(), 0);
        Entry e1 = new Event(new Date(10, 10, 2022), new Time(10, 10), "Test");
        calendar.addEntry(e1);
        calendar.addEntry(e1);
        assertEquals(calendar.getEntries().size(), 1);
    }

    @Test
    public void testGetEvents() {
        ArrayList<Event> a1 = new ArrayList<>();
        Event e1 = new Event(new Date(20, 12, 2022), new Time(10, 10), "Personal");
        Event e2 = new Event(new Date(10, 12, 2022), new Time(10, 10), "Personal");
        a1.add(e1);
        a1.add(e2);
        assertEquals(filledCalendar.getEvents(), a1);
    }

    @Test
    public void testGetMeetings() {
        ArrayList<Event> a1 = new ArrayList<>();
        a1.add(m1);
        a1.add(m2);
        assertEquals(filledCalendar.getMeetings(), a1);
    }

    @Test
    public void testRemoveEntryByLabel() {
        assertEquals(filledCalendar.getEntries().size(), 4);
        filledCalendar.removeEntryByLabel("Event1");
        assertEquals(filledCalendar.getEntries().size(), 3);
    }
}
