package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Meeting extends Event{

    public Set<Attendee> attendees = new HashSet<>();

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
    public Set<Attendee> getAttendees() {
        return attendees;
    }

    // setters

    // MODIFIES: this
    // EFFECTS: adds a new attendee to the meeting
    public void addAttendee(Attendee newAttendee) {
        attendees.add(newAttendee);
    }

    // REQUIRES: Attendee with matching email exists
    // MODIFIES: this
    // EFFECTS: removes an attendee from the meeting
    public void removeAttendee(String emailAddress) {
        attendees = attendees.stream().filter(att -> att.getEmailAddress() != emailAddress).collect(Collectors.toSet());
    }

    // REQUIRES: Attendee list not empty
    // EFFECTS: Prints out the invitation for all invited attendees
    public void sendInvites() {
        for (Attendee at:
             attendees) {
            System.out.println("\n" + at.getEmailAddress() + " has been invited.");
        }
    }
}
