-- RUN THESE THIRD
-- 3.2 Customer-Representative-Level Transactions

-- used for getCustomerMailingList() [not really]
-- 11] Produce customer mailing lists
SELECT Customer.Email 
FROM Customer;

-- VIEW #2 [also exists in query-customer]
CREATE VIEW ItemTypeCustomerBought AS
SELECT BidWon.CustomerID, Item.Type
FROM BidWon, Auction, Item
WHERE 
	BidWon.AuctionID = Auction.AuctionID AND
	Auction.ItemID = Item.ItemID;

-- VIEW #3
/* CREATE VIEW BestSellerItemByItemType AS
SELECT Item.Type, Item.Name, MAX(Auction.Copies_Sold)
FROM Auction, Item
WHERE Auction.ItemID = Item.ItemID
GROUP BY Item.Type; */

CREATE VIEW BestSellerItemByItemType AS
SELECT Item.*, MAX(Auction.Copies_Sold)
FROM Auction, Item
WHERE Auction.ItemID = Item.ItemID
GROUP BY Item.Type;

-- used for getItemSuggestions()
-- 12] Produce a list of item suggestions for a given customer (based on that customer's past purchases)
/*SELECT BestSellerItemByItemType.Name
FROM ItemTypeCustomerBought, BestSellerItemByItemType
WHERE
	CustomerID = "000-00-0005" AND -- (?) provided
	ItemTypeCustomerBought.Type = BestSellerItemByItemType.Type;*/
    
SELECT B.*
FROM ItemTypeCustomerBought as I, BestSellerItemByItemType as B
WHERE I.Type = B.Type AND CustomerID = "000-00-0005"; -- (?) provided

SELECT * from BestSellerItemByItemType;
select * from item; 