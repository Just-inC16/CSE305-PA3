package dao;

import jdbc.Jdbc;
import model.Item;
import model.Post;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostDao {

	// M
	public List<Item> getSalesReport(Post post) {
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Item" class object and added to the "items" List
		 * Query to get sales report for a particular month must be implemented
		 * post, which has details about the month and year for which the sales report is to be generated, is given as method parameter
		 * The month and year are in the format "month-year", e.g. "10-2018" and stored in the expireDate attribute of post object
		 * The month and year can be accessed by getter method, i.e., post.getExpireDate()
		 */

		System.out.println("*************** getSalesReport() ***************");
		String expDate = post.getExpireDate();
		int ind = expDate.indexOf('-');
		String month = expDate.substring(0, ind);
		String year = expDate.substring(ind + 1, ind + 5);
		if (month.length() == 1){
			month = "0" + month;
		}

		// System.out.println("Date: " + expDate);
		// System.out.println("Year: " + year);
		// System.out.println("Month: " + month);

		List<Item> items = new ArrayList<Item>();
				
		/*Sample data begins*/
		/*
		for (int i = 0; i < 10; i++) {
			Item item = new Item();
			item.setName("Sample item");
			item.setSoldPrice(100);
			items.add(item);
		}*/

		try {
			ResultSet rs = Jdbc.newStatement(
	"SELECT BidWon.BidPrice, Item.Name \n" +
				"FROM BidWon, Auction, Item WHERE \n" +
				"BidWon.AuctionID = Auction.AuctionID AND\n" +
				"Auction.ItemID = Item.ItemID AND\n" +
				"BidTime LIKE '%" + year + "-" + month + "%';");

			while(rs.next()) {
				Item item=new Item();
				item.setName(rs.getString("Name"));
				item.setSoldPrice(rs.getInt("BidPrice"));
				items.add(item);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		/*Sample data ends*/
		return items;
		
	}
}
