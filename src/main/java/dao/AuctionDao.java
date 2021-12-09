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
		
		System.out.println("*************** getAllAuctions() ***************");
		List<Auction> auctions = new ArrayList<Auction>();
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Auction" class object and added to the "auctions" ArrayList
		 * Query to get data about all the auctions should be implemented
		 */
		
		/*Sample data begins*/
		/*for (int i = 0; i < 10; i++) {
			Auction auction = new Auction();
			auction.setAuctionID(1 + i);
			auction.setBidIncrement(10+ i);
			auction.setMinimumBid(10+ i);
			auction.setCopiesSold(12+ i);
			auction.setItemID(1234+ i);
			auction.setClosingBid(120+ i);
			auction.setCurrentBid(120+ i);
			auction.setCurrentHighBid(120+ i);
			auction.setReserve(10+ i);
			auctions.add(auction);
		}*/

		// ADDED
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
		/*Sample data ends*/
		
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
		
		/*Sample data begins*/
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
		/*Sample data ends*/
		
		return auctions;

	}

	// C Items sold by Seller -> View Item -> Bid
	public List getAuctionData(String auctionID, String itemID) {

		System.out.println("*************** getAuctionData() ***************");
		List output = new ArrayList();
		Item item = new Item();
		Bid bid = new Bid();
		Auction auction = new Auction();
		Customer customer = new Customer();

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

		/*Sample data begins*/
		for (int i = 0; i < 4; i++) {
			item.setItemID(123);
			item.setDescription("sample description");
			item.setType("BOOK");
			item.setName("Sample Book");

			bid.setCustomerID("123-12-1234");
			bid.setBidPrice(120);

			customer.setCustomerID("123-12-1234");
			customer.setFirstName("Shiyong");
			customer.setLastName("Lu");

			auction.setMinimumBid(100);
			auction.setBidIncrement(10);
			auction.setCurrentBid(110);
			auction.setCurrentHighBid(115);
			auction.setAuctionID(Integer.parseInt(auctionID));
		}
		/*Sample data ends*/

		output.add(item);
		output.add(bid);
		output.add(auction);
		output.add(customer);

		return output;

	}

	// CR
	public List<Auction> getOpenAuctions(String employeeEmail) {
		System.out.println("*************** getOpenAuctions() ***************");
		List<Auction> auctions = new ArrayList<Auction>();
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Auction" class object and added to the "auctions" ArrayList
		 * Query to get data about all the open auctions monitored by a customer representative should be implemented
		 * employeeEmail is the email ID of the customer representative, which is given as method parameter
		 */
		
		/*Sample data begins*/
		for (int i = 0; i < 5; i++) {
			Auction auction = new Auction();
			auction.setAuctionID(1);
			auction.setBidIncrement(10);
			auction.setMinimumBid(10);
			auction.setCopiesSold(12);
			auction.setItemID(1234);
			auction.setClosingBid(120);
			auction.setCurrentBid(120);
			auction.setCurrentHighBid(120);
			auction.setReserve(10);
			auctions.add(auction);
		}
		/*Sample data ends*/
		
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
		/* Sample data begins */
		return "success";
		/* Sample data ends */
	}
}
