package model;

import java.util.*;
import java.util.stream.Collectors;

public class Calendar {
    Date currentDate;
    String ownerEmail;
    Set<Entry> entries = new HashSet<>();

    public Calendar(Date currentDate, String ownerEmail) {
        this.currentDate = currentDate;
        this.ownerEmail = ownerEmail;
    }

    // getters
    public Date getCurrentDate() { return currentDate; }
    public String getOwnerEmail() { return ownerEmail; }
    public Set<Entry> getEntries() { return entries; }
    public Set<Meeting> getMeetings() {
        Set<Meeting> out = new HashSet<>();
        for (Entry entry : entries
             ) {
            if(entry instanceof Meeting) {
                out.add((Meeting) entry);
            }
        }
        return out;
    }
    public Set<Event> getEvents() {
        Set<Event> out = new HashSet<>();
        for (Entry entry : entries
        ) {
            if(!(entry instanceof Meeting)) {
                out.add((Event) entry);
            }
        }
        return out;
     }

    // TODO
    // EFFECTS: returns an entry with a matching label if it exists
    public Entry getEntryByLabel(String label) throws NoSuchElementException {
        try {
            Entry output = entries.stream().filter(
                    entry -> entry.getLabel() == label
            ).findFirst().get();
            return output;
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    // TODO
    // EFFECTS: returns an entry with a matching label if it exists
    public Set<Entry> getEntriesByDate(Date date) {

        Set<Entry> output = entries.stream().filter(
                entry -> entry.getDate().equals(date)
        ).collect(Collectors.toSet());

        return output;
    }

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
