package dao;

import java.sql.*;

import jdbc.Jdbc;
import model.Customer;
import model.Login;

public class LoginDao {
	/*
	 * This class handles all the database operations related to login functionality
	 */
	
	private String [] roles= new String[] {"manager","customerRepresentative","customer"};
	//***Is this the class where we put the role?****
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
		System.out.println("*************** Get Login username & manager ***************");
		
		Login login = null;
		try {
			// query login validation
			Statement st = Jdbc.base();
			ResultSet rs = st.executeQuery("select *\r\n"
					+ "from Login\r\n"
					+ "where Login.username = \"" + username + "\" \r\n"
					+ "AND Login.password_ = \"" + password + "\";");
			
			// if query is successful, attempt to return Login object
			while(rs.next()) {
				login = new Login();
				login.setUsername(rs.getString("username"));
				login.setPassword(rs.getString("password_"));
				login.setRole(rs.getString("role_"));		
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		/*Sample data ends*/
		
		return login;	
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
