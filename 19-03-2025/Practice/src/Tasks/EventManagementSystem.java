package Tasks;

import java.sql.*;
import java.util.Scanner;

public class EventManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Display menu
            System.out.println("--- Event Management System ---");
            System.out.println("1. Register New User");
            System.out.println("2. Edit User");
            System.out.println("3. Delete User");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    registerUser(scanner);
                    break;
                case 2:
                    editUser(scanner);
                    break;
                case 3:
                    deleteUser(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Method to register a new user
    private static void registerUser(Scanner scanner) {
        System.out.println("\n--- Register New User ---");
        System.out.print("Enter Name: ");
        String p_name = scanner.nextLine();
        System.out.print("Enter College Name: ");
        String clgname = scanner.nextLine();
        System.out.print("Enter Event Name: ");
        String e_name = scanner.nextLine();
        System.out.print("Enter Gmail: ");
        String gmail = scanner.nextLine();
        System.out.print("Enter Team Name: ");
        String t_name = scanner.nextLine();

        try  {
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventdb", "root", "Ganesh@4598");
            System.out.println("Connection established successfully...");
            String sql = "INSERT INTO event1 (p_name, clgname, e_name, gmail, t_name) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, p_name);
            statement.setString(2, clgname);
            statement.setString(3, e_name);
            statement.setString(4, gmail);
            statement.setString(5, t_name);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User registered successfully!");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to edit an existing user
    private static void editUser(Scanner scanner) {
        System.out.println("\n--- Edit User ---");
        System.out.print("Enter Gmail of the user to edit: ");
        String gmail = scanner.nextLine();
        System.out.print("Enter New College Name: ");
        String clgname = scanner.nextLine();
        System.out.print("Enter New Event Name: ");
        String e_name = scanner.nextLine();
        System.out.print("Enter New Team Name: ");
        String t_name = scanner.nextLine();

        try {
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventdb", "root", "Ganesh@4598");
            System.out.println("Connection established successfully...");
            String sql = "UPDATE event1 SET clgname = ?, e_name = ?, t_name = ? WHERE gmail = ?";
            //String sql= ""update event1 set (clgname,e_name,t_name);
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, clgname);
            statement.setString(2, e_name);
            statement.setString(3, t_name);
            statement.setString(4, gmail);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("User updated successfully!");
            } else {
                System.out.println("User not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to delete a user
    private static void deleteUser(Scanner scanner) {
        System.out.println("\n--- Delete User ---");
        System.out.print("Enter Gmail of the user to delete: ");
        String gmail = scanner.nextLine();

        try {
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventdb", "root", "Ganesh@4598");
            System.out.println("Connection established successfully...");
            String sql = "DELETE FROM event1 WHERE gmail = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, gmail);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("User deleted successfully!");
            } else {
                System.out.println("User not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}