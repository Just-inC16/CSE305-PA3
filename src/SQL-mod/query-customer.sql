-- RUN THESE FIRST
-- 3.3 Customer-Level Transactions

-- prints out all the auctions
SELECT * 
FROM Auction
ORDER BY Auction.AuctionID DESC;

-- used for getBidHistory()
-- 13] A bid history for each auction
SELECT 
	Bid.CustomerID,
	Bid.BidTime,
	Bid.BidPrice
FROM Bid,Auction
WHERE
	Bid.AuctionID = Auction.AuctionID AND
	Bid.AuctionID = 1 -- (?) provided
ORDER BY BidTime;

-- 14] A history of all current and past auctions a customer has taken part in
/*SELECT
	Auction.AuctionID, 
	Auction.BidIncrement,
	Bid.BidTime,
	Auction.MinimumBid,
	Auction.Copies_Sold,
	Auction.ItemID 
FROM Bid, Auction
WHERE 
	Bid.AuctionID = Auction.AuctionID AND
	Bid.CustomerID = "000-00-0001" -- (?) provided
ORDER BY Bid.BidTime DESC;*/

-- 14 MOD]
SELECT Bid.*
FROM Bid, Auction
WHERE 
Bid.AuctionID = Auction.AuctionID AND
Bid.CustomerID = "000-00-0001" -- (?) provided
ORDER BY Bid.BidTime DESC;

-- 15] Items sold by a given seller and corresponding auction info
SELECT 
	Auction.AuctionID,
	Item.ItemID,
	Item.Name,
	Auction.BidIncrement,
	Auction.MinimumBid, 
	Auction.Copies_Sold
FROM Item, Auction, Post
WHERE 
	Post.AuctionID = Auction.AuctionID AND 
	Auction.ItemID = Item.ItemID AND
	Post.CustomerID = "000-00-0001"; -- (?) provided

-- 16] Items available of a particular type and corresponding auction info
SELECT 
	Item.ItemID,
	Item.Name,
	Auction.AuctionID,
	Auction.BidIncrement,
	Auction.MinimumBid, 
	Auction.Copies_Sold
FROM Item, Auction
WHERE 
	Item.ItemID = Auction.ItemID AND
	Item.Type = "Electronic" -- (?) provided
    AND Item.NumCopies > 0;

-- Items available with a particular keyword or 
-- set of keywords in the item name, and corresponding auction info

-- 17a] A particular keyword
SELECT Item.Name, Auction.AuctionID,
	Auction.BidIncrement,
	Auction.MinimumBid, 
	Auction.Copies_Sold
FROM Item, Auction 
WHERE 
	Item.ItemID = Auction.ItemID AND
	Item.Name LIKE "%am%" -- (?) provided
    AND Item.NumCopies>0;

-- 17b] A set of keywords
SELECT Item.Name, Auction.AuctionID,
	Auction.BidIncrement,
	Auction.MinimumBid, 
	Auction.Copies_Sold
FROM Item, Auction 
WHERE 
	Item.ItemID = Auction.ItemID AND
	(Item.Name LIKE "T%" -- (?) provided
    OR Item.Name LIKE "%o") -- (?) provided
    AND	Item.NumCopies>0;

-- used for getBestsellerItems()
-- 18] Best-Seller list
/*SELECT Item.Name, Auction.Copies_Sold
FROM Auction, Item
WHERE 
	Auction.ItemID = Item.ItemID AND 
	Auction.Copies_Sold > 0
GROUP BY Auction.ItemID
ORDER BY Auction.Copies_Sold DESC;*/

-- 18 MOD] 
SELECT Item.*, Auction.Copies_Sold
FROM Auction, Item
WHERE 
	Auction.ItemID = Item.ItemID AND 
	Auction.Copies_Sold > 0
GROUP BY Auction.ItemID
ORDER BY Auction.Copies_Sold DESC;

-- 19] Personalized item suggestion list
-- VIEW #2 [also exists in query-customer-representative]
/*CREATE VIEW ItemTypeCustomerBought AS
SELECT BidWon.CustomerID, Item.Type
FROM BidWon, Auction, Item
WHERE 
	BidWon.AuctionID = Auction.AuctionID AND
	Auction.ItemID = Item.ItemID
GROUP BY Item.Type;

CREATE VIEW BestSellerItemByItemType AS
SELECT Item.Type, Item.Name, MAX(Auction.Copies_Sold)
FROM Auction, Item
WHERE Auction.ItemID = Item.ItemID
GROUP BY Item.Type;

SELECT BestSellerItemByItemType.Name
FROM ItemTypeCustomerBought, BestSellerItemByItemType
WHERE
	CustomerID = "000-00-0004" AND -- (?) provided
	ItemTypeCustomerBought.Type = BestSellerItemByItemType.Type;*/

SELECT Item.Type
FROM Item
GROUP BY Item.Type;