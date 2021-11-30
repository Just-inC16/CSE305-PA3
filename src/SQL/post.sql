-- create database cse305pa3;
-- use customercse305pa3;
drop table Post;

CREATE TABLE Post (		 
	customerID CHAR(20) NOT NULL UNIQUE, 
    auctionID INTEGER NOT NULL UNIQUE, 
    PRIMARY KEY (customerID, auctionID),
	postDate CHAR(20), 
	expireDate CHAR(20)
);

INSERT INTO Post(customerID, auctionID, postDate, expireDate)
VALUES
# DVD sample auction #1; opening 5.50
('shiyong', 1,'2021-6-1', 10.0),
('haixia', 2,'2021-6-2', 40.0);

select * from Post;
