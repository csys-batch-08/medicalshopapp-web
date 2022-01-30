create table users(
user_id number(5) generated always as identity start with 1,
full_name varchar2(100) not null,
contact_address varchar2(100),
user_email varchar2(100) not null,
user_password varchar2(100) not null,
account_status varchar2(20),
points number(5),
user_wallet number(5),
CONSTRAINT pk_users primary key(user_id)
);


commit;
select * from users;
update users set user_wallet=500 where user_id=23;
commit;
alter table users modify user_password unique;
insert into users (full_name,gender,user_mail,user_password) values ('KUMARASAMY R','MALE','KUMARASAMY@GMAIL.COM','Kumar@123');
alter table users add user_mobile int not null unique;
delete from users where user_id=108;
alter table users drop column role;
commit;
describe users;
alter table users modify user_id number(5) generated always as identity start with 1;
alter table users modify CONSTRAINT pk_admin primary key(user_id);
alter table users modify user_id number(5) generated always as identity start with 1;


create table admins(
admin_id number(5) generated always as identity start with 1,
admin_name varchar2(50) not null,
admin_email varchar2(200) not null,
admin_password varchar2(100) not null,
admin_email varchar2(100) not null,
CONSTRAINT admin_pk primary key (admin_id)
);
select * from admin;
desc admin;
select admin_name,age,admin_password,admin_email,admin_mobile from admin  where admin_email= 'karthick@medhub.com' and admin_password='Karthick@1234';
create table products(
product_id int,
product_category varchar2(100) not null,
product_name varchar2(100) not null,
description varchar2(100) not null,
price number(10,2) not null,
quantity int,
POINTS_PER_UNIT  NUMBER(38) not null    
STATUS  VARCHAR2(30) not null,  
OFFER NUMBER(38) not null,
CONSTRAINT pk_product primary key (product_id)
);

commit;
desc products;
create sequence product_id_seq increment by 1 start with 8659;
select * from products;
delete from products where product_id =8801;
alter table products modify product_id  default product_id_seq.nextval;
alter table products modify product_name unique;
update products set available_Quantity=200 where product_id = 9678;
update products set status ='available' where product_id =8819;
alter table products modify product_id number generated always as identity start with 5000;
delete from products where product_id =8779;
Alter table products modify (product_id number DEFAULT product_id_seq.nextval);
alter table products modify product_img varchar2(500);
select p.product_name,p.points_per_unit,oi.quantity,oi.unit_price,oi.total_price,oi.order_id,p.product_img,p.description,p.offer,p.product_id,oi.order_id from order_items oi inner join
orders o on oi.order_id=o.order_id inner join products p on oi.product_id=p.product_id where oi.user_id =23;

create table orders(
order_id number(5),
user_id number(5) not null,
order_date date default sysdate not null,
price number(10,2) not null,
order_status varchar2(30) default 'NotDelivered' not null,
order_type  varchar2(30) not null,
constraint pk_orders primary key (order_id),
constraint fk_orderUserid foreign key (user_id) references users(user_id)
);

delete from orders where user_id=141;
alter table orders modify order_status default 'order placed';

select * from orders where trunc(order_date) between trunc(sysdate-30) and trunc(sysdate) and order_status = 'order placed';
select * from orders where trunc(order_date) between trunc(sysdate-7) and trunc(sysdate);
select * from orders;
select * from products;
select * from order_items;

select trunc(o.order_date),p.product_name,sum(oi.quantity) as quantity,oi.total_price as price, (sum(oi.quantity)*oi.total_price) as totalPrice
 from order_items oi
 join orders o on o.order_id = oi.order_id
 join products p on p.product_id = oi.product_id
 where trunc(o.order_date) between '01-01-2022' and '18-01-2022' 
group by(trunc(o.order_date),p.product_name,oi.quantity,oi.total_price);        
 

desc orders;
create table order_items(
item_id number(5),
order_id number(5) not null,
product_id number(5) not null,
quantity number(5) not null,
unit_price number(10,2) not null,
total_price number(20,2) not null,
constraint pk_orderitems primary key(item_id),
constraint fk_Orderitems_Productid foreign key(product_id) references products(product_id),
constraint fk_Orderitems_orderid foreign key(order_id) references orders(order_id)
);
select * from order_items;
select * from order_items,orders,products;
commit;
delete from order_items where user_id = 81;
create table cart(
items int generated always as identity start with 1,
product_id int not null,
user_id int not null,
unit_price number(10,2) not null,
qty int not null,
total_price numnber(5,2),
constraint fk_cart_productid foreign key (product_id) references products(product_id),
constraint fk_cart_userid foreign key (user_id) references users(user_id)
);
delete from order_items where user_id=23 ;

select * from cart;
commit;

                    --trigger
CREATE TABLE audits (
      audit_id         NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
      table_name       VARCHAR2(255),
      transaction_name VARCHAR2(10),
      by_user          VARCHAR2(30),
      transaction_date DATE
);

CREATE OR REPLACE TRIGGER customers_audit_Trig
    AFTER 
    UPDATE OR DELETE 
    ON customers
    FOR EACH ROW    
DECLARE
   l_transaction VARCHAR2(10);
BEGIN
   -- determine the transaction type
   l_transaction := CASE  
         WHEN UPDATING THEN 'UPDATE'
         WHEN DELETING THEN 'DELETE'
   END;

   -- insert a row into the audit table   
   INSERT INTO audits (table_name, transaction_name, by_user, transaction_date)
   VALUES('CUSTOMERS', l_transaction, USER, SYSDATE);
END;
/


--                                        package and procedure for medhub

create or replace package body as user_operation as
procedure insert_user
(u_name in varchar2,
u_address in varchar2,
u_password in varchar2,
u_email in varchar2,
u_age in number,
u_mobile in number,
status out varchar2,
v_error varchar2)
is 
begin
insert into users(full_name,contact_address,user_password,user_email,age,user_mobile) values(u_name,u_address,u_password,u_email,u_age,u_mobile,);
if sql % rowcount>0 then
status:='registered';
end if;
commit;
EXCEPTION when others then
status:='wrong';
v_error:=sqlcode || sqlerrm;
end insert_user;
 
procedure delete_user(u_id in number)
is 
begin
update users set Account_status='inactive';
commit;
end delete_user;

procedure update_wallet(u_id in number,amt in number)
is
begin 
update users set user_wallet=amt where user_id=u_id;
commit;
end update_cart;
end user_operation;
/


create or replace PACKAGE user_operation  AS
    procedure insert_user (u_name in varchar2,u_address in varchar2,u_password in varchar2,u_email in varchar2,u_age in number,u_mobile in number,status out varchar2,v_error varchar2);
    PROCEDURE delete_user (u_id in number);
    PROCEDURE update_wallet (u_id in number,amt in number);
END user_operation;
/

set serverout on;
declare 
v_status varchar2(2);
v_error VARCHAR2(500);
begin
   user_operation.insert_user('ganesh','salem','Ganesh@123','ganesh@gmail.com',23,9876543210,v_status,v_error);
   DBMS_OUTPUT.PUT_LINE(V_STATUS  ||'   '|| V_ERROR );
   end;
   
   
   select * from cart;
   commit;;
   /
select order_date+100 from orders; 
   
create table fghjk(ex varchar2(30));
insert into fghjk values('fghj');
alter table fghjk modify ex generated always as identity increment by 1;
   