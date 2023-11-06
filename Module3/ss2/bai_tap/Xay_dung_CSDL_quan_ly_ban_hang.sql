create database quan_ly_ban_hang_2;
use quan_ly_ban_hang_2 ;	
create table Customer (
  cID int not null auto_increment primary key,
  cName varchar(225) not null,
  cAge int 
);
  create table `Order` (
  oID int not null auto_increment primary key,
  cID int not null, 
  oDate date not null, 
  oTotalPrice int not null,
  foreign key (cID) references Customer (cID)
  ); 
  create table Product ( 
  pID int not null  auto_increment primary key,
  pName varchar(225) not null,
  pPrice int not null	
  );
  create table OrderDetail (
  oID int not null,
  pID int not null,
  odQTY int not null,
  foreign key (oID) references `Order`(oID),
  foreign key (pID) references  Product(pID)
  );
  