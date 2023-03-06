CREATE DATABASE spring_test;


CREATE TABLE employee(
	eId serial not null,
	eName varchar(30),
	age int4,
	ePassword varchar(30),
	PRIMARY KEY (eId)
);

select * from employee;