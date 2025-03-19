package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Practice2 {

	public static void main(String[] args) {
		String query = "DELETE From users where userid=?;";
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "Ganesh@4598");
			System.out.println("Connection established success...");
			
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,1004);
			
			int rows = ps.executeUpdate();
			System.out.println(rows + " row(s) affected");			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}