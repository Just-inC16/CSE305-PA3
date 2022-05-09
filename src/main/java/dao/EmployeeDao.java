package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.Jdbc;
import model.Employee;

public class EmployeeDao {
	/*
	 * This class handles all the database operations related to the employee table
	 */

	// M TESTED
	public List<Employee> getEmployees() {

		/*
		 * The students code to fetch data from the database will be written here Query
		 * to return details about all the employees must be implemented Each record is
		 * required to be encapsulated as a "Employee" class object and added to the
		 * "employees" List
		 */

		System.out.println("*************** getEmployees() ***************");
		List<Employee> employees = new ArrayList<Employee>();
		try {
			ResultSet rs = Jdbc.newStatement("select * from employee");
			while (rs.next()) {
				Employee employee = new Employee();

				employee.setEmployeeID(rs.getString("employeeID"));
				employee.setStartDate(rs.getString("startDate"));
				employee.setHourlyRate(rs.getFloat("hourlyRate"));
				employee.setLevel(rs.getString("level_"));
				employee.setFirstName(rs.getString("FirstName"));
				employee.setLastName(rs.getString("LastName"));
				employee.setAddress(rs.getString("Address"));
				employee.setCity(rs.getString("City"));
				employee.setState(rs.getString("State"));
				employee.setZipCode(rs.getInt("ZipCode"));
				employee.setEmail(rs.getString("Email"));
				employee.setTelephone(rs.getString("Telephone"));
				employee.setRevenue(rs.getString("revenue"));

				employees.add(employee);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return employees;
	}

	// M TESTED
	public Employee getEmployee(String employeeID) {

		/*
		 * The students code to fetch data from the database based on "employeeID" will
		 * be written here employeeID, which is the Employee's ID who's details have to
		 * be fetched, is given as method parameter The record is required to be
		 * encapsulated as a "Employee" class object
		 */

		System.out.println("*************** getEmployee() ***************");
		Employee employee = new Employee();
		try {
			String queryStatement = "select * from employee where employeeID='" + employeeID + "'";
			System.out.println(queryStatement);
			ResultSet rs = Jdbc.newStatement(queryStatement);

			while (rs.next()) {
				employee.setEmployeeID(employeeID);
				employee.setStartDate(rs.getString("StartDate"));
				employee.setHourlyRate(rs.getFloat("HourlyRate"));
				employee.setLevel(rs.getString("Level_"));
				employee.setFirstName(rs.getString("FirstName"));
				employee.setLastName(rs.getString("LastName"));
				employee.setAddress(rs.getString("Address"));
				employee.setCity(rs.getString("City"));
				employee.setState(rs.getString("State"));
				employee.setZipCode(rs.getInt("ZipCode"));
				employee.setEmail(rs.getString("Email"));
				employee.setTelephone(rs.getString("Telephone"));
				employee.setRevenue(rs.getString("Revenue"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return employee;
	}

	// M TESTED
	public Employee getHighestRevenueEmployee() {

		/*
		 * The students code to fetch employee data who generated the highest revenue
		 * will be written here The record is required to be encapsulated as a
		 * "Employee" class object
		 */

		System.out.println("*************** getHighestRevenueEmployee() ***************");
		Employee employee = new Employee();
		try {
			ResultSet rs = Jdbc.newStatement("SELECT Employee.*, SUM(BidWon.BidPrice) AS TotalGenerated\n"
					+ "FROM BidWon, Auction, Employee\n" + "WHERE \n" + "\tBidWon.AuctionID = Auction.AuctionID AND\n"
					+ "\tAuction.Monitor = Employee.EmployeeID\n" + "GROUP BY Auction.Monitor\n"
					+ "ORDER BY TotalGenerated DESC\n" + "LIMIT 1;");

			while (rs.next()) {
				employee.setEmail(rs.getString("Email"));
				employee.setFirstName(rs.getString("FirstName"));
				employee.setLastName(rs.getString("LastName"));
				employee.setEmployeeID(rs.getString("EmployeeID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	// TESTED [by login]
	public String getEmployeeID(String username) {
		/*
		 * The students code to fetch data from the database based on "username" will be
		 * written here username, which is the Employee's email address who's Employee
		 * ID has to be fetched, is given as method parameter The Employee ID is
		 * required to be returned as a String
		 */

		System.out.println("*************** getEmployeeID() ***************");
		String foundEmployeeID = null;
		try {
			String queryStatement = "select * from employee where email= \"" + username + "\";";
			ResultSet rs = Jdbc.newStatement(queryStatement);

			while (rs.next()) {
				foundEmployeeID = rs.getString("EmployeeID");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("EmployeeID: " + foundEmployeeID);
		return foundEmployeeID;
	}

	// M TESTED
	public String addEmployee(Employee employee) {

		/*
		 * All the values of the add employee form are encapsulated in the employee
		 * object. These can be accessed by getter methods (see Employee class in model
		 * package). e.g. firstName can be accessed by employee.getFirstName() method.
		 * The sample code returns "success" by default. You need to handle the database
		 * insertion of the employee details and return "success" or "failure" based on
		 * result of the database insertion.
		 */

		System.out.println("*************** addEmployee() ***************");
		try {
			String queryStatement = "INSERT INTO Employee"
					+ "(employeeID, startDate, hourlyRate, level_, firstName, lastName, address, city, state, zipCode, email, telephone, revenue)"
					+ " VALUES " + "('" + employee.getEmployeeID() + "', '" + employee.getStartDate() + "', '"
					+ employee.getHourlyRate() + "', '" + employee.getLevel() + "', '" + employee.getFirstName()
					+ "', '" + employee.getLastName() + "', '" + employee.getAddress() + "', '" + employee.getCity()
					+ "', '" + employee.getState() + "', " + employee.getZipCode() + ", '" + employee.getEmail()
					+ "', '" + employee.getTelephone() + "', '" + employee.getRevenue() + "'" + ");";
			System.out.println(queryStatement);
			Jdbc.modifyStatement(queryStatement);

			return "success";
		} catch (Exception e) {
			System.out.println(e);
			return "failure";
		}

	}

	// M TESTED
	public String editEmployee(Employee employee) {
		/*
		 * All the values of the edit employee form are encapsulated in the employee
		 * object. These can be accessed by getter methods (see Employee class in model
		 * package). e.g. firstName can be accessed by employee.getFirstName() method.
		 * The sample code returns "success" by default. You need to handle the database
		 * update and return "success" or "failure" based on result of the database
		 * update.
		 */

		/* Sample data begins */
		System.out.println("*************** editEmployee() ***************");
		try {
			String queryStatement = "UPDATE Employee set " + "startDate = '" + employee.getStartDate() + "',"
					+ "hourlyRate = '" + employee.getHourlyRate() + "', " + "level_ = '" + employee.getLevel() + "', "
					+ "firstName = '" + employee.getFirstName() + "'," + "lastName = '" + employee.getLastName() + "', "
					+ "address = '" + employee.getAddress() + "', " + "city = '" + employee.getCity() + "', "
					+ "state = '" + employee.getState() + "', " + "zipCode = " + employee.getZipCode() + ", "
					+ "email= '" + employee.getEmail() + "', " + "telephone = '" + employee.getTelephone() + "', "
					+ "revenue = " + employee.getRevenue() + " where employeeID= '" + employee.getEmployeeID() + "'";
			Jdbc.modifyStatement(queryStatement);
			return "success";
		} catch (Exception e) {
			System.out.println(e);
			return "failure";
		}

	}

	// M TESTED
	public String deleteEmployee(String employeeID) {
		/*
		 * employeeID, which is the Employee's ID which has to be deleted, is given as
		 * method parameter The sample code returns "success" by default. You need to
		 * handle the database deletion and return "success" or "failure" based on
		 * result of the database deletion.
		 */
		System.out.println("*************** deleteEmployee() ***************");
		try {
			String queryStatement = "DELETE FROM employee WHERE employeeID='" + employeeID + "'";
			Jdbc.modifyStatement(queryStatement);
			return "success";
		} catch (Exception e) {
			System.out.println(e);
			return "failure";
		}
	}
}
