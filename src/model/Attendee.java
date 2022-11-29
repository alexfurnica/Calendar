package model;

public class Attendee {
    public String firstName;
    public String lastName;
    public String emailAddress;

    public Attendee(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    // getters
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getEmailAddress() {return emailAddress;}
}
