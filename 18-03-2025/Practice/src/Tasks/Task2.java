package Tasks;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Task2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the mail Id:");
		String mail=sc.next();
		String query="select* from users where gmail='" + mail + "';";
		String url="jdbc:mysql://localhost:3306/testdb";
		
		try {
			Connection con=DriverManager.getConnection(url,"root","Ganesh@4598");
			System.out.println("Connected Sucessfully...");
			Statement st= con.createStatement();
			ResultSet rs= st.executeQuery(query);
			if(rs.next()){
				String pass=rs.getString("pass");
				System.out.print("Enter the password: ");
				String password=sc.next();
				
				if(password.equals(pass)){
					System.out.println("welcome back "+rs.getString("Gmail"));
				}
				else{
					System.out.println("Incorrect Password");
				}
				}
			else{
					System.out.println("User not found...");
				}
			}
		catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
