import model.*;

public class Main {
    public static void main(String[] args) {

        // Attendees
        Attendee jack = new Attendee("Jack", "Goober", "jack.goober@bean.stalk");
        Attendee jill = new Attendee("Jill", "Flance", "jill.flance@bean.stalk");
        Attendee johnson = new Attendee("Johnson", "Rohr", "j.rohr@bean.stalk");
        Attendee janet = new Attendee("Janet", "Comenco", "janet.comenco@bean.stalk");

        // Events
        Event event1 = new Event(
                new Date(1, 12, 2022),
                new Time(20, 20),
                "Dentist appointment"
        );

        Event event2 = new Event(
                new Date(1, 1, 2023),
                new Time(20, 25),
                "Try to fly"
        );

        // Meetings
        Meeting meeting1 =  new Meeting(
                new Date(1, 12, 2022),
                new Time(15, 00),
                "Discuss Satan"
        );
        meeting1.addAttendee(jill);
        meeting1.addAttendee(johnson);

        Meeting meeting2 =  new Meeting(
                new Date(13, 12, 2022),
                new Time(16, 00),
                "Plan awakening of our lord"
        );
        meeting2.addAttendee(jack);
        meeting2.addAttendee(janet);

        // Calendar
        Calendar calendar = new Calendar(
                new Date(24, 11, 2022),
                "alucard@bean.stalk"
        );

        calendar.addEntry(event1);
        calendar.addEntry(event2);
        calendar.addEntry(meeting1);
        calendar.addEntry(meeting2);

        System.out.println(calendar.getCurrentDate());
        System.out.println(calendar.getOwnerEmail());
        System.out.println(calendar.getEntries());
        System.out.println(calendar.getMeetings());
        System.out.println(calendar.getEvents());
        System.out.println(calendar.getEntryByLabel("Discuss Satan"));
        System.out.println(calendar.getEntriesByDate(new Date(1, 12, 2022)));

        meeting2.sendInvites();
    }
}