package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.Jdbc;
import model.Auction;
import model.Bid;
import model.Customer;
import model.Item;

public class AuctionDao {

	// C ADDED]
	public List<Auction> getAllAuctions() {
		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Auction" class object and added to the "auctions" ArrayList
		 * Query to get data about all the auctions should be implemented
		 */
		System.out.println("*************** getAllAuctions() ***************");
		List<Auction> auctions = new ArrayList<Auction>();
		try {
			ResultSet rs = Jdbc.newStatement(
	"SELECT * \n" +
				"FROM Auction\n" +
				"ORDER BY Auction.AuctionID DESC;");

			while(rs.next()) {
				Auction auction = new Auction();
				auction.setAuctionID(rs.getInt("AuctionID"));
				auction.setBidIncrement(rs.getFloat("BidIncrement"));
				auction.setMinimumBid(rs.getFloat("MinimumBid"));
				auction.setCopiesSold(rs.getInt("Copies_Sold"));
				auction.setItemID(rs.getInt("ItemID"));
				auction.setClosingBid(rs.getInt("ClosingBid"));
				auction.setCurrentBid(rs.getInt("CurrentBid"));
				auction.setCurrentHighBid(rs.getInt("CurrentHighBid"));
				auction.setReserve(rs.getInt("ReservePrice"));
				auctions.add(auction);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return auctions;

	}

	// NOT CALLED [probably by C]
	public List<Auction> getAuctions(String customerID) {
		
		System.out.println("*************** getAuctions() ***************");
		List<Auction> auctions = new ArrayList<Auction>();
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Auction" class object and added to the "auctions" ArrayList
		 * Query to get data about all the auctions in which a customer participated should be implemented
		 * customerID is the customer's primary key, given as method parameter
		 */
		
		try {
			ResultSet rs = Jdbc.newStatement(
				"SELECT * \n" +
				"FROM Auction\n" +
				"WHERE Auction.customerID;");

			while(rs.next()) {
				Auction auction = new Auction();
				
				auction.setAuctionID(rs.getInt("AuctionID"));
				auction.setBidIncrement(rs.getFloat("BidIncrement"));
				auction.setMinimumBid(rs.getFloat("MinimumBid"));
				auction.setCopiesSold(rs.getInt("Copies_Sold"));
				auction.setItemID(rs.getInt("ItemID"));
				auction.setClosingBid(rs.getInt("ClosingBid"));
				auction.setCurrentBid(rs.getInt("CurrentBid"));
				auction.setCurrentHighBid(rs.getInt("CurrentHighBid"));
				auction.setReserve(rs.getInt("ReservePrice"));
				
				auctions.add(auction);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return auctions;

	}

	// C Items sold by Seller -> View Item -> Bid
	public List getAuctionData(String auctionID, String itemID) {

		

		/*
		 * The students code to fetch data from the database will be written here
		 * The item details are required to be encapsulated as a "Item" class object
		 * The bid details are required to be encapsulated as a "Bid" class object
		 * The auction details are required to be encapsulated as a "Auction" class object
		 * The customer details are required to be encapsulated as a "Customer" class object
		 * Query to get data about auction indicated by auctionID and itemID should be implemented
		 * auctionID is the Auction's ID, given as method parameter
		 * itemID is the Item's ID, given as method parameter
		 * The customer details must include details about the current winner of the auction
		 * The bid details must include details about the current highest bid
		 * The item details must include details about the item, indicated by itemID
		 * The auction details must include details about the item, indicated by auctionID
		 * All the objects must be added in the "output" list and returned
		 */
		System.out.println("*************** getAuctionData() ***************");
		List output = new ArrayList();
		Item item = new Item();
		Bid bid = new Bid();
		Auction auction = new Auction();
		Customer customer = new Customer();
		System.out.println("Item ID: " + itemID + " Auction ID: " + auctionID);

		try {
			//Fetch Auction information based on AuctionId
			ResultSet rs = Jdbc.newStatement(
					"SELECT * FROM Auction "+
					"WHERE Auction.AuctionID = "+ Integer.parseInt(auctionID) + ";");

			while (rs.next()){
				System.out.println(rs.getFetchSize());
				auction.setMinimumBid(rs.getInt("MinimumBid"));
				auction.setBidIncrement(rs.getFloat("BidIncrement"));
				auction.setCurrentBid(rs.getInt("CurrentBid"));
				auction.setCurrentHighBid(rs.getInt("CurrentHighBid"));
				auction.setAuctionID(rs.getInt("AuctionID"));
			}

			//Fetch ItemID information based on ItemId
			rs = Jdbc.newStatement(
					"SELECT *  FROM Item WHERE Item.ItemID;");
			while (rs.next()) {
				item.setItemID(rs.getInt("ItemID"));
				item.setDescription(rs.getString("Description"));
				item.setType(rs.getString("Type"));
				item.setName(rs.getString("Name"));
			}

			//Fetch Bid details
			rs = Jdbc.newStatement(
					"SELECT * FROM Bid;");
			while (rs.next()) {
				bid.setCustomerID(rs.getString("CustomerID"));
				bid.setBidPrice(rs.getFloat("BidPrice"));
			}

			//Fetch Customer information
			rs = Jdbc.newStatement(
					"SELECT * FROM Customer;");
			while (rs.next()) {
				customer.setCustomerID(rs.getString("CustomerID"));
				customer.setFirstName(rs.getString("FirstName"));
				customer.setLastName(rs.getString("LastName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		output.add(item);
		output.add(bid);
		output.add(auction);
		output.add(customer);

		return output;

	}

	// CR
	public List<Auction> getOpenAuctions(String employeeEmail) {
		System.out.println("*************** getOpenAuctions() ***************");
		System.out.println("Email: " + employeeEmail);
		List<Auction> auctions = new ArrayList<Auction>();
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Auction" class object and added to the "auctions" ArrayList
		 * Query to get data about all the open auctions monitored by a customer representative should be implemented
		 * employeeEmail is the email ID of the customer representative, which is given as method parameter
		 */
		
		try {
			ResultSet rs = Jdbc.newStatement(
					"SELECT *\n" +
							"FROM Auction as A, Employee as E\n" +
							"WHERE A.EmployeeID = E.EmployeeID AND\n" +
							"\tE.Email = \""+ employeeEmail +"\";");

			while(rs.next()) {
				Auction auction = new Auction();
				auction.setAuctionID(rs.getInt("AuctionID"));
				auction.setBidIncrement(rs.getFloat("BidIncrement"));
				auction.setMinimumBid(rs.getFloat("MinimumBid"));
				auction.setCopiesSold(rs.getInt("Copies_Sold"));
				auction.setItemID(rs.getInt("ItemID"));
				auction.setClosingBid(rs.getInt("ClosingBid"));
				auction.setCurrentBid(rs.getInt("CurrentBid"));
				auction.setCurrentHighBid(rs.getInt("CurrentHighBid"));
				auction.setReserve(rs.getInt("ReservePrice"));
				auctions.add(auction);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return auctions;
	}

	// CR Record a Sale -> Record the Sale
	public String recordSale(String auctionID) {
		/*
		 * The students code to update data in the database will be written here
		 * Query to record a sale, indicated by the auction ID, should be implemented
		 * auctionID is the Auction's ID, given as method parameter
		 * The method should return a "success" string if the update is successful, else return "failure"
		 */
		
		System.out.println("*************** recordSale() ***************");
		return "success";
	}
}
