package Hospital_Management_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctor {
    private Connection connection; // Removed 'static' to keep it instance-based


    public Doctor(Connection connection) {
        this.connection = connection;

    }


    // 2. View All Doctor
    public void viewPatients() {
        String query = "SELECT * FROM Doctor";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Doctor: ");
            System.out.println("+------------+--------------------+----------+-----");
            System.out.println("| Doctor Id | Name               | Specialization |");
            System.out.println("+------------+--------------------+----------+-----");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialization = resultSet.getString("specialization");
                // Fixed the printf logic for table alignment
                System.out.printf("|%-12s|%-20s|%-18s|\n", id, name, specialization);
                System.out.println("+------------+--------------------+----------+-----");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3. Check if Patient Exists
    public boolean getPatientById(int id) {
        String query = "SELECT * FROM Doctor WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Returns true if patient exists
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
