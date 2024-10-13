package displayContactModule;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisplayContacts {
    public static void displayContacts() {
        String filePath = "dsa-project-linked-list\\src\\data\\contacts.csv";
        List<String[]> contacts = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();  // Read the header line
            while ((line = br.readLine()) != null) {
                String[] contact = line.split(",");
                contacts.add(contact);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Scanner scanner = new Scanner(System.in)) {
            int page = 0;
            int pageSize = 10;
            boolean morePages = true;

            while (morePages) {
            int start = page * pageSize;
            int end = Math.min(start + pageSize, contacts.size());

            System.out.println("Displaying contacts " + (start + 1) + " to " + end + " of " + contacts.size());
            for (int i = start; i < end; i++) {
                String[] contact = contacts.get(i);
                System.out.println(String.join(", ", contact));
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
    }
}