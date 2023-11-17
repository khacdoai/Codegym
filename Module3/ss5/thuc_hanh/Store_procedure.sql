delimiter //

create procedure findAllCustomers()
begin
select * from customers where customerNumber = 175;
end //
delimiter ; 
call findAllCustomers();

