
CREATE DATABASE test; -- create a database and call it test

use test; -- add a table and name it Emp99
CREATE TABLE Emp99 (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    salary float(20,5),
    designation varchar(50),
    PRIMARY KEY (id)
);