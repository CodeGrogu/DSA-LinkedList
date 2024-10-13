package displayContactModule;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisplayContacts {
    public static void displayContacts(List<Contact> contacts, Scanner scanner) {
        int page = 0;
        int pageSize = 10;
        boolean morePages = true;

        while (morePages) {
            int start = page * pageSize;
            int end = Math.min(start + pageSize, contacts.size());

            for (int i = start; i < end; i++) {
                System.out.println(contacts.get(i));
            }

            if (end == contacts.size()) {
                morePages = false;
                System.out.println("End of contacts.");
            } else {
                System.out.println("Press Enter to see the next page or type 'exit' to quit.");
                String input = scanner.nextLine();
                if ("exit".equalsIgnoreCase(input)) {
                    morePages = false;
                } else {
                    page++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String filePath = "dsa-project-linked-list\\src\\data\\contacts.csv";
        List<Contact> contacts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();  // Read the header line
            while ((line = br.readLine()) != null) {
                String[] contactData = line.split(",");
                Contact contact = new Contact(contactData[0], contactData[1], contactData[2]);
                contacts.add(contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Scanner scanner = new Scanner(System.in)) {
            displayContacts(contacts, scanner);
        }
    }
}

class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return name + ", " + phone + ", " + email;
    }
}