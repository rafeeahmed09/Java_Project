package contact_app;

import java.sql.SQLException;
import java.util.Scanner;

// upadte class name to Main
public class main {
    static void main(String[] args) {





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


                    break;

                case "3":
                    System.out.print("Enter name to delete: ");
                    name = sc.nextLine();
                    contactsJDBC.delete(name);
                    // read(1)

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

                    break;
                case "5":
                    System.out.print("Enter the NAME of the contact you want to update: ");
                    String targetName = sc.nextLine();

                    System.out.println("Enter NEW details:");
                    System.out.print("New Phone: ");
                    String phone = sc.nextLine();
                    System.out.print("New Personal Email: "); personalEmail = sc.nextLine();
                    System.out.print("New Work Email: "); workEmail = sc.nextLine();
                    System.out.print("New Address: "); address = sc.nextLine();

                    // Calling the update method in JDBC class
                    contactsJDBC.updata(targetName, phone, personalEmail, workEmail, address);


                default:
                    System.out.println("Invalid  input");
            }
        }
        sc.close();
    }
}