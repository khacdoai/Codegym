CREATE database student_management ;
create table `student_management`.`Student`(
id INT NOT NULL,
name varchar(45) null,
primary key(id));
create table `student_management`.`Teacher`(
id INT NOT NULL,
name varchar(45) null,
age int null,
country varchar(45) null,
primary key(id));