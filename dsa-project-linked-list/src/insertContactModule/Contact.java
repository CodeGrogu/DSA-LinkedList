package insertContactModule;

public class Contact {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String company;
    private String jobTitle;
    private String city;
    private String region;
    private String country;
    private String notes;

    public Contact(String firstName, String lastName, String email, String phoneNumber, String company, String jobTitle, String city, String region, String country, String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.company = company;
        this.jobTitle = jobTitle;
        this.city = city;
        this.region = region;
        this.country = country;
        this.notes = notes;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + " , Email: " + email + " , Phone Number: " + phoneNumber + " , Company: " + company + " , Job Title: " + jobTitle + " , City: " + city + " , Region: " + region + " , Country: " + country + " , Notes: " + notes + "\n";
    }
}