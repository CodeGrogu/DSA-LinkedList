package insertContactModule;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
// import insertContactModule.Contact;

public class InsertContact {

    private static LinkedList<Contact> contactList = new LinkedList<>();

    public static void addContact(String firstName, String lastName, String phoneNumber, String email) {
        Contact newContact = new Contact(firstName, lastName, phoneNumber, email);
        contactList.add(newContact);
        System.out.println("Contact added: " + newContact);
    }

    
    public void contactsToFile() {
        try {
            FileWriter writer = new FileWriter("contacts.csv");
            writer.write("First Name,Last Name,Phone Number,Email\n"); // CSV headers
    
            for (Contact contact : contactList) {
                writer.write(contact.getFirstName() + "," + contact.getLastName() + "," + contact.getPhoneNumber() + "," + contact.getEmail() + "\n");
            }
    
            writer.close(); // Close the writer to flush data and release resources
            System.out.println("Contacts saved to contacts.csv");
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception if file writing fails
        }
    }
}