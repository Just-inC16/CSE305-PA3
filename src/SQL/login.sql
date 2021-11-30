create database cse305pa3;
use customercse305pa3;
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

select * from Login;
