package model;

public class Reminder extends Entry{
    public String note;

    public Reminder(Date date, Time time, String label, String note) {
        super(date, time, label);
        this.note = note;
    }

    // getters

    // TODO
    // REQUIRES: note exists
    // EFFECTS: Returns the note
    public String getNote() {return "";}

    // setters

    // TODO
    // MODIFIES: this
    // EFFECTS: Replaces the note in the reminder
    public void setNote(String text) {};
}
