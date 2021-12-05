-- create database cse305pa3;
-- use cse305pa3;
drop table Employee;

CREATE TABLE Employee (		 
	employeeID CHAR(20) NOT NULL UNIQUE, 
    PRIMARY KEY (employeeID),
	startDate CHAR(20), 
	hourlyRate float4,
	level_ CHAR(20),
	firstName CHAR(20),
	lastName CHAR(20),
	address CHAR(20),
    city CHAR(20),
	state CHAR(2),
	zipCode INTEGER,
	email CHAR(20),
    telephone CHAR(20),
	revenue CHAR(20)
);

INSERT INTO Employee
(employeeID, startDate, hourlyRate, level_, firstName, lastName, address, city, state, zipCode, email, telephone, revenue)
VALUES
('jusch', '3/4/2019', 19.5666,'Garbage','Eghe','Chen','123 College road','Fresh','NY',11356,'bc@g','(888)888-9999','$60000'),
('ben10', '4/5/2020', 20.00000,'God Level','Emma','Chen','123 College road','Meadows','NY',15632,'jc@g','(516)632-9987','$50000');

select * from Employee;
