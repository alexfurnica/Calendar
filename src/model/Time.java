package model;

public class Time {
    public int hours;
    public int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public String toString() {
        return(hours + ":" + minutes);
    }
}
