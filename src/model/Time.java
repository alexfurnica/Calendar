package model;

public class Time {
    public Integer hours;
    public Integer minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    @Override
    public String toString() {

        String updated_minutes;
        String updated_hours;

        if (minutes < 10) {
            updated_minutes = "0" + minutes;
        } else {
            updated_minutes = minutes.toString();
        }

        if (hours < 10) {
            updated_hours = "0" + hours;
        } else {
            updated_hours = hours.toString();
        }

        return(updated_hours + ":" + updated_minutes);
    }
}
