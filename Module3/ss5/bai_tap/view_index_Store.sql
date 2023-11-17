use quan_ly_ban_hang ;	
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
  create table OrderDetail (
  oID int not null,
  pID int not null,
  odQTY int not null,
  foreign key (oID) references `Order`(oID)
  );
  create table Products ( 
  ID int not null  auto_increment primary key,
  productCode int not null ,
  productName varchar(225) not null,
  pPrice int not null,	
  productAmuont int,
  productDescription varchar(225),
  productStatus varchar(225)
  ); 
  -- Bước 3 -- 
create unique index idx_product on products(productcode);
explain select * 
from products where productcode = 23;

create index idx_composite on products(productName, pPrice);
explain select * 
from products where productName = "dien thoai " or pPrice = 20000 ;

-- Bước 4 --
create view products_view as
select productCode,productCode,pPrice,productStatus
from products;

select * from products_view;  

create or replace view products_view as
select productCode,pPrice,productStatus,productDescription
from products;
select * from products_view;  

-- Bước 5 --

--Hiển thị sản phẩm --
delimiter //
create procedure getProducts()
begin 
select * from products;
end //
delimiter ;
call getProducts();
-- thêm mới sản phẩm --
delimiter //
create procedure addProducts(in id int,in pcode int,in pname varchar(225) ,in pPice int,in pAmount int,in pDesctrption varchar(225),in pStatus varchar(225))
begin 
insert into products(ID,productCode,productName,pPrice,productAmuont,productDescription,productStatus)
values (id,pcode,pname,pPice,pAmount,pDesctrption,pStatus);
end //
delimiter ;

--sửa sản phẩm theo id ---
delimiter //
create procedure updateProducts(in id int,in pcode int,in pname varchar(225) ,in pPice int,in pAmount int,in pDesctrption varchar(225),in pStatus varchar(225))
begin 
update products
set productCode = pcode, productName = pcode , pPrice = pPice, productAmuont = pAmount, productDescription = pDesctrption, productStatus = pStatus
where id = ID;
end //
delimiter ;
-- xóa sản phẩm theo id --
delimiter //
create procedure updateProducts(in id int)
begin 
delete from products
where id = ID;
end //
delimiter ;

