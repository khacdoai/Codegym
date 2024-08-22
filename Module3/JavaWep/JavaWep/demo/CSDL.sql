create database thi_ket_thuc_md3;
use thi_ket_thuc_md3;

create table product(
id int primary key auto_increment,
name varchar(45) not null,
price double not null,
quantity int not null,
color varchar(45) not null,
id_category int,
foreign key product(id_category) references category(id_category)
);

create table category(
id_category int primary key auto_increment,
name_category varchar(45) not null
);

