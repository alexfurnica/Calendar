package model;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
    Date currentDate;
    String ownerEmail;
    List<Entry> entries = new ArrayList<Entry>();

    public Calendar(Date currentDate, String ownerEmail) {
        this.currentDate = currentDate;
        this.ownerEmail = ownerEmail;
    }

    // getters
    public Date getCurrentDate() { return currentDate; }
    public String getOwnerEmail() { return ownerEmail; }
    public List<Entry> getEntries() { return entries; }
    public List<Meeting> getMeetings() {
        List<Meeting> out = new ArrayList<>();
        for (Entry entry : entries
             ) {
            if(entry instanceof Meeting) {
                out.add((Meeting) entry);
            }
        }
        return out;
    }
    public List<Event> getEvents() { return new ArrayList<>(); }

    // TODO
    // EFFECTS: returns an entry with a matching label if it exists
    public Entry getEntryByLabel(String label) {return new Meeting(
            new Date(10,10,10),
            new Time(10, 10),
            "");
    }

    // TODO
    // EFFECTS: returns an entry with a matching label if it exists
    public List<Entry> getEntriesByDate(Date date) { return new ArrayList<>(); }

    // setters

    // MODIFIES: this
    // EFFECTS: Adds an entry to the calendar
    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    // TODO
    // MODIFIES: this
    // EFFECTS: Removes an entry from the calendar by label
    public void removeEntryByLabel(String label) {  }
}
