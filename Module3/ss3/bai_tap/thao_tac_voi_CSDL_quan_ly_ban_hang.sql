use quan_ly_ban_hang_2;
insert into customer 
value (1, "Minh Quan", 10),
	(2,"Ngoc Oanh", 20),
    (3,"Hong Ha", 50);
insert into `order`
value (1,1,'2006-3-26',null),
	(2,2,'2006-3-23', null),
    (3,1,'2006-3-16', null);
insert into product 
value (1,"May Giat" , 3),
		(2,"Tu Lanh",5),
        (3,"Dieu Hoa",7),
        (4,"Quat",1),
        (5,"Bep Dien",2);
insert into orderdetail
value (1,1,3),
	(1,3,7),
    (1,4,2),
    (2,1,1),
    (3,1,8),
    (2,5,4),
    (2,3,3);
    
    select oid, oDate, oTotalPrice from `order`;	
    
    select o.cID, c.cName, od.pID, p.pname
    from customer c join `order` o on c.cID = o.cID join orderdetail od on o.oID = od.oID join product p on od.pID = p.pID ;

    select c.cname 
from customer c left join `order` od  on c.cID = od.cID
where od.cID is null;    

select o.oID, o.oDate, Sum(p.pPrice * od.odQTY) as oPrice 
from `order` o
join orderdetail od  on o.oID = od.oID 
join product p on od.pID = p.pID
group by o.oID , o.oDate;












    
  