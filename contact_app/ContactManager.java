package contact_app;
import java.util.ArrayList;
import java.util.Scanner;
public class ContactManager {
    
    private ArrayList<Contact> contactList = new ArrayList<>();

    // 2. Add
    public void add(String name, String phone, String personalEmail, String wEmail, String address) {
        contactList.add(new Contact(name, phone, personalEmail, wEmail,address));
        System.out.println("Contact saved");
    }

    // 3. View All (Fixed the variable names to match)
    public void viewAll() {
    if (contactList.isEmpty()) {
        System.out.println("Address Contact is empty.");
    } else {
        System.out.println("\n" + "=".repeat(100));
        // Table Header
        System.out.printf("%-3s | %-15s | %-12s | %-20s | %-20s | %-15s\n", 
                          "ID", "Name", "Phone", "Personal Email", "Work Email", "Address");
        System.out.println("-".repeat(100));

        // Table Rows
        for (int i = 0; i < contactList.size(); i++) {
            Contact c = contactList.get(i);
            System.out.printf("%-3d | %-15s | %-12s | %-20s | %-20s | %-15s\n", 
                              (i + 1), 
                              c.getName(), 
                              c.getPhone(), 
                              c.getPersonalEmail(), 
                              c.getWorkEmail(), 
                              c.getAddress());
        }
        System.out.println("=".repeat(100));
    }
}

    // 4. Search (Fixed variable name)
    public void search(String name) {
        contactList.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .forEach(c -> System.out.println("Found: " + c));
    }

    // 5. Delete (Fixed variable name)
    public void delete(String name) {
        boolean removed = contactList.removeIf(c -> c.getName().equalsIgnoreCase(name));
        System.out.println(removed ? "Deleted successfully." : "Name not found.");
    }

    // 6. Update (Fixed variable name and Scannner spelling)
    public void updata(String name, Scanner sc) {
        for (Contact c : contactList) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.println("Updating : " + c.getName());
                System.out.println("1.Name | 2.Phone | 3.Personal Email | 4.Work Email | 5.Address");
                System.out.print("Choose field to update: ");

                int choice = sc.nextInt();
                sc.nextLine(); // clear the scanner buffer.

                switch (choice) {
                    case 1:
                        System.out.print("Enter new name: ");
                        c.setName(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Enter new Phone: ");
                        c.setPhone(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Enter new Personal Email: ");
                        c.setPersonalEmail(sc.nextLine());
                        break;
                    case 4:
                        System.out.print("Enter new Work Email: ");
                        c.setWorkEmail(sc.nextLine());
                        break;
                    case 5:
                        System.out.print("Enter new Address: ");
                        c.setAddress(sc.nextLine());
                        break;
                    default:
                        System.out.println("Invalid field selection!");
                        return;
                }
                System.out.println("Update successful");
                return;
            }
        }
        System.out.println("Contact with name '" + name + "' not found.");
    }


}