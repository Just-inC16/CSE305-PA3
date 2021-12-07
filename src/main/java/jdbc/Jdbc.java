package jdbc;

import java.sql.*;

public class Jdbc {
	public static String DB_URL = "jdbc:mysql://localhost:3306/cse305pa3";
	public static String USER = "root";
//	public static String PASS = "365365365jJkK;"; // password here
	public static String PASS="40302000";
	public static Statement base() {
		Statement st = null;
		Connection con;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, USER, PASS);
			st=con.createStatement();
			System.out.println("*************** Successful Connection ***************");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return st;
	}
	
	public static ResultSet newStatement(String queryStatement) {
		Statement baseStatement;
		ResultSet rs = null;
		
		try {
			baseStatement= base();
			rs =baseStatement.executeQuery(queryStatement);
			
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
		Statement baseStatement=null;
//		ResultSet rs = null;
		try {
			baseStatement= base();
			baseStatement.executeUpdate(queryStatement);	
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
//	public static void insertStatement(String queryStatement) {
//		Statement baseStatement=null;
////		ResultSet rs = null;
//		try {
//			baseStatement= base();
//			baseStatement.createStatement(queryStatement);	
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//	}
}
