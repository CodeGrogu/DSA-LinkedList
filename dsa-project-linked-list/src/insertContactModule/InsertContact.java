package insertContactModule;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import sortModule.MergeSortFile;

public class InsertContact {

    private static LinkedList<Contact> contactList = new LinkedList<>();

    public static void addContact(String firstName, String lastName, String email, String phoneNumber, String company, String jobTitle, String city, String region, String country, String notes) {
        Contact newContact = new Contact(firstName, lastName, email, phoneNumber, company, jobTitle, city, region, country, notes);
        contactList.add(newContact);
        saveContactToCSV(newContact);
    }

    private static void saveContactToCSV(Contact contact) {
        try (FileWriter writer = new FileWriter("dsa-project-linked-list\\src\\data\\contacts.csv", true)) {
            writer.append(contact.getFirstName()).append(',')
                  .append(contact.getLastName()).append(',')
                  .append(contact.getEmail()).append(',')
                  .append(contact.getPhoneNumber()).append(',')
                  .append(contact.getCompany()).append(',')
                  .append(contact.getJobTitle()).append(',')
                  .append(contact.getCity()).append(',')
                  .append(contact.getRegion()).append(',')
                  .append(contact.getCountry()).append(',')
                  .append(contact.getNotes()).append('\n');
        // sort after inserting the name, to ensure the csv is always sorted
        MergeSortFile.sortTheCsv();

        
        // Display the inserted contacts details
        System.out.println("Contact added: ");
        System.out.println("First Name: " + contact.getFirstName());
        System.out.println("Last Name: " + contact.getLastName());
        System.out.println("Email: " + contact.getEmail());
        System.out.println("Phone Number: " + contact.getPhoneNumber());
        System.out.println("Company: " + contact.getCompany());
        System.out.println("Job Title: " + contact.getJobTitle());
        System.out.println("City: " + contact.getCity());
        System.out.println("Region: " + contact.getRegion());
        System.out.println("Country: " + contact.getCountry());
        System.out.println("Notes: " + contact.getNotes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}