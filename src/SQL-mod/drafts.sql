-- for working on getSalesListing()
-- customized query 4] to test getSalesListing()
SELECT I.Name, C.FirstName, C.LastName, B.*
FROM cse305pa3.bidwon as B, Customer as C, Item as I;

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
