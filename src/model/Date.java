package model;

import java.util.HashMap;
import java.util.Map;

public class Date {
    public int day;
    public int month;
    public int year;
    public Map<Integer, String> date_mapping = new HashMap<>();

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

    private void instantiateMap() {
        date_mapping.put(1, "January");
        date_mapping.put(2, "February");
        date_mapping.put(3, "March");
        date_mapping.put(4, "April");
        date_mapping.put(5, "May");
        date_mapping.put(6, "June");
        date_mapping.put(7, "July");
        date_mapping.put(8, "August");
        date_mapping.put(9, "September");
        date_mapping.put(10, "October");
        date_mapping.put(11, "November");
        date_mapping.put(12, "December");
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
}
