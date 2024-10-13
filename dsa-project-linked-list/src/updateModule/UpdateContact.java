package updateModule;

import java.io.*;
import java.util.*;

public class UpdateContact {
    
    public static void updateContact(String firstName, String lastName) {
        String filePath = "data/contacts.csv";
        List<String[]> contacts = new ArrayList<>();
        boolean contactFound = false;

        // Read the CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] contact = line.split(",");
                contacts.add(contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Check for matching contact
        for (String[] contact : contacts) {
            if (contact[0].equals(firstName) && contact[1].equals(lastName)) {
                contactFound = true;
                Scanner scanner = new Scanner(System.in);

                // Prompt for new details
                System.out.print("Enter new first name: ");
                contact[0] = scanner.nextLine();
                System.out.print("Enter new last name: ");
                contact[1] = scanner.nextLine();
                System.out.print("Enter new phone number: ");
                contact[2] = scanner.nextLine();
                System.out.print("Enter new email: ");
                contact[3] = scanner.nextLine();
                break;
            }
        }

        if (!contactFound) {
            System.out.println("Contact not found.");
            return;
        }

        // Write the updated data back to the CSV file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] contact : contacts) {
                bw.write(String.join(",", contact));
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
