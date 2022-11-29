package tests;

import model.Attendee;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAttendee {

    Attendee attendee;

    @Before
    public void setUp() {
        attendee = new Attendee("a", "a", "a.a@bean.stalk");
    }

    @Test
    public void testConstructor() {
        assertEquals(attendee.getFirstName(), "a");
        assertEquals(attendee.getLastName(), "a");
        assertEquals(attendee.getEmailAddress(), "a.a@bean.stalk");
    }

    @Test
    public void testGetFirstName() {
        assertEquals(attendee.getFirstName(), "a");
    }

    @Test
    public void testGetLastName() {
        assertEquals(attendee.getLastName(), "a");
    }

    @Test
    public void testGetEmailAddress() {
        assertEquals(attendee.getEmailAddress(), "a.a@bean.stalk");
    }
}
