-- create database cse305pa3;
-- use cse305pa3;
drop table Item;

CREATE TABLE Item (		 
	itemID INTEGER NOT NULL UNIQUE, 
    PRIMARY KEY (itemID),
	description_ CHAR(20), 
	type_ CHAR(20),
	name_ CHAR(20),
	numCopies INTEGER,
	yearManufactured INTEGER,
	soldPrice INTEGER
);

INSERT INTO Item(itemID, description_, type_, name_, numCopies, yearManufactured, soldPrice) 
VALUES
(123,"Titanic", "This is a test", "DVD",156, 2005, 5), 
(456,"Nissan Sentra", "This is 2nd test", "Car",259, 2021, 7);

SELECT Item.Name,  Item.Type, Item.Description, SUM(BidWon.BidPrice) AS TotalGenerated FROM BidWon, Auction, Item 
	WHERE BidWon.AuctionID = Auction.AuctionID AND Auction.ItemID = Item.ItemID AND
		name LIKE '%t%' GROUP BY Item.Name;
SELECT * from auction, item where Item.Type='Titanic';
SELECT * FROM Auction, Item WHERE Item.Type='Electronic';
SELECT * FROM Auction, Item WHERE Item.Type='DVD';
select * from Item;
