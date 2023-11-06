create database Quan_ly_sinh_vien ;
use Quan_ly_sinh_vien;
create table Class (
ClassID int not null auto_increment primary key,
ClassName varchar(60) not null,
StartData datetime not null,
Status bit
);

CREATE TABLE Student
(
 StudentID int not null auto_increment primary key,
 StudentName varchar(30) not null,
 Address varchar(50),
 Phone varchar(20),
 `status` bit,
 ClassId int not null,
 foreign key (ClassId) references Class (ClassID)
);

create table `subject`(
SubId int not null auto_increment primary key,
Subname varchar(30) not null,
Credit tinyint not null default 1 check (Credit >= 1),
Status bit default 1
);
create table Mark (
MarkId int not null auto_increment primary key,
subId int not null,
studentId int not null,
mark float default 0 check (Mark between 0 and 100),
ExamTime tinyint default 1,
unique (SubId, StudentID),
foreign key (SubId) references `Subject` (SubId),
foreign key (StudentId) references  Student (StudentId)
);