package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.Jdbc;
import model.Auction;
import model.Bid;
import model.Employee;
import model.Item;

public class ItemDao {

	
	public List<Item> getItems() {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to fetch details of all the items has to be implemented
		 * Each record is required to be encapsulated as a "Item" class object and added to the "items" List
		 */

		List<Item> items = new ArrayList<Item>();
				
		/*Sample data begins*/
		System.out.println("*******Get all Items**********");
		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
////			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:8081/cse305pa3","root","40302000");
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cse305pa3?"+"user=root&password=40302000");
//			System.out.println("*************Successful Connection **************");
//			Statement st=con.createStatement();
//			ResultSet rs =st.executeQuery("select * from customer");
//			String queryStatement="select * from customer where customerID LIKE '%"+searchKeyword+"%'";
			String queryStatement ="select * from item";
			ResultSet rs = Jdbc.newStatement(queryStatement);
			/*Sample data ends*/
			while(rs.next()) {
				Item item=new Item();
				item.setItemID(rs.getInt("itemID"));
				item.setDescription(rs.getString("description_"));
				item.setType(rs.getString("type_"));
				item.setName(rs.getString("name_"));
				item.setNumCopies(rs.getInt("numCopies"));
				item.setYearManufactured(rs.getInt("yearManufactured"));
				item.setSoldPrice(rs.getInt(rs.getInt("soldPrice")));
				items.add(item);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		/*Sample data ends*/
		
		return items;

	}
	
	public List<Item> getBestsellerItems() {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to fetch details of the bestseller items has to be implemented
		 * Each record is required to be encapsulated as a "Item" class object and added to the "items" List
		 */

		List<Item> items = new ArrayList<Item>();
		
		
		/*Sample data begins*/
		for (int i = 0; i < 5; i++) {
			Item item = new Item();
			item.setItemID(123);
			item.setDescription("sample description");
			item.setType("BOOK");
			item.setName("Sample Book");
			item.setNumCopies(2);
			items.add(item);
		}
		/*Sample data ends*/
		
		return items;

	}

	public List<Item> getSummaryListing(String searchKeyword) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to fetch details of summary listing of revenue generated by a particular item or item type must be implemented
		 * Each record is required to be encapsulated as a "Item" class object and added to the "items" ArrayList
		 * Store the revenue generated by an item in the soldPrice attribute, using setSoldPrice method of each "item" object
		 */

		List<Item> items = new ArrayList<Item>();
				
		/*Sample data begins*/
		for (int i = 0; i < 6; i++) {
			Item item = new Item();
			item.setItemID(123);
			item.setDescription("sample description");
			item.setType("BOOK");
			item.setName("Sample Book");
			item.setSoldPrice(150);
			items.add(item);
		}
		/*Sample data ends*/
		
		return items;

	}

	public List<Item> getItemSuggestions(String customerID) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to fetch item suggestions for a customer, indicated by customerID, must be implemented
		 * customerID, which is the Customer's ID for whom the item suggestions are fetched, is given as method parameter
		 * Each record is required to be encapsulated as a "Item" class object and added to the "items" ArrayList
		 */

		List<Item> items = new ArrayList<Item>();
		
		/*Sample data begins*/
		for (int i = 0; i < 4; i++) {
			Item item = new Item();
			item.setItemID(123);
			item.setDescription("sample description");
			item.setType("BOOK");
			item.setName("Sample Book");
			item.setNumCopies(2);
			items.add(item);
		}
		/*Sample data ends*/
		
		return items;

	}

	public List getItemsBySeller(String sellerID) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Query to fetch items sold by a given seller, indicated by sellerID, must be implemented
		 * sellerID, which is the Sellers's ID who's items are fetched, is given as method parameter
		 * The bid and auction details of each of the items should also be fetched
		 * The bid details must have the highest current bid for the item
		 * The auction details must have the details about the auction in which the item is sold
		 * Each item record is required to be encapsulated as a "Item" class object and added to the "items" List
		 * Each bid record is required to be encapsulated as a "Bid" class object and added to the "bids" List
		 * Each auction record is required to be encapsulated as a "Auction" class object and added to the "auctions" List
		 * The items, bids and auctions Lists have to be added to the "output" List and returned
		 */

		List output = new ArrayList();
		List<Item> items = new ArrayList<Item>();
		List<Bid> bids = new ArrayList<Bid>();
		List<Auction> auctions = new ArrayList<Auction>();
		
		/*Sample data begins*/
		for (int i = 0; i < 4; i++) {
			Item item = new Item();
			item.setItemID(123);
			item.setDescription("sample description");
			item.setType("BOOK");
			item.setName("Sample Book");
			items.add(item);
			
			Bid bid = new Bid();
			bid.setCustomerID("123-12-1234");
			bid.setBidPrice(120);
			bids.add(bid);
			
			Auction auction = new Auction();
			auction.setMinimumBid(100);
			auction.setBidIncrement(10);
			auction.setAuctionID(123);
			auctions.add(auction);
		}
		/*Sample data ends*/
		
		output.add(items);
		output.add(bids);
		output.add(auctions);
		
		return output;
	}

	public List<Item> getItemTypes() {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Item" class object and added to the "items" ArrayList
		 * A query to fetch the unique item types has to be implemented
		 * Each item type is to be added to the "item" object using setType method
		 */
		
		List<Item> items = new ArrayList<Item>();
		
		/*Sample data begins*/
		for (int i = 0; i < 6; i++) {
			Item item = new Item();
			item.setType("BOOK");
			items.add(item);
		}
		/*Sample data ends*/
		
		return items;
	}

	public List getItemsByName(String itemName) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * The itemName, which is the item's name on which the query has to be implemented, is given as method parameter
		 * Query to fetch items containing itemName in their name has to be implemented
		 * Each item's corresponding auction data also has to be fetched
		 * Each item record is required to be encapsulated as a "Item" class object and added to the "items" List
		 * Each auction record is required to be encapsulated as a "Auction" class object and added to the "auctions" List
		 * The items and auctions Lists are to be added to the "output" List and returned
		 */

		List output = new ArrayList();
		List<Item> items = new ArrayList<Item>();
		List<Auction> auctions = new ArrayList<Auction>();
		
		/*Sample data begins*/
		for (int i = 0; i < 4; i++) {
			Item item = new Item();
			item.setItemID(123);
			item.setDescription("sample description");
			item.setType("BOOK");
			item.setName("Sample Book");
			items.add(item);
			
			Auction auction = new Auction();
			auction.setMinimumBid(100);
			auction.setBidIncrement(10);
			auctions.add(auction);
		}
		/*Sample data ends*/
		
		output.add(items);
		output.add(auctions);
		
		return output;
	}

	public List getItemsByType(String itemType) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * The itemType, which is the item's type on which the query has to be implemented, is given as method parameter
		 * Query to fetch items containing itemType as their type has to be implemented
		 * Each item's corresponding auction data also has to be fetched
		 * Each item record is required to be encapsulated as a "Item" class object and added to the "items" List
		 * Each auction record is required to be encapsulated as a "Auction" class object and added to the "auctions" List
		 * The items and auctions Lists are to be added to the "output" List and returned
		 */

		List output = new ArrayList();
		List<Item> items = new ArrayList<Item>();
		List<Auction> auctions = new ArrayList<Auction>();
				
		/*Sample data begins*/
		for (int i = 0; i < 4; i++) {
			Item item = new Item();
			item.setItemID(123);
			item.setDescription("sample description");
			item.setType("BOOK");
			item.setName("Sample Book");
			items.add(item);
			
			Auction auction = new Auction();
			auction.setMinimumBid(100);
			auction.setBidIncrement(10);
			auctions.add(auction);
		}
		/*Sample data ends*/
		
		output.add(items);
		output.add(auctions);
		
		return output;
	}

	public List<Item> getBestsellersForCustomer(String customerID) {

		/*
		 * The students code to fetch data from the database will be written here.
		 * Each record is required to be encapsulated as a "Item" class object and added to the "items" ArrayList.
		 * Query to get the Best-seller list of items for a particular customer, indicated by the customerID, has to be implemented
		 * The customerID, which is the customer's ID for whom the Best-seller items have to be fetched, is given as method parameter
		 */

		List<Item> items = new ArrayList<Item>();
				
		/*Sample data begins*/
		for (int i = 0; i < 6; i++) {
			Item item = new Item();
			item.setItemID(123);
			item.setDescription("sample description");
			item.setType("BOOK");
			item.setName("Sample Book");
			item.setNumCopies(50);
			items.add(item);
		}
		/*Sample data ends*/
		
		return items;

	}

}
