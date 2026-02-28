//package Hospital_Management_System;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//public class Hospital {
//  private static final String URl = "jdbc:mysql://localhost:3306/";
//  private static final String USE = "root";
//  private static final String PASSWORD = "1234567890";
//
//    static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        try {
//            Connection con = DriverManager.getConnection(URl,USE,PASSWORD);
//            Patient pat = new Patient(con,scanner);
//            Doctor dr = new Doctor(con);
//            while (true){
//              System.out.println("Hospital Management ");
//              System.out.println("1. Add Patient");
//              System.out.println("2. View Patient");
//              System.out.println("3 Check a Patient");
//              System.out.println("4 View Doctor");
//              System.out.println("5 Exit");
//              System.out.println("Enter your choice : ");
//              int choics = scanner.nextInt();
//
//              switch (choics){
//                  case 1 // Add patient
//                      pat.addPatient();
//
//                  case 2  // view patient
//                      pat.viewPatients();
//
//                   case 3 // view Doctor
//                       pat.getPatientById();
//                   case 4.
//                       dr.viewPatients();
//                   case 5
//
//
//              }
//            }
//
//        }catch (SQLException e){
//
//        }
//    }
//
//    public static void BookAppointment(Connection con , Scanner scanner){
//
//
//    }
//}
