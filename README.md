# PAF-Assignment
This project is for 3rd year 1st semester PAF module.


--------------------------- Add these dependencies to POM.xml---------------------------------------

<dependency>
  <groupId>com.sun.jersey</groupId>
  <artifactId>jersey-bundle</artifactId>
  <version>1.19.4</version>
</dependency>
<dependency>
  <groupId>com.sun.jersey</groupId>
  <artifactId>jersey-core</artifactId>
  <version>1.19.4</version>
</dependency>
<dependency>
  <groupId>com.sun.jersey</groupId>
  <artifactId>jersey-server</artifactId>
  <version>1.19.4</version>
</dependency>
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  <version>8.0.19</version>
</dependency>
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.2.3</version>
</dependency>
<dependency>
  <groupId>org.jsoup</groupId>
  <artifactId>jsoup</artifactId>
  <version>1.8.1</version>
</dependency>

---------------------------Configure the servlet mapping in web.xml--------------

<servlet>
    <servlet-name>Jersey Web Application</servlet-name>
    <servlet-class>com.sun.jersey.spi.container.servlet.ServletContainer</servlet-class>
    <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
    <servlet-name>Jersey Web Application</servlet-name>
    <url-pattern>/AppointmentService/*</url-pattern>
</servlet-mapping>

------------------------------------URL------------------------------------------

http://localhost:8080/HealthcareSystem/AppointmentService/Appointments

----------------------------------------------------------------------------

---------------------------SQL script-----------------------------------------


create database paf;

use paf;

CREATE TABLE users(
  user_id int NOT NULL auto_increment primary key ,
  username varchar(255) NOT NULL,
  phoneNo varchar(15) NOT NULL,
  age int NOT NULL,
  address varchar(255) NOT NULL,
  gender varchar(10) NOT NULL,
  email varchar(255) NOT NULL
  ); 
  
  CREATE TABLE `doctor` (
  `doctor_id` int NOT NULL primary key,
  `doctor_name` varchar(255) NOT NULL,
  `specialization` varchar(255) NOT NULL,
  `registrationNo` int NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(15) NOT NULL
);

CREATE TABLE `appointments` (
  `appointment_id` int NOT NULL auto_increment primary key,
  `user_id` int NOT NULL,
  `doctor_id` int NOT NULL,
  `hospital_id` int NOT NULL,
  `appointment_time` varchar(30) NOT NULL,
  `appointment_date` varchar(30) NOT NULL,
  `WardNo` varchar(10) NOT NULL

);  

drop table appointments;
  
 CREATE TABLE `payment` (
  `payment_id` int NOT NULL,
  `user_id` int NOT NULL,
  `hospital_id` int NOT NULL,
  `Payment_method` varchar(255) NOT NULL,
  `appointment_id` int NOT NULL,
  `doctor_id` int NOT NULL,
  `paid_time` datetime NOT NULL,
  `purpose` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ; 
  
  CREATE TABLE `hospital` (
  `hospital_id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `appointment_room_no` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
); 
  
  CREATE TABLE `card_details` (
  `payment_id` int NOT NULL,
  `card_type` varchar(255) NOT NULL,
  `card_number` varchar(255) NOT NULL,
  `cvv` varchar(5) NOT NULL,
  `expiryDate` date NOT NULL
); 
  
  
 select * from users;
 select * from doctor;
 select * from hospital;
 select * from appointments;
 select * from payment;
 select * from card_details;
 
insert into users values(1,'Shone','0342040123',26,'Nugegoda','M','cs@gmail.com');
insert into users values(2,'Nimshi','0762040123',24,'Kalutara','F','na@gmail.com');
insert into users values(4,'Danisha','0712040123',32,'Wadduwa','M','d32@gmail.com');
insert into users values(3,'Savini','0752040156',20,'Moratuwa','F','sh@gmail.com');

insert into doctor values (100,'Mr.Perera','ENT',1028,'Colombo','0785050500');
insert into doctor values (105,'Mrs.Yapa','General Medicine',1908,'Kalutara','0705050500');
insert into doctor values (5609,'Mr.Suwaris','Dentist',3028,'Colombo','0725050500');
insert into doctor values (2340,'MrS.Silva','Dentist',990,'Colombo','0725050500');

insert into hospital values (234,'General Hospital','Colombo','0112450234','20','general_h@yahoo.com');
insert into hospital values (3400,'New Philip','Kalutara','0112450234','20','new_p@yahoo.com');
insert into hospital values (567,'Panadura Hospital','Panadura','0112450234','20','panadura_h@yahoo.com');
insert into hospital values (17000,'Hemas Hospital','Battaramulla','0115450234','20','hh@yahoo.com');

insert into appointments(user_id,doctor_id,hospital_id,appointment_time,appointment_date,WardNo) values (1,100,234,'18-30.00','2020-05-03','N21');
insert into appointments(user_id,doctor_id,hospital_id,appointment_time,appointment_date,WardNo) values (2,105,3400,'16-00.00','2020-04-28','201');
insert into appointments(user_id,doctor_id,hospital_id,appointment_time,appointment_date,WardNo) values (4,5609,567,'18-30.00','2020-04-20','N-101');

select a.appointment_id,u.user_id,u.username,d.doctor_id,d.doctor_name,h.hospital_id,h.name,a.appointment_time,a.appointment_date,a.WardNo
from users u, doctor d, hospital h, appointments a
where u.user_id=a.user_id and d.doctor_id=a.doctor_id and h.hospital_id=a.hospital_id;
