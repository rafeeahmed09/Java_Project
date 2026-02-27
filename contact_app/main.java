package contact_app;

import java.sql.SQLException;
import java.util.Scanner;

// upadte class name to Main
public class main {
    static void main(String[] args) {

        // removed unused contactManager
        // ContactManager cm = new ContactManager();
        // contactsJDBC cs = new contactsJDBC();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n [1] Add \n [2] Search \n [3] Delete \n [4] view All \n [5] updata \n [6] exit");
            System.out.println("Selection option");
            // globalized all variables to reusability
            String name;
            String Phone;
            String personalEmail;
            String workEmail;
            String address;

            String choice = sc.nextLine();
            if (choice.equals("6")) {
                break;
            }
            switch (choice) {
                case "1":
                    System.out.println("Enter you name : ");
                    // String name = sc.nextLine();
                    name = sc.nextLine();
                    System.out.println("Enter you Phone : ");
                    // String Phone = sc.nextLine();
                    Phone = sc.nextLine();
                    System.out.println("Enter you  PersonalEmail");
                    // String personalEmail = sc.nextLine();
                    personalEmail = sc.nextLine();
                    System.out.println("Enter you workEmail: ");
                    // String workEmail = sc.nextLine();
                    workEmail = sc.nextLine();
                    System.out.println("Enter you addess");
                    // String address = sc.nextLine();
                    address = sc.nextLine();

                    contactsJDBC.add(name, Phone, personalEmail, workEmail, address);
                    /*
                     * (1) removed object of contactManager
                     * cm.add(name, Phone, personalEmail, workEmail, address);
                     */
                    break;

                case "2":
                    System.out.println("Enter name  to search");
                    name = sc.nextLine();
                    contactsJDBC.Search(name);
                    // read(1)
                    // cm.search(sc.nextLine());

                    break;

                case "3":
                    System.out.print("Enter name to delete: ");
                    name = sc.nextLine();
                    contactsJDBC.delete(name);
                    // read(1)
                    // cm.delete(sc.nextLine());
                    break;

                case "4":
                    System.out.print("All Contacts:\n");
                    try {
                        contactsJDBC.viewAll();
                    } catch (SQLException e) {
                        System.out.println("error occurred " + e);
                        e.printStackTrace();
                    }
                    // read(1)
                    // cm.viewAll();
                    break;
                case "5":
                    System.out.println("Enter name to update:");
                    String nameofupdata = sc.nextLine();
                    // read(1)
                    // cm.updata(nameofupdata, sc);

                default:
                    System.out.println("Invalid  input");
            }
        }
        sc.close();
    }
}