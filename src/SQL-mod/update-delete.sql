-- Update customer
UPDATE Customer
SET CreditCardNum = 1000000000000000
WHERE CustomerID = 1;

-- Delete customer 
DELETE FROM Customer
WHERE CustomerID = 2;

-- Update employee
UPDATE Employee
SET HourlyRate = 70.99
WHERE EmployeeID = 100000000;

-- Delete employee
DELETE FROM Employee
WHERE EmployeeID = 200000000;
