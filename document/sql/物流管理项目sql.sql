create database logistics;
create table emp(
emp_id int(5) primary key auto_increment,
emp_name varchar(20) not null,
sex char(4),
dept varchar(10) ,
mgr varchar(10),
birthdate varchar(15),
user_statue int(2));

create table custom(
custom_id VARCHAR(8) primary key auto_increment,
custom_name varchar(20) not null,
fax varchar(6) ,
phone varchar(12),
mail varchar(20),
addr varchar(20),
email varchar(20),
contact varchar(20),
client_type varchar(20),
company_type varbinary(10),
company_scale varchar(10)
);

create table driver(
driver_id varchar(20) primary key ,
driver_name  varchar(20) not null,
driver_phone varchar(12),
sex char(4),
birthdate varchar(15),
car_id varchar(20),
driver_info varchar(50),
driver_license varchar(20),
operation_license varchar(20),
insurance_license varchar(20)
);

 create table user (
 user_id int(5) primary key auto_increment,
 user_name varchar(20) not null,
 user_password varchar(12)
 );


create table car(
car_id varchar(20) primary key,
car_type varchar(20) not null,
car_volume double(6,2),
car_weight double(5,2),
car_height double(4,2),
motor_id varchar(16),
VIN varchar(16) ,
company varchar(16),
is_company_car int(2),
company_tel varchar(13)
);

create table custom_order(
order_id varchar(10) primary key,
sender_id VARCHAR(8),
sender_name varchar(20) not null,
sender_phone varchar(12) ,
sender_address varchar(20),
reciever_id  VARCHAR(8),
reciever_name varchar(20) not null,
reciever_phone varchar(12),
reciever_address varchar(20),
order_statue varchar(16),
order_amount double(7,2),
submit_date varchar(16)
);

 


 

