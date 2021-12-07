create database cse305pa3;
use cse305pa3;
drop table customer;

CREATE TABLE Customer (		 
	customerID CHAR(20) NOT NULL UNIQUE, 
    PRIMARY KEY (customerID),
	firstName CHAR(20), 
	lastName CHAR(20),
	Address CHAR(64),
	City CHAR(20),
	State CHAR(2),
	zipCode INTEGER,
	telephone CHAR(13),
	email CHAR(64),
	creditCard CHAR(20), 
	rating INTEGER
);

INSERT INTO Customer (customerID, firstName, lastName, Address, City, State, zipCode, telephone, email, creditCard, rating)
VALUES
("shiyong", "Lu","Shiyong", "123 Success Street", "Stony Brook", "NY", 11790, "(516)632-8959", "shiyong@cs.sunysb.edu", "1234-5678-1234-5678", 1),
("haixia",  "Du", "Haixia", "456 Fortune Road","Stony Brook","NY",11790,"(516)632-4360","dhaixia@cs.sunysb.edu","5678-1234-5678-1234",1),
("john","Smith","John","789 Peace Blvd.","Los Angeles","CA",12345,"(412)443-321","shlu@ic.sunysb.edu","2345-6789-2345-6789",1 ), 
("phil", "Phil", "Lewis", "135 Knowledge Lane", "Stony Brook", "NY", 11704, "(516)666-8888", "pml@cs.sunysb.edu", "6789-2345-6789-2345", 1);

insert into customer (customerID, firstName, lastName, Address, City, State, zipCode, telephone, email,CreditCardNum, rating)
VALUES
("juschan", "Chan","JusChan", "123 Success Street", "Stony Brook", "NY", 11790, "(516)632-8959", "jc@g", "1234-5678-1234-5678", 18),
("danlee", "Lee","DanielLee", "123 Success Street", "Stony Brook", "NY", 11790, "(516)632-8959", "dl@g", "1234-5678-1234-5678", 21);
Update customer set Email="jl@g" where customerID="000-00-0006";
select * from customer;


