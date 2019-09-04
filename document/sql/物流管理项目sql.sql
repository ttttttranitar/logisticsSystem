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
custom_id VARCHAR(8) primary key ,
custom_name varchar(20) not null,
fax varchar(12) ,
phone varchar(12),
mail varchar(20),
addr varchar(20),
email varchar(20),
contact varchar(20),
client_type varchar(20),
company_type VARCHAR(10),
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

create table transport(
 transport_id varchar(12) primary key,
 start_date  varchar(16),
 end_date varchar(16),
 pay_type varchar(16),
 transport_fee double(7,2),
 insurance_fee double(7,2),
 transport_start varchar(20),
 transport_distinatin varchar(20),
 transport_info varchar(25)
 );

alter table custom add contact_phone varchar(12);
alter table car  add car_width double(5,2);
alter table car  add car_height double(5,2);
alter table driver add driver_address varchar(20);
alter table driver add driver_permit varchar(20);
alter table driver modify driver_id varchar(9) ;
alter table driver add id_card varchar(20);

create view v_car_diver
as
select  car.*,driver_id,driver_name,sex,birthdate,id_card,driver_license,operation_license,insurance_license,driver_permit,driver_address,driver_info
from car, driver
where car.car_id=driver.car_id;





