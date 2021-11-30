-- create database cse305pa3;
-- use customercse305pa3;
drop table Bid;

CREATE TABLE Bid (		 
	customerID CHAR(20) NOT NULL UNIQUE, 
    auctionID INTEGER NOT NULL UNIQUE, 
    PRIMARY KEY (customerID, auctionID),
	bidTime CHAR(20), 
	bidPrice float4,
	maxBid float4
);

INSERT INTO Bid(customerID, auctionID, bidTime, bidPrice, maxBid)
VALUES
# DVD sample auction #1; opening 5.50
('shiyong', 1,'2021-6-1', 10.0,20.0),
('haixia', 2,'2021-6-2', 40.0,55.9);

select * from Bid;
