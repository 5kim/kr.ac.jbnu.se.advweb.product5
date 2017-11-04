

--- create database and set previledge to root account
create database simpleweb;
use simpleweb;
grant all privileges on simpleweb.* to root@localhost ;


-- [중간 정산] Create table

create table user(
id varchar(30) not null,
password  VARCHAR(30) not null,
name VARCHAR(30) not null,
birth int(8) not null,
gender VARCHAR(1) not null,
contact int(11) not null,
email varchar(30) not null,
address varchar(30) not null,
primary key (id) 
) ;

create table product(

productNumber int auto_increment not null,
name  VARCHAR(128) not null,
price FLOAT not null,
seller varchar(30),
description varchar(100),
inventory int not null,
category varchar(10) null,
recommend BOOLEAN not null,

primary key (productNumber)
) ;

create table orders(
orderNumber  int auto_increment not null,
customerId  varchar(30) not null,
productNumber VARCHAR(20) not null,
date int not null,
count int not null,
primary key (orderNumber)
) ;

create table cart(
cartNumber int auto_increment not null,
userId varchar(30) not null,
productNumber VARCHAR(20) not null,
count int not null,
primary key (cartNumber)
);

create table coupon(
serialNumber int auto_increment not null,
userId varchar(30) not null,
discountRate VARCHAR(20) not null,
period int not null,
primary key (serialNumber)
) ;

-- [변경된] Insert data: ---------------------------------------------------------------

-
