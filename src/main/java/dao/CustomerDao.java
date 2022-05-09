package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.Jdbc;
import model.Customer;

/*
	 * This class handles all the database operations related to the customer table
	 */
public class CustomerDao {
	// CR TEST THIS
	public List<Customer> getCustomers(String searchKeyword) {
		/*
		 * This method fetches one or more customers based on the searchKeyword and
		 * returns it as an ArrayList
		 */

		/*
		 * The students code to fetch data from the database based on searchKeyword will
		 * be written here Each record is required to be encapsulated as a "Customer"
		 * class object and added to the "customers" List
		 */
		System.out.println("*************** getCustomers() ***************");
		List<Customer> customers = new ArrayList<Customer>();
		try {
			if (searchKeyword == null) {
				searchKeyword = "";
			}
			String queryStatement = "select * from customer where customerID LIKE '%" + searchKeyword + "%'";
			ResultSet rs = Jdbc.newStatement(queryStatement);

			while (rs.next()) {
				Customer customer = new Customer();

				customer.setCustomerID(rs.getString("CustomerId"));
				customer.setEmail(rs.getString("Email"));
				customer.setFirstName(rs.getString("FirstName"));
				customer.setLastName(rs.getString("LastName"));
				customer.setAddress(rs.getString("Address"));
				customer.setCity(rs.getString("City"));
				customer.setState(rs.getString("State"));
				customer.setZipCode(rs.getInt("ZipCode"));
				customer.setTelephone(rs.getString("Telephone"));
				customer.setCreditCard(rs.getString("CreditCardNum"));
				customer.setRating(rs.getInt("Rating"));

				customers.add(customer);
			}
			System.out.println(customers.size() + ": " + queryStatement);
		} catch (Exception e) {
			System.out.println(e);
		}
		return customers;
	}

	// TESTED
	// Note: This is the business logic for that customer
	public Customer getCustomer(String customerID) {

		/*
		 * This method fetches the customer details and returns it customerID, which is
		 * the Customer's ID who's details have to be fetched, is given as method
		 * parameter The students code to fetch data from the database will be written
		 * here The customer record is required to be encapsulated as a "Customer" class
		 * object
		 */

		System.out.println("*************** getCustomer() ***************");
		Customer customer = new Customer();

		try {
			String queryStatement = "select * from customer where customerID='" + customerID + "'";
			System.out.println(queryStatement);
			ResultSet rs = Jdbc.newStatement(queryStatement);

			while (rs.next()) {
				customer.setCustomerID(rs.getString("CustomerId"));
				customer.setFirstName(rs.getString("FirstName"));
				customer.setLastName(rs.getString("LastName"));
				customer.setAddress(rs.getString("Address"));
				customer.setCity(rs.getString("City"));
				customer.setState(rs.getString("State"));
				customer.setZipCode(rs.getInt("ZipCode"));
				customer.setEmail(rs.getString("Email"));
				customer.setTelephone(rs.getString("Telephone"));
				customer.setCreditCard(rs.getString("CreditCardNum"));
				customer.setRating(rs.getInt("Rating"));
				System.out.println("ID: " + customer.getCustomerID());
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return customer;
	}

	// CR TESTED
	public List<Customer> getCustomerMailingList() {

		/*
		 * This method fetches the all customer mailing details and returns it The
		 * students code to fetch data from the database will be written here Each
		 * customer record is required to be encapsulated as a "Customer" class object
		 * and added to the "customers" List
		 */

		System.out.println("*************** getCustomerMailingList() ***************");
		List<Customer> customers = new ArrayList<Customer>();
		// ADDED 11] (Not really. Simplified the query)
		System.out.println("*******Get all customers' mailing information**********");
		try {
			ResultSet rs = Jdbc.newStatement("select * from customer;");

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerID(rs.getString("CustomerId"));
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setAddress(rs.getString("Address"));
				customer.setCity(rs.getString("City"));
				customer.setState(rs.getString("State"));
				customer.setZipCode(rs.getInt("ZipCode"));
				customer.setEmail(rs.getString("Email"));
				customers.add(customer);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return customers;
	}

	// M TESTED
	public Customer getHighestRevenueCustomer() {
		/*
		 * This method fetches the customer who generated the highest total revenue and
		 * returns it The students code to fetch data from the database will be written
		 * here The customer record is required to be encapsulated as a "Customer" class
		 * object
		 */

		System.out.println("*************** getHighestRevenueCustomer() ***************");
		Customer customer = new Customer();

		// ADDED 7]
		try {
			ResultSet rs = Jdbc.newStatement("SELECT Customer.*, SUM(BidWon.BidPrice) AS TotalSpent\n"
					+ "FROM BidWon, Customer\n" + "GROUP BY CustomerID\n" + "ORDER BY TotalSpent DESC\n" + "LIMIT 1;");

			while (rs.next()) {
				customer.setCustomerID(rs.getString("CustomerID"));
				customer.setLastName(rs.getString("LastName"));
				customer.setEmail(rs.getString("Email"));
				customer.setFirstName(rs.getString("FirstName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}

	// C TESTED
	public List<Customer> getSellers() {

		/*
		 * This method fetches the all seller details and returns it The students code
		 * to fetch data from the database will be written here The seller (which is a
		 * customer) record is required to be encapsulated as a "Customer" class object
		 * and added to the "customers" List
		 */

		System.out.println("*************** getSellers() ***************");
		List<Customer> customers = new ArrayList<Customer>();
		try {
			ResultSet rs = Jdbc.newStatement(
					"SELECT Distinct C.*\n" + "FROM Customer as C, Post as P\n" + "WHERE C.CustomerID = P.CustomerID;");

			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerID(rs.getString("CustomerId"));
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setAddress(rs.getString("Address"));
				customer.setCity(rs.getString("City"));
				customer.setState(rs.getString("State"));
				customer.setZipCode(rs.getInt("ZipCode"));
				customer.setEmail(rs.getString("Email"));
				customers.add(customer);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return customers;

	}

	// TESTED [by login]
	public String getCustomerID(String username) {
		/*
		 * This method returns the Customer's ID based on the provided email address The
		 * students code to fetch data from the database will be written here username,
		 * which is the email address of the customer, who's ID has to be returned, is
		 * given as method parameter The Customer's ID is required to be returned as a
		 * String
		 */
		System.out.println("*************** getCustomerID() ***************");
		String foundCustomerID = null;
		try {
			String queryStatement = "select customerID from customer where email=\"" + username + "\";";
			ResultSet rs = Jdbc.newStatement(queryStatement);

			while (rs.next()) {
				foundCustomerID = rs.getString("CustomerID");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("CustomerID: " + foundCustomerID);
		return foundCustomerID;
	}

	// CR TESTED
	public String addCustomer(Customer customer) {

		/*
		 * All the values of the add customer form are encapsulated in the customer
		 * object. These can be accessed by getter methods (see Customer class in model
		 * package). e.g. firstName can be accessed by customer.getFirstName() method.
		 * The sample code returns "success" by default. You need to handle the database
		 * insertion of the customer details and return "success" or "failure" based on
		 * result of the database insertion.
		 */

		/* Sample data begins */
		System.out.println("*************** addCustomer() ***************");
		try {
			String queryStatement = "INSERT INTO Customer"
					+ "(customerID, firstName, lastName, Address, City, State, zipCode, telephone, email, creditCardNum, rating)"
					+ " VALUES " + "('" + customer.getCustomerID() + "', '" + customer.getFirstName() + "', '"
					+ customer.getLastName() + "', '" + customer.getAddress() + "', '" + customer.getCity() + "', '"
					+ customer.getState() + "', " + customer.getZipCode() + ", '" + customer.getTelephone() + "', '"
					+ customer.getEmail() + "', '" + customer.getCreditCard() + "', " + customer.getRating() + ");";
			System.out.println(queryStatement);
			Jdbc.modifyStatement(queryStatement);
			return "success";
		} catch (Exception e) {
			System.out.println(e);
			return "failure";
		}
	}

	// CR TESTED
	public String editCustomer(Customer customer) {
		/*
		 * All the values of the edit customer form are encapsulated in the customer
		 * object. These can be accessed by getter methods (see Customer class in model
		 * package). e.g. firstName can be accessed by customer.getFirstName() method.
		 * The sample code returns "success" by default. You need to handle the database
		 * update and return "success" or "failure" based on result of the database
		 * update.
		 */
		System.out.println("*************** editCustomer() ***************");
		try {
			String queryStatement = "UPDATE Customer set " + "firstName = '" + customer.getFirstName() + "',"
					+ "lastName = '" + customer.getLastName() + "', " + "Address = '" + customer.getAddress() + "', "
					+ "City = '" + customer.getCity() + "', " + "State = '" + customer.getState() + "', " + "zipCode = "
					+ customer.getZipCode() + ", " + "telephone= '" + customer.getTelephone() + "', " + "email = '"
					+ customer.getEmail() + "', " + "creditCardNum = '" + customer.getCreditCard() + "', " + "rating = "
					+ customer.getRating() + " where customerID= '" + customer.getCustomerID() + "'";
			System.out.println(queryStatement);
			Jdbc.modifyStatement(queryStatement);
			return "success";
		} catch (Exception e) {
			System.out.println(e);
			return "failure";
		}
	}

	// CR TESTED
	public String deleteCustomer(String customerID) {

		/*
		 * This method deletes a customer returns "success" string on success, else
		 * returns "failure" The students code to delete the data from the database will
		 * be written here customerID, which is the Customer's ID who's details have to
		 * be deleted, is given as method parameter
		 */
		System.out.println("*************** deleteCustomer() ***************");
		try {
			String queryStatement = "DELETE FROM customer WHERE customerID='" + customerID + "'";
			Jdbc.modifyStatement(queryStatement);
			return "success";
		} catch (Exception e) {
			System.out.println(e);
			return "failure";
		}
	}

}
