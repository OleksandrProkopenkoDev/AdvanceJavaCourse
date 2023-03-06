create table student(
	rollno int,
	st_name varchar(25),
	age int
);
select * from student;

insert into student
values 
(1, 'Vas', 25),
(2, 'Greg', 23);

alter table student
add constraint 
primary key (rollno); 

delete from student
where rollno >5;

create table city_image(
	img_id SERIAL NOT NULL,
	img_name varchar(35) not null default '',
	photo bytea null,
	primary key(img_id)
);

CREATE TABLE employee(
	employee_id serial NOT NULL,
	employee_name VARCHAR(30) not NULL,
	age int4 not null,
	salary int8 not null,
	PRIMARY key (employee_id)
);

insert into employee (employee_name,age,salary)
values
( 'Vasil', 33, 52000),
( 'Petro', 27, 44000),
( 'Kozak', 43, 82000);

SELECT * from employee;