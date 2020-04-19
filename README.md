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

 <servlet-mapping>
 	<servlet-name>Jersey Web Application</servlet-name>
 	<url-pattern>/AppointmentViewService/*</url-pattern>
  </servlet-mapping>

------------------------------------URL------------------------------------------

http://localhost:8080/HealthcareSystem/AppointmentService/Appointments    //read appointments

http://localhost:8080/HealthcareSystem/AppointmentService/Appointments/3   // read specific appointment

http://localhost:8080/HealthcareSystem/AppointmentService/Appointments/    //insert/update/delete appointments


http://localhost:8080/HealthcareSystem/AppointmentViewService/View       //read appointment_views

http://localhost:8080/HealthcareSystem/AppointmentViewService/View/       //insert/update/delete appointment views

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
  `doctor_id` int NOT NULL auto_increment primary key,
  `doctor_name` varchar(255) NOT NULL,
  `specialization` varchar(255) NOT NULL,
  `regNo` int NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(15) NOT NULL
);


  CREATE TABLE `hospital` (
  `hospital_id` int NOT NULL primary key,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `email` varchar(255) NOT NULL
); 
  
  CREATE TABLE `appointment_room` (
	`appointment_room_id` VARCHAR(100) NOT NULL PRIMARY KEY,
	`description` VARCHAR(45) NULL,
	`hospital_ID` INT,
	CONSTRAINT `hospital_id_fk` FOREIGN KEY (`hospital_ID`) REFERENCES `hospital`(`hospital_id`) 
    );

create table appointment_view(
  ref_id int auto_increment primary key,
  doctor_id int NOT NULL,
  doctor_name varchar(255),
  hospital_id int NOT NULL,
  name varchar(255),
  appointment_time varchar(30) NOT NULL,
  appointment_date varchar(30) NOT NULL,
  WardNo varchar(10) NOT NULL,
  
  CONSTRAINT `doctor_V_fk` FOREIGN KEY (`doctor_id`) REFERENCES `doctor`(`doctor_id`) ,
  CONSTRAINT `hospital_V_fk` FOREIGN KEY (`hospital_id`) REFERENCES `hospital`(`hospital_id`) 

);


CREATE TABLE `appointments` (
  appointment_id int NOT NULL auto_increment primary key,
  ref_id int ,
  user_id int,
  CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `users`(`user_id`) ,
  CONSTRAINT `ref_fk` FOREIGN KEY (`ref_id`) REFERENCES `appointment_view`(`ref_id`) 
);  

  
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
 select * from appointment_room;
 select * from appointment_view;
 select * from appointments;
 select * from payment;
 select * from card_details;
 
INSERT INTO `users` (`user_id`, `username`, `phoneNo`, `age`, `address`, `gender`, `email`) VALUES 
			(1, 'Sanath Jayasuriya', '07123213', 45, 'No:2,Baseline Road,Colombo.', 'Male', 'sanathj@gmail.com'), 					(2, 'Aravinda De Silva', '075678232', 47, 'N0:45,Kaluthara.', 'Male', 'Aravinda@yahoo.com'),
			(4, 'Chamari Atapaththu', '075681234', 34, 'No:4,Maharagama,Pannipitiya.', 'Female', 'chamari@gmail.com'),				(5, 'Sachithra Senanayake', '073456789', 29, 'No:45,Yakkala,Gampaha.', 'Male', 'sachithra@gmail.com'),
			(6, 'Ajantha Mendis', '078345255', 37, 'Alawalla Road,Mathara.', 'Male', 'ajantham@gmail.com'),
			(7, 'Jehan Mubarak', '076234578', 34, 'No:15,Negambo.', 'Male', 'jehan@gmail.com'),
			(8, 'Shashikala Siriwardena', '011345466', 32, 'No:3,Borella,Colombo 8.', 'Female', 'shashikala@gmail.com'),
			(9, 'Kalani Perera', '073456789', 24, 'No:45,1st lane,Kurunegala.', 'Female', 'kalani@gmail.com'),
			(10, 'Rangana Herath', '078457459', 40, 'No:8,Kottawa.', 'Male', 'rangana@gmail.com'),
			(11, 'Shanika Wijerathne', '072756479', 26, 'No:22,3rd lane,Colombo 5.', 'Female', 'shanika@gmail.com'),
                        (12,'Shone Chathushka','0755099051',26,'Nugegoda','Male','cs@gmail.com');

INSERT INTO `doctor` (`doctor_name`, `specialization`, `regNo`, `address`, `phone`) VALUES 
						('Dr.Nalin Wijekoon', 'Heart Surgeon', '12', 'Colombo', '0111234321'),
						('Dr.Saman Senanayaka', 'Eye Specialist', '13', 'Kandy', '0711234567'),
						('Dr. Manil Peiris', 'Chest specialist', '14', 'Kandy', '0771234567'),
						('Dr. Anura Kularathna', 'VP', '15', 'Matale', '0773429181'),
						('Dr. Janaka Rambukwella', 'VOG', '16', 'Kurunegala', '071123456'),
						('Dr. Shantha Disanayaka', 'ENT', '16', 'Colombo', '0117894561'),
						('Dr. Jagath Ranaweera', 'VP', '17', 'Kandy', '0811234567'),
						('Dr. Sampath Perera', 'Cancer specialist', '19', 'Kandy', '0777456987'),
						('Dr. Vindya Silva', 'MLT', '13', 'Colombo', '0777852369'),
						('Dr. Kalindu Weerasinghe', 'Psychiatrist', '15', 'Galle', '0701741258');


insert into hospital values    (1,'Kandy Private Hospital','No.110,Kandy Road, Mapanawathura',0811234567,'kph@gmail.com'),
			       (2,'Asiri Hospital','No.12,kirimandala road, kirulapana',0112349567,'asirihospital@gmail.com'),
                               (3,'Nawaloka Hospital','No.169,Colombo Rd,Negambo',0315777773,'nawaloka20@gmail.com'),
                               (4,'Lanka Hospitals','578 Elvitigala Mawatha, Colombo 00500',011234877,'lankahospital@gmail.com'),
                               (5,'Durdans Hospital','3 Alfred Pl, Colombo 00300',0112140000,'durdanshospital@gmail.com'),
                               (6,'Asiri Hospital Matara','No 26, Esplanade Rd Uyanwatta, 81000',04175505540,'asirihospital@gmail.com');
                               
insert into appointment_room values('KPH001','DENTISTS',1),
				       ('KPH002','CARDIOLOGISTS',1),
                                       ('AHC001','NEPHROLOGIST',2),
                                       ('AHC002','ONCOLOGY',2),
                                       ('NH001','PULMONOLOGIST',3),
                                       ('NH002','CARDIOLOGISTS',3),
                                       ('LH001','NEPHROLOGIST',4),
                                       ('LH002','PULMONOLOGIST',4),
                                       ('DH001','CARDIOLOGISTS',5),
                                       ('DH002','ONCOLOGY',5),
                                       ('AHM001','CONSULTANT',6);

insert into appointment_view(doctor_id,doctor_name,hospital_id,name,appointment_time,appointment_date,WardNo) values
		(1,'Dr.Nalin Wijekoon',1,'Kandy Private Hospital','18-30.00','2020-05-03','LH001'),
		(7,'Dr. Jagath Ranaweera',5,'Durdans Hospital','17-00.00','2020-04-20','DH002');

insert into appointments (ref_id, user_id) values (1,1);
insert into appointments (ref_id, user_id) values (2,12);
insert into appointments (ref_id, user_id) values (1,4);

select a.appointment_id,u.user_id,u.username,v.doctor_id,v.doctor_name,v.hospital_id,v.name,v.appointment_time,v.appointment_date,v.WardNo
from users u, appointments a, appointment_view v
where u.user_id=a.user_id and a.ref_id=v.ref_id;

 select * from users;
 select * from doctor;
 select * from appointment_view;
 select * from hospital;
 select * from appointment_room;
 select * from appointments;
 select * from payment;
 select * from card_details;

