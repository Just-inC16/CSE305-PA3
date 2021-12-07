SELECT user,authentication_string,plugin,host FROM mysql.user;
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'Current-Root-Password';
FLUSH PRIVILEGES;
-- SET PASSWORD FOR 'root'@'localhost' = PASSWORD('manager');
INSERT INTO mysql.user (Host, User, Password) VALUES ('%', 'root', password('365365365jJkK'));
GRANT ALL ON *.* TO 'root'@'%' WITH GRANT OPTION;
