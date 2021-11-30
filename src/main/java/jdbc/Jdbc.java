package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbc {
	public static Statement base() {
		
	}
	public static ResultSet newStatement(String queryStatement) {
		Connection con =null;		
		Statement st=null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305pa3?user=root&password=40302000");
			st=con.createStatement();
			rs =st.executeQuery(queryStatement);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
//		finally {
//			try { rs.close(); } catch (Exception e) { /* Ignored */ }
//		    try { st.close(); } catch (Exception e) { /* Ignored */ }
//		    try { con.close(); } catch (Exception e) { /* Ignored */ }
//		}
		return rs;
	}
	public static void deleteStatement(String queryStatement) {
		Connection con =null;		
		Statement st=null;
//		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305pa3?user=root&password=40302000");
			st=con.createStatement();
			st.executeUpdate(queryStatement);	
		}
		catch(Exception e) {
			System.out.println(e);
		}
//		finally {
//			try { rs.close(); } catch (Exception e) { /* Ignored */ }
//		    try { st.close(); } catch (Exception e) { /* Ignored */ }
//		    try { con.close(); } catch (Exception e) { /* Ignored */ }
//		}
//		return rs;
		
	}
}
