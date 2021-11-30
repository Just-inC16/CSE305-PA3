create database cse305pa3;
use customercse305pa3;
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

select * from Item;
