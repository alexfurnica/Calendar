package tests;

import model.Attendee;
import model.Date;
import model.Meeting;
import model.Time;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestMeeting {

    Meeting meeting;
    Attendee attendee;

    @Before
    public void setUp() {
        meeting = new Meeting(
                new Date(20, 10, 2020),
                new Time(10, 10),
                "Project Manhattan"
        );

        attendee = new Attendee(
                "John",
                "Johnson",
                "j.j@bean.stalk"
        );
    }

    @Test
    public void testGetEmptyEmailsList() {
        assertEquals(meeting.getEmailAddresses(), new ArrayList<>());
    }

    @Test
    public void testGetAttendees() {
        assertEquals(meeting.getAttendees(), new HashSet<>());
    }

    @Test
    public void testAddAttendee() {
        meeting.addAttendee(attendee);
        assertEquals(meeting.getAttendees().contains(attendee), true);
    }

    @Test
    public void testRemoveAttendee() {
        meeting.addAttendee(attendee);
        meeting.removeAttendee("j.j@bean.stalk");

        assertEquals(false, meeting.getAttendees().contains(attendee));
    }
}
