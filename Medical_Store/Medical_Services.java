package Medical_Store;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Statement;

public class Medical_Services {

    static final String URL = "jdbc:mysql://localhost:3306/medicalStoreDB";
    static final String USER = "root";
    static final String PASSWORD = "1234567890";

     public static void main(String[] args) {

        Billing();

    }


   // -- All Customers ---
    public static void createTable() {

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS Customers ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "name VARCHAR(100) NOT NULL, "
                    + "phone VARCHAR(15) UNIQUE"
                    + ");";

            stmt.executeUpdate(sql);
            System.out.println("Table created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add new Customers.
    public static void AddCustomers(Customers cs){
         String sql = "INERT INTO Customers(id, name , phone)VALUES(?,?,?)";
         try(Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
             PreparedStatement pstmt = con.prepareStatement(sql)){
             pstmt.setInt(1,cs.getId());
             pstmt.setString(2,cs.getName());
             pstmt.setString(3,cs.getPhone());

         } catch (SQLException e) {
             throw new RuntimeException(e);
         }

    }

    // View All Customers data
    public List<Customers> getviewALL() throws SQLException{
         List<Customers> list =  new ArrayList<>();
         try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
              Statement st = con.createStatement();
              ResultSet rs = st.executeQuery("SELECT * FROM Custmoers")){
             while (rs.next()){
                 list.add(new Customers(rs.getInt("id"), rs.getNString("name"), rs.getString("phone") ));
             }

         }catch (SQLException e){
             e.printStackTrace();
         }
        return list;
    }

    // update
    public static void upate(Customers cs){
         String sql = "UPDATE Customers set id=? , name=?,phone=?";
         try(Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement pstmt = con.prepareStatement(sql)){
             pstmt.setInt(1,cs.getId());
             pstmt.setString(2,cs.getName());
             pstmt.setString(3,cs.getPhone());
             int row = pstmt.executeUpdate();
             if (row > 0){
                 System.out.println("Success updated" + row);
             }else {
                 System.out.println("NOT Update " + row);
             }

         }catch (SQLException e){
             e.printStackTrace();
         }

    }
    // Delete
    public static void delete(String id){
         String sql = "DELETE FROM Customers where id = ?";
         try(Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
         PreparedStatement pstmt = con.prepareStatement(sql)){
             pstmt.setString(1,id);
             pstmt.executeUpdate();
         }catch (SQLException e){
             e.printStackTrace();
         }

    }

    // -- All Medicines --
    /*  id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DOUBLE NOT NULL,
    stock INT NOT NULL */

    public static void MedicinesTable() {

        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = con.createStatement()) {


            String sql = "CREATE TABLE IF NOT EXISTS Medicines ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "name VARCHAR(100) NOT NULL, "
                    + "price DOUBLE NOT NULL, "
                    + "stock INT NOT NULL"
                    + ");";

            stmt.executeUpdate(sql);
            System.out.println("Table created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Add new Medicines

    public static void AddMedicines(Medicines Ms){
        try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO (id, name, price, stock )VALUES(?,?,?,?)")) {
            pstmt.setInt(1,Ms.getId());
            pstmt.setString(2,Ms.getName());
            pstmt.setDouble(3,Ms.getPrice());
            pstmt.setDouble(4,Ms.getStock());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // View ALL Medicines Data
    public  List<Medicines> getAll(){
        List<Medicines> list =  new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM medicines")){
            while (rs.next()){
                list.add(new Medicines(rs.getInt("id"), rs.getString("name"), rs.getDouble("Price"),rs.getDouble("stock")));
            }



        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
    // update Medicines
    public static void updateMedicines(Medicines Ms){
        try(Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement pstmt = con.prepareStatement("UPDATE Medicines set id=?,name=?,price=?,stock=?");){

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    // Delete

    public static void Delete(int id){
        try(Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
          PreparedStatement pstmt = con.prepareStatement("DELETE FROM Medicines Where id = ?")){
            pstmt.setInt(1,id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // Search : Medicines using name:
   public static void Search(Medicines Ms){
       try(Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
        PreparedStatement pstmt = con.prepareStatement("SELECT * FROM Medicines where name like  ?")){
           pstmt.setString(1, Ms.getName());
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }


   // Final Billing ---
    /*bill_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    medicine_id INT,
    quantity INT NOT NULL,
    total_price DOUBLE NOT NULL,
    bill_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    -- Constraints to link tables
    FOREIGN KEY (customer_id) REFERENCES Customers(id) ON DELETE CASCADE,
    FOREIGN KEY (medicine_id) REFERENCES Medicines(id) ON DELETE CASCADE*/

    public static void Billing(){
        try(Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
           Statement stmt = con.createStatement()){
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Billings ("
                    + "id INT PRIMARY KEY AUTO_INCREMENT, "
                    + "customer_id int ,"
                    + "medicine_id int ,"
                    + "quantity int not null,"
                    + "Total_Price DOUBLE not null,"
                    + "bill_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                    + "FOREIGN KEY (customer_id) REFERENCES customers(id) ON DELETE CASCADE,"
                    + " FOREIGN KEY (medicine_id) REFERENCES medicines(id) ON DELETE CASCADE"
                    + ");");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}