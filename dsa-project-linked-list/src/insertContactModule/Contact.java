//package insertContactModule;
// Contact.java
public class Contact {
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String email;

    public Contact(String firstName, String lastName, String phoneNumber, String email) {
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
        this.lastName = lastName;
        this.email = email;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + " , Phone Number: " + phoneNumber + " , Email: " + email + "\n";
    }
}