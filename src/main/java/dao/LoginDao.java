package dao;

import java.sql.ResultSet;

import jdbc.Jdbc;
import model.Customer;
import model.Login;

public class LoginDao {
	/*
	 * This class handles all the database operations related to login functionality
	 */
	
	private String [] roles= {"manager","customerRepresentative","customer"};
	public Login login(String username, String password) {
		/*
		 * Return a Login object with role as "manager", "customerRepresentative" or "customer" if successful login
		 * Else, return null
		 * The role depends on the type of the user, which has to be handled in the database
		 * username, which is the email address of the user, is given as method parameter
		 * password, which is the password of the user, is given as method parameter
		 * Query to verify the username and password and fetch the role of the user, must be implemented
		 */
		
		/*Sample data begins*/
		//Old
//		Login login = new Login();
//		login.setRole("customerRepresentative");
//		return login;
		//New
		Login login=null;
		System.out.println("*******Get Login username & manager**********");
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
////			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:8081/cse305pa3","root","40302000");
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305pa3?"+"user=root&password=40302000");
//			System.out.println("*************Successful Connection **************");
//			Statement st=con.createStatement();
//			ResultSet ss =Jdbc.newStatement("select  from customer");
			
			login=new Login();
			login.setUsername(username);
			login.setPassword(password);
			//Hardcoded roles for now 
			login.setRole(roles[2]);;			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return login;
		/*Sample data ends*/
		
	}
	
	public String addUser(Login login) {
		/*
		 * Query to insert a new record for user login must be implemented
		 * login, which is the "Login" Class object containing username and password for the new user, is given as method parameter
		 * The username and password from login can get accessed using getter methods in the "Login" model
		 * e.g. getUsername() method will return the username encapsulated in login object
		 * Return "success" on successful insertion of a new user
		 * Return "failure" for an unsuccessful database operation
		 */
		
		/*Sample data begins*/
		System.out.println("*******Add a User**********");
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
////			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:8081/cse305pa3","root","40302000");
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305pa3?"+"user=root&password=40302000");
//			System.out.println("*************Successful Connection **************");
//			Statement st=con.createStatement();
//			ResultSet rs =st.executeQuery("select * from customer");
//			String queryStatement="select * from customer where customerID LIKE '%"+searchKeyword+"%'";
			String queryStatement="INSERT INTO Login"
					+ "(username, password_, role_)"
					+ " VALUES "
					+ "('"
					+ login.getUsername()+"', '"
					+ login.getPassword()+"', '"
					+ login.getRole()
					+ "');";
			System.out.println(queryStatement);
			Jdbc.deleteStatement(queryStatement);
			return "success";
		}
		catch(Exception e) {
			System.out.println(e);
			return "failure";
		}
		
		/*Sample data ends*/
	}

}
