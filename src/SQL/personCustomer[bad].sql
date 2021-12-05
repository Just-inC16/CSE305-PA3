create database cse305pa3;
use cse305pa3;

CREATE TABLE Person ( 	
	SSN INT NOT NULL,			
	LastName CHAR(20) NOT NULL, 	 
	FirstName CHAR(20) NOT NULL, 	 
	Address CHAR(64),			 
	City CHAR(20),				 
	State CHAR(2),				 
	ZipCode INTEGER, 			 
	Telephone CHAR(13), 		 
	Email CHAR(64), 
    PasswordX  CHAR(64),-- Added bc UI
	PRIMARY KEY (SSN)
);

CREATE TABLE Customer (		-- subclass of person 
	Rating DECIMAL,
	CreditCardNum LONG,
	CustomerID INT NOT NULL,
	PRIMARY KEY (CustomerID),
	FOREIGN KEY (CustomerID) REFERENCES Person(SSN)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

select * from person;
select * from customer;
select * from person, customer;

INSERT INTO Person (SSN, LastName, FirstName, Address,City, State, ZipCode, Telephone, Email, PasswordX)
VALUES 
	(000000001, "Lu", "Shiyong", "123 Success Street", "Stony Broke", "NJ", 11790, "(486)632-8959", "shiyong@cs.sunysb.edu", "123"),
    (000000002, "Du", "Haixia", "456 Fortune Road", "Stony Brook", "NA", 11792, "(516)719-4360", "dhaixia@cs.sunysb.edu", "123a"),
    (000000003, "Smith", "John", "789 Peace Blvd", "Los Angeles", "CA", 12345, "(412)443-5321", "shlu@ic.sunysb.edu","123b"),
    (000000004, "Lewis", "Phil", "135 Knowledge Lane", "Cider Lane", "NY", 11794, "(516)568-1858", "phlew@cs.sunysb.edu", "123c"),
    (000000005, "Rollin", "Sonny", "420 Moon Base", "Wall Street", "NC", 11794, "(410)357-7862", "robkelly@cs.sunysb.edu", "123d"),
    (100000000, "Smith", "David", "123 College road", "Stony Brook", "NY", 11791, "(516)215-2345", "emp1@sunysb.edu", "123e"),
    (200000000, "Warren", "Dave", "456 Sunken Street", "Stony Brook", "NY", 11795, "(516)632-9987", "emp2@sunysb.edu", "123f"),
    (300000000, "Ford", "Tommin", "789 Dumpster Diver", "Binghamton", "NY", 12795, "(516)446-7536", "emp3@sunysb.edu", "123g"); 

INSERT INTO Customer (CustomerID, Rating, CreditCardNum)
VALUES
	(000000001, 1, 1234567812345678),
    (000000002, 1, 5678123456781234),
    (000000003, 1, 2345678923456789),
    (000000004, 1, 6789234567892345),
	(000000005, 1, 4554854155148617);
    
drop table person;
drop table customer;
