-- create database cse305pa3;
-- use cse305pa3;
drop table Auction;

CREATE TABLE Auction (		 
	auctionID INTEGER NOT NULL UNIQUE, 
    itemID INTEGER,
	employeeID CHAR(20),
	bidIncrement float4, 
	minimumBid float4,
	copiesSold INTEGER,
	monitor INTEGER,
	closingBid INTEGER,
    currentBid INTEGER,
	currentHighBid INTEGER,
	reserve INTEGER,
   
	PRIMARY KEY (auctionID),
    FOREIGN KEY(itemID) REFERENCES Item(itemID)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
    FOREIGN KEY(employeeID) REFERENCES Employee(employeeID)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

INSERT INTO Auction(auctionID, itemID,employeeID,bidIncrement, minimumBid, copiesSold, monitor,  closingBid,currentBid,currentHighBid,reserve)
VALUES
	(1, 123, "jusch",2.0, 5.50, 15, 50, 200000000,30,25,26),
    (2,456,"ben10", 1.0, 14620.00, 20000, 100, 200000000,31,25,26);
-- (3, 1,"junholee",1.0, 900.00, 1500, 25, 300000000, 32,25,26);
--     (4, 2,1,1.0, 1800.00, 3000, 25, 300000000,33,25,26,24),
-- 	(5, 1,1,1.0, 1400.00, 2000, 25, 300000000,34,25,26,24),
--     (6, 2,1,2.0, 5.50, 15, 50, 200000000,35,25,26,24);
    
select * from Auction;
