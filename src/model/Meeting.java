package model;

import java.util.ArrayList;
import java.util.List;

public class Meeting extends Event{

    public List<Attendee> attendees = new ArrayList<>();

    public Meeting(Date date, Time time, String label) {
        super(date, time, label);
    }

    // getters

    // REQUIRES: attendees list not empty
    // EFFECTS: returns the list of all registered attendees' email addresses
    public List<String> getEmailAddresses() {
        List<String> emails = new ArrayList<>();
        for (Attendee attendee : attendees
             ) {
            emails.add(attendee.getEmailAddress());
        }
        return emails;
    }

    // EFFECTS: return list of all attendees
    public List<Attendee> getAttendees() {
        return attendees;
    }

    // setters

    // TODO
    // MODIFIES: this
    // EFFECTS: adds a new attendee to the meeting
    public void addAttendee(Attendee newAttendee) {}

    // TODO
    // REQUIRES: Attendee with matching email exists
    // MODIFIES: this
    // EFFECTS: removes an attendee from the meeting
    public void removeAttendee(String emailAddress) {}

    // TODO
    // REQUIRES: Attendee list not empty
    // EFFECTS: Prints out the invitation for all invited attendees
    public void sendInvites() { System.out.println("sendInvites called"); }
}
