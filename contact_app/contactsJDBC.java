
package contact_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class contactsJDBC {

    private static final String URL = "jdbc:mysql://localhost:3306/contacts_bd";
    private static final String user = "root";
    private static final String password = "1234567890";

    // 1. Table step
    public static void setupDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS contacts (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "phone TEXT, " +
                "personalEmail TEXT NOT NULL," +
                "WorkEmail TEXT NOT NULL ," +
                "address TEXT)";

        try (Connection conn = DriverManager.getConnection(URL, user, password);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("DB Setup Error: " + e.getMessage());
        }
    }

    // 2 ADD Contact : saars 5 fields ke sath
    public static void add(String name, String phone, String personalEmail, String workEmail, String Address) {
        String sql = "INSERT INTO contacts(name, phone, personalEmail, workEmail, address) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setString(3, personalEmail);
            pstmt.setString(4, workEmail);
            pstmt.setString(5, Address);
            pstmt.executeUpdate();
            System.out.println("Success  Contact  saved  with all details");

        } catch (SQLException e) {
            System.out.println("Error insert " + e.getMessage());
        }
    }

    // 3. view All
    public static void viewAll() throws SQLException {
        String sql = "Select * from contacts";
        try (Connection con = DriverManager.getConnection(URL, user, password);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Phone: " + rs.getString("phone"));
                System.out.println("Emails: [Personal: " + rs.getString("personalEmail") +
                        "] [Work: " + rs.getString("workEmail") + "]");
                System.out.println("Address: " + rs.getString("address"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error  " + e.getMessage());

        }
    }

    // 4. Update
    public static void updata(String name, String phone, String personalEmail, String workEmail, String Address) {
        String sql = "UPDATE  contacts  set phone=?, personalEmail=?, workEmail=?, Address=?, name=?";
        try (Connection con = DriverManager.getConnection(URL, user, password);
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, phone);
            pstmt.setString(2, personalEmail);
            pstmt.setString(3, workEmail);
            pstmt.setString(4, Address);
            pstmt.setString(5, name);
            int row = pstmt.executeUpdate();
            System.out.println(row > 0 ? "Success: Updated!" : "Contact not found.");

        } catch (SQLException e) {
            System.out.println("Update Error : " + e.getMessage());
        }

    }

    // 5.Delete
    public static void delete(String name) {
        String sql = "Delete from contacts where name = ?";
        try (Connection con = DriverManager.getConnection(URL, user, password);
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, name);
            // executing the delete query
            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // 6. Search : partial name search.
    public static void Search(String name) {
        String sql = "Select * from contacts where name like ? ";
        try (Connection con = DriverManager.getConnection(URL, user, password);
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
