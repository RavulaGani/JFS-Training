package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Practice3 {

	public static void main(String[] args) {
String query = "UPDATE users SET username = ?, gmail = ?, userpass = ? WHERE userid = ?;";
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "Ganesh@4598");
			System.out.println("Connection established success...");
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,"Hemu");
			ps.setString(2,"hemu@gmail.com");
			ps.setString(3,"Hemanth@123");
			ps.setInt(4, 1002);
			
			int rows = ps.executeUpdate();
			System.out.println(rows + " row(s) affected");			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		

	}

}