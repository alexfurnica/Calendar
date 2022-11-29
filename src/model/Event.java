package model;

public class Event extends Entry{

    public Reminder reminder;

    public Event(Date date, Time time, String label) {
        super(date, time, label);
    }

    // getters

    // REQUIRES: reminder is set
    // EFFECTS: returns the reminder
    public Reminder getReminder() {
        return reminder;
    }

    // setters

    // TODO
    // MODIFIES: this
    // EFFECTS: Sets a reminder for the Event, replacing the old one if existing
    public void setReminder(Reminder reminder) {

    }
}
