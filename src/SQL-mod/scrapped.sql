/*-- query password validation
select P.Email, P.Password_, P.Role_
from Person as P
where P.Email = "jc@gmail.com" 
AND P.Password_ = "jc123";

-- get EmpID based on email
select employeeID
from (
	select * 
	from Person, Employee
	where Employee.EmployeeID = Person.SSN
) as EmpInfo
where EmpInfo.email = username;

-- get CustID based on email
select customerID
from (
	select * 
	from Person, Customer
	where Customer.CustomerID = Person.SSN
) as CustInfo
where CustInfo.email = username;


select EmployeeID from Employee where EmployeeID.email= "jc@gmail.com";

-- query info about customers
select * 
from Person, Customer
where Customer.CustomerID = Person.SSN;

-- query info about employees
select * 
from Person, Employee
where Employee.EmployeeID = Person.SSN;*/