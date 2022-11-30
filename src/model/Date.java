package model;

import java.util.HashMap;
import java.util.Map;

public class Date {
    public int day;
    public int month;
    public int year;
    public  static Map<Integer, String> date_mapping = Date.instantiateMap();

    public Date(int day, int month, int year) {
        setDay(day);
        setMonth(month);
        setYear(year);
        instantiateMap();
    }

    public String getShortDate() {
        return(day + "-" + month + "-" + year);
    }

    public String getLongDate() {
        String month_name = date_mapping.get(this.month);
        return(month_name + " " + day + ", " + year);
    }

    private static Map<Integer, String> instantiateMap() {
        Map<Integer, String> mapping = new HashMap<>();
        mapping.put(1, "January");
        mapping.put(2, "February");
        mapping.put(3, "March");
        mapping.put(4, "April");
        mapping.put(5, "May");
        mapping.put(6, "June");
        mapping.put(7, "July");
        mapping.put(8, "August");
        mapping.put(9, "September");
        mapping.put(10, "October");
        mapping.put(11, "November");
        mapping.put(12, "December");

        return mapping;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return getShortDate();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Date)) {
            return false;
        }

        Date c = (Date) o;

        if (
                this.day == c.day && this.month == c.month && this.year == c.year
        ) {
            return true;
        }

        return false;
    }
}
