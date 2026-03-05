package Hospital_Management_System;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Patientdatabase {

    private static final String url = "jdbc:mysql;//localhost:3306/";
    private static final String user = "root";
    private static final String password = "1234567890";

    // 1. Add patient (id, name, age,gender);
    public static void addPatient(Patient pt){
        String sql = "INSERT INTO Patents(id,name,age,gender) Values(?,?,?,?)";
        try (Connection con = DriverManager.getConnection(url,user,password);
        PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setString(1,pt.getId());
            pstmt.setString(2,pt.getName());
            pstmt.setString(3,pt.getAge());
            pstmt.setString(4, pt.getGender());
            pstmt.executeUpdate();
            System.out.println("INSERT A VALES IN PATIENT TABLES");


        }catch (SQLException e){
            System.out.println("Error insert " + e.getMessage());

        }
    }

    // 2. View ALL Patient

    public static void ViewAllPatient() throws  SQLException{
        String sql = "Select * from Patient";

        try(Connection con = DriverManager.getConnection(url,user,password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()){
                System.out.println("ID " + rs.getInt("id"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("AGE  : "  + rs.getInt("AGE"));
                System.out.println("Gender :  " + rs.getString("Gender"));
                System.out.println("---------------------------------------------------");
            }
        }catch (SQLException e){

        }

    }
    // update
    public static  void  update(Patient ps){
        try(Connection con = DriverManager.getConnection(url,user,password);
           PreparedStatement pstmt = con.prepareStatement("UPDATE Patient set id=?, name=?,age=?,Gneder=?")){
            pstmt.setString(1,ps.getId());
            pstmt.setString(2,ps.getName());
            pstmt.setString(3,ps.getAge());
            pstmt.setString(4,ps.getGender());

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

    // Search :
    public static void Search(Patient pt){
        String sql = "Select * from Patient where ID like ?";
        try(Connection con = DriverManager.getConnection(url,user,password);
        PreparedStatement pstmt = con.prepareStatement(sql)){
            pstmt.setInt(1, Integer.parseInt("%" + pt.getId() + "%"));
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                System.out.println();
            }

        }catch (SQLException e){
            System.out.println("Search in Error" + e.getMessage());
        }
    }
}
