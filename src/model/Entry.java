package model;

public abstract class Entry {
    public Date date;
    public Time time;
    public String label;

    // Interval represented in days
    public int interval;
    public boolean repeating;

    public Entry(Date date, Time time, String label) {
        this.date = date;
        this.time = time;
        this.label = label;
    }

    // getters
    public Date getDate() {
        return date;
    }

    public Time getTime() {
        return time;
    }

    public String getLabel() {
        return label;
    }

    public int getInterval() {
        return interval;
    }

    public boolean isRepeating() {
        return repeating;
    }

    //setters

    // MODIFIES: This
    // EFFECT: Sets the number of days at which the entry repeats
    public void setInterval(int interval) {
        this.interval = interval;
        this.repeating = true;
    }

    @Override
    public String toString() {
        return (
                "["
                + this.getClass().getSimpleName()
                + "] "
                + "Date: "
                + getDate()
                + " Time: "
                + getTime()
                + " Label: "
                + getLabel()
        );
    }
}
