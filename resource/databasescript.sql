

--- create database and set previledge to root account
create database simpleweb;
use simpleweb;
grant all privileges on simpleweb.* to root@localhost ;


-- [변경된] Create table

create table user(
id varchar(30) not null,
password  VARCHAR(30) not null,
name VARCHAR(30) not null,
birth int(8) not null,
gender VARCHAR(1) not null,
contact int(11),
email varchar(30),
primary key (id) 
) ;

create table product(
productNumber VARCHAR(20) not null,
name  VARCHAR(128) not null,
price FLOAT not null,
seller varchar(30),
description varchar(100),
inventory int not null,
primary key (productNumber)
) ;


----- 선택 사항 (필요한 분만) --------

create table orders(
orderNumber VARCHAR(20) not null,
customerId  varchar(30) not null,
productNumber VARCHAR(20) not null,
date int not null,
count int not null,
primary key (orderNumber)
) ;

create table cart(
userId varchar(30) not null,
productNumber VARCHAR(20) not null,
count int not null,
primary key (userId,productNumber)
) ;

create table coupon(
serialNumber varchar(30) not null,
userId varchar(30) not null,
discountRate VARCHAR(20) not null,
period int not null,
primary key (serialNumber)
) ;

-- [변경된] Insert data: ---------------------------------------------------------------

insert into user (id, password, gender, name, contact, birth, email)
values ('tomid', 'tom001', 'M', 'tom', '0101111111', 19920614, 'tom001@naver.com');

insert into user (id, password, gender, name, contact, birth, email)
values ('jerryid', 'jerry001', 'F', 'jerry', '0112222222', 19942388, 'jerry@daum.net');
 
insert into product (productNumber, name, price, seller, description, inventory)
values ('P001', 'Java shirt', 100.40, 'Oracle', 'Java logo printed shirt', 1);
 
insert into product (productNumber, name, price, seller, description, inventory)
values ('P002', 'C# socks', 49.99, 'microsoft', 'MS logo printed socks', 12);


select * from product;
select * from user;
