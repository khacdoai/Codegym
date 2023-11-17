create view customer_views as
select customerNumber, customerName, phone
from customers;

select * from customer_views;

create or replace view view_name as
select customerNumber, customerName, contactFirstName, contactLastName, phone
from customers
where city = 'Nantes';

select * from view_name;

drop view view_name;
drop view customer_views;