-- 10] Add customer info
/* Customer data
	Rating DECIMAL,
    CreditCardNum LONG,
	CustomerID INT NOT NULL*/
INSERT INTO Customer (CustomerID, LastName, FirstName, Address, City, State, ZipCode, Telephone, Email, Rating, CreditCardNum)
VALUES
	("000-00-0001", "Lu", "Shiyong", "123 Success Street", "Stony Broke", "NJ", 11790, "(486)632-8959", "shiyong@cs.sunysb.edu", 1, 5678123456781234),
    ("000-00-0002", "Du", "Haixia", "456 Fortune Road", "Stony Brook", "NA", 11792, "(516)719-4360", "dhaixia@cs.sunysb.edu", 1, 5678123456781234),
    ("000-00-0003", "Smith", "John", "789 Peace Blvd", "Los Angeles", "CA", 12345, "(412)443-5321", "shlu@ic.sunysb.edu", 1, 2345678923456789),
    ("000-00-0004", "Lewis", "Phil", "135 Knowledge Lane", "Cider Lane", "NY", 11794, "(516)568-1858", "phlew@cs.sunysb.edu", 1, 6789234567892345),
    ("000-00-0005", "Rollin", "Sonny", "420 Moon Base", "Wall Street", "NC", 11794, "(410)357-7862", "robkelly@cs.sunysb.edu", 1, 4554854155148617),
    ("000-00-0006", "Lee", "Jun Ho", "Roth, Gershwin", "Stony Brook", "NY", 12795, "(777)777-7777", "jl@gmail.com", 1, 9874620458962049);

-- 1] Add employee info
/* Employee data
	StartDate DATE,		-- 'yyyy-mm-dd'
	HourlyRate DECIMAL(18, 2),	
    Level INT,
    EmployeeID INT NOT NULL*/
INSERT INTO Employee(EmployeeID, LastName, FirstName, Address, City, State, ZipCode, Telephone, Email, StartDate, HourlyRate, Level_, Revenue)
VALUES 
	("100-00-0000", "Smith", "David", "123 College road", "Stony Brook", "NY", 11791, "(516)215-2345", "emp1@sunysb.edu", '1998-02-04', 59.99, "2", "$75000"),
    ("200-00-0000", "Warren", "Dave", "456 Sunken Street", "Stony Brook", "NY", 11795, "(516)632-9987", "emp2@sunysb.edu", '2008-07-04', 49.95, "1", "$65000"),
    ("300-00-0000", "Ford", "Tommin", "789 Dumpster Diver", "Binghamton", "NY", 12795, "(516)446-7536", "emp3@sunysb.edu", '2018-10-04', 38.95, "1", "$60000"),
	("400-00-0000", "Chan", "Justin", "Chavez", "Stony Brook", "NY", 11791, "(444)444-4444", "jc@gmail.com", '2008-07-04', 59.99, "2", "$70000"),
    ("500-00-0000", "Lee", "Daniel", "West, Apt E", "Stony Brook", "NY", 11795, "(555)555-5555", "dl@gmail.com", '2018-10-04', 49.95, "1", "$60000");
    
-- additional insert: Login
INSERT INTO Login (username, password_, role_)
VALUES
	("shiyong@cs.sunysb.edu", "123", "customer"),
    ("dhaixia@cs.sunysb.edu", "123", "customer"),
    ("shlu@ic.sunysb.edu", "123", "customer"),
    ("phlew@cs.sunysb.edu", "123", "customer"),
    ("robkelly@cs.sunysb.edu", "123", "customer"),
    ("jl@gmail.com","123","customer"),
    
	("emp1@sunysb.edu", "123", "manager"),
    ("emp2@sunysb.edu", "123", "customerRepresentative"),
    ("emp3@sunysb.edu", "123", "customerRepresentative"),
	("jc@gmail.com","123","manager"),
    ("dl@gmail.com","123","customerRepresentative");

-- Add item
/* 	Item data
	ItemID INT NOT NULL,	
    Name CHAR(64), 			
	Type CHAR(16),			
    Manufactured  INT,		
    NumCopies INT, 			
	Description VARCHAR(256) */
INSERT INTO Item(ItemID, Name, Type, Manufactured, NumCopies, Description)
VALUES
	(1, "Titanic", "DVD", 1990, 4, "This boat will go under the sea"),
    (2, "Nissan Sentra", "Car", 1984, 1, "This can fit in 10 clowns"),
    (3, "AMD Gaming PC", "Electronic", 2020, 1, "AMD R7 5900X"),
    (4, "Apple M1 Pro", "Electronic", 2021, 1, "An Apple M1 Silicon"),
    (5, "Intel Gaming PC", "Electronic", 2020, 1, "Intel i7 11700K");

-- Add auction
/* 	Auction data
	AuctionID INT NOT NULL,	 
	Copies_Sold INT, 		
	MinimumBid DECIMAL(18, 2),			
	ReservePrice DECIMAL(18, 2),
    BidIncrement DECIMAL(18, 2),      
    EmployeeID INTEGER NOT NULL,	
	ItemID INTEGER NOT NULL*/
-- AuctionID INT NOT NULL,
-- 	BidIncrement float4, 
-- 	MinimumBid float4,
-- 	Copies_Sold INTEGER,
-- 	Monitor INTEGER,
-- 	ClosingBid INTEGER,
--     CurrentBid INTEGER,
-- 	CurrentHighBid INTEGER,
-- 	ReservePrice INTEGER,
-- 	ItemID INT NOT NULL,
-- 	EmployeeID CHAR(20) NOT NULL,
-- INSERT INTO Auction(AuctionID, Monitor, ItemID, Copies_Sold, MinimumBid, ReservePrice, BidIncrement, ClosingBid, CurrentBid, CurrentHighBid)
INSERT INTO Auction(AuctionID, ItemID, EmployeeID, BidIncrement, MinimumBid, CopiesSold, Monitor,  ClosingBid, CurrentBid, CurrentHighBid, ReservePrice  )
VALUES
	(1, 1, "100-00-0000",2.0, 5.50, 15, 50, 200000000,30,25,26),
    (2, 2,"200-00-0000", 1.0, 14620.00, 20000, 100, 200000000,31,25,26),
    (3, 3,"300-00-0000", 1.0, 14620.00, 20000, 100, 200000000,31,25,26),
    (4, 4,"400-00-0000", 1.0, 14620.00, 20000, 100, 200000000,31,25,26),
    (5, 5,"500-00-0000", 1.0, 14620.00, 20000, 100, 200000000,31,25,26);
--     (6, 6,"600-00-0000", 1.0, 14620.00, 20000, 100, 200000000,31,25,26);
-- 	(1, "200-00-0000", 1, 2, 5.50, 15.00, 0.50, 13.50, 13.50, 13.50),
--     (2, "200-00-0000", 2, 1, 14620.00, 20000.00, 100.00, 16720.00, 16720.00 ,16720.00),
--     (3, "300-00-0000", 3, 1, 900.00, 1500.00, 25.00, 1150.00, 1150.00, 1150.00),
--     (4, "300-00-0000", 4, 1, 1800.00, 3000.00, 25.00, 2175.00, 2175.00, 2175.00),
-- 	(5, "300-00-0000", 5, 1, 1400.00, 2000.00, 25.00, 1800.00, 1800.00, 1800.00),
--     (6, "200-00-0000", 1, 2, 5.50, 15.00, 0.50, 10.50, 10.50, 10.50);
	
-- 9] Add post
/* 	Post data
	PostDate DATETIME,		-- 'yyyy-mm-dd'	
    ExpireDate DATETIME,	-- 'yyyy-mm-dd'	
    AuctionID INT NOT NULL,		
	CustomerId INT NOT NULL*/
INSERT INTO Post(PostDate, ExpireDate, AuctionID, CustomerId)
VALUES
	('2021-06-01', '2021-06-29', 1, "000-00-0001"),
    ('2021-08-01', '2021-08-31', 2, "000-00-0002"),
    ('2021-08-01', '2022-08-31', 3, "000-00-0003"),
    ('2021-07-01', '2021-07-31', 4, "000-00-0004"),
    ('2021-06-01', '2021-06-29', 5, "000-00-0005");
--     ('2021-07-01', '2021-07-31', 6, "000-00-0003");
