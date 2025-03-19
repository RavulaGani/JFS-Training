package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class Practice5 {

	public static void main(String[] args) {
String query = "Select *from users;";
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "Ganesh@4598");
			System.out.println("Connection established success...");
			
		   Statement st = con.createStatement();
		   ResultSet rs= st.executeQuery(query);
		   ResultSetMetaData meta=rs.getMetaData();
			 
           System.out.println(meta.getColumnCount());
           System.out.println(meta.getColumnName(4));
           System.out.println(meta.getColumnTypeName(3));
           System.out.println(meta.getTableName(1));
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		

	}

}