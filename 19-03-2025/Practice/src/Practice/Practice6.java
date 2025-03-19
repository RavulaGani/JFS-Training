package Practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class Practice6 {

	public static void main(String[] args) {

		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "Ganesh@4598");
			System.out.println("Connection established success...");
			
		   DatabaseMetaData metainfo =con.getMetaData();
		   System.out.println(metainfo.getDriverName());
		   System.out.println(metainfo.getDriverVersion());
		   System.out.println(metainfo.getUserName());
		   System.out.println(metainfo.getDatabaseProductName());
		   System.out.println(metainfo.getDatabaseProductVersion());
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		

	}

}