-- for working on getSalesListing()
-- customized query 4] to test getSalesListing()
SELECT B.*, C.FirstName, C.LastName, I.Name
FROM cse305pa3.bidwon as B, Customer as C, Auction as A, Item as I
WHERE B.CustomerID = C.CustomerID AND 
	B.AuctionID = A.AuctionID AND
    I.ItemID = A.ItemID
ORDER BY B.AuctionID DESC;

-- for working on getSellers()
-- customized query
SELECT Distinct C.*
FROM Customer as C, Post as P
WHERE C.CustomerID = P.CustomerID;

-- query password validation
select P.Email, P.Password_, P.Role_
from Person as P
where P.Email = "jc@gmail.com" 
AND P.Password_ = "jc123";
