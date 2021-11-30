INSERT INTO Customers 
(CustomerId, LastName, FirstName, Address, City, State, ZipCode, Telephone, Email, CreditCard, Rating) 
VALUES
(‘shiyong’, ‘Lu’, ‘Shiyong’, ‘123 Success Street’, ‘Stony Brook’, ‘NY’, ‘11790’, ‘(516)632-8959’, ‘shiyong@cs.sunysb.edu’, ‘1234-5678-1234-5678’, ‘1’),
(‘haixia	Du’, ‘Haixia’, ‘456 Fortune Road’,’Stony Brook’,’NY’,’11790’,’(516)632-4360’,’dhaixia@cs.sunysb.edu’,’5678-1234-5678-1234’,’1’),
(‘john’,’Smith’,’John’,’789 Peace Blvd.’,’Los Angeles’,’CA’,’12345’,’(412)443-321’,’shlu@ic.sunysb.edu’,’2345-6789-2345-6789’,’1’ ), 
(‘phil’, ‘Phil’, ‘Lewis’, ‘135 Knowledge Lane’, ‘Stony Brook’, ‘NY’, ‘11704’, ‘(516)666-8888’, ‘pml@cs.sunysb.edu’, ‘6789-2345-6789-2345’, ‘1’);

INSERT INTO Employees
(SSN, LastName, FirstName, Address, City, State, ZipCode, Telephone, StartDate, HourlyRate)
VALUES
(‘123-45-6789’,’Smith’,’David’,’123 College road’,’Stony Brook’,’NY’,’11790’,’(516)215-2345’,’11/1/98’,’$60’),
(‘789-12-3456’,’Warren’,’David’,’456 Sunken Street’,’Stony Brook’,’NY’,’11794’,’(516)632-9987’,’2/2/99’,’$50’);
-- David Warren is the Manager of the auction house 

INSERT INTO Items(Name,Poster,Type, Year, CopiesAvailable, OpenBid, BidIncrement,ReservePrice, OpenData, CloseTime) 
VALUES (‘Titanic’, ‘phil’, ‘DVD’,2005,4,5,1,10, ‘Now’, ‘1:00PM, 12/16/08’),
(‘Nissan Sentra’, ‘john’, ‘Car’,2007, 1, 1000,10,2000, ‘Now’, ‘1:00PM,12/6/08’);


INSERT INTO BiddingHistory(Bidder/MaximumBid,CurrentBid,BidIncrement, MaximumBid, CurrentWinner)
VALUES( ‘haixia/$10’,5,1,10, ‘haixia’),
( ‘shiyong/$10’,9,1,10, ‘haixia’),
( ‘shiyong/$10’,10,1,10, ‘haixia’),
( ‘shiyong/$15’,11,1,15, ‘shiyong’),
( ‘Closing’,11,1,15, ‘shiyong’);
