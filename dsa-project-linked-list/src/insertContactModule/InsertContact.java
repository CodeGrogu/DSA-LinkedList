package insertContactModule;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class InsertContact {

    private static LinkedList<Contact> contactList = new LinkedList<>();

    public static void addContact(String firstName, String lastName, String email, String phoneNumber, String company, String jobTitle, String city, String region, String country, String notes) {
        Contact newContact = new Contact(firstName, lastName, email, phoneNumber, company, jobTitle, city, region, country, notes);
        contactList.add(newContact);
        saveContactToCSV(newContact);
    }

    private static void saveContactToCSV(Contact contact) {
        try (FileWriter writer = new FileWriter("data/contacts.csv", true)) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}