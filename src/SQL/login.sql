create database cse305pa3;
use cse305pa3;
drop table Login;

CREATE TABLE Login (		 
	username CHAR(20) NOT NULL UNIQUE, 
    PRIMARY KEY (username),
	password_ CHAR(20),
	role_ CHAR(40)
);

INSERT INTO Login (username, password_, role_)
VALUES
("jc@gmail.com","jc123","manager"),
("dl@gmail.com","dl123","customerRepresentative"),
("jl@gmail.com","jl123","customer");

-- login validation
select *
from Login
where Login.username = "jc@gmail.com" 
AND Login.password_ = "jc123";


select * from Login;

-- Change the login credentials for the users 
Update Login 
SET username='dl@g', password_='456'
WHERE username='dl@gmail.com';

Update Login 
SET username='jc@g', password_='123'
WHERE username='jc@gmail.com';

Update Login 
SET username='dl@g', password_='456'
WHERE username='dl@gmail.com';
-- INSERT INTO Employee(employeeID, startDate, hourlyRate, level_, firstName, lastName, address, city, state, zipCode, email, telephone, revenue) VALUES ('12332131', 'jdslfj', '78.0', 'null', 'ChongABC', 'jgl', 'lkdf', 'gjlkewj', 'NJ', 122321, 'dsfdsf@d', '123123', 'null', );
