

--- create database and set previledge to root account
create database simpleweb;
use simpleweb;
grant all privileges on simpleweb.* to root@localhost ;


-- [중간 정산] Create table

create table user(
id varchar(30) not null,
password  VARCHAR(30),
name VARCHAR(30),
birth int(8),
gender VARCHAR(6) not null,
contact int(11),
email varchar(30),
address varchar(30),
primary key (id) 
) ;

create table product(

productNumber VARCHAR(20) not null,
name  VARCHAR(128),
price FLOAT,
seller varchar(30),
description varchar(100),
inventory int,
category varchar(10),
recommend BOOLEAN DEFAULT 0,
Image mediumblob,
primary key (productNumber)
) ;

create table orders(
orderNumber  int auto_increment not null,
customerId  varchar(30),
productNumber VARCHAR(20),
date Date,
count int,
primary key (orderNumber)
) ;

create table cart(
cartNumber int auto_increment not null,
userId varchar(30),
productNumber VARCHAR(20),
count int,
primary key (cartNumber)
);

create table coupon(
serialNumber int auto_increment not null,
couponName varchar(30),
userId varchar(30),
discountRate int,
period Date,
primary key (serialNumber)
) ;