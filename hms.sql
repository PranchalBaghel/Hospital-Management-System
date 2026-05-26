create database hospital_db;
use hospital_db;

create table department(id int auto_increment primary key , 
name varchar(50) not null);

create table patient(id int auto_increment primary key , 
name varchar(50) not null , 
age int not null ,
 disease varchar(100),
 created_at timestamp default current_timestamp);

create table doctor(id int primary key auto_increment , 
name varchar(50) not null , 
specialist varchar(100),dept_id int , 
foreign key (dept_id) references department(id) on delete cascade);

create table appointment(id int primary key auto_increment , 
appointment_date date not null ,
 appointment_time time not null , 
patient_id int not null , 
doctor_id int not null , 
foreign key (patient_id) references patient(id) on delete cascade , 
foreign key (doctor_id) references doctor(id) on delete cascade);

create table bill(id int primary key auto_increment ,
 patient_id int ,
 appointment_id int ,
 amount decimal(10,2) not null , 
 foreign key (patient_id) references patient(id) on delete cascade , 
 is_paid boolean default false , 
 foreign key (appointment_id) references appointment (id) on delete cascade);
 
-- doctor workload report

select d.id, d.name , d.specialist , count(a.id) as total_appointments
from doctor d left join appointment a on d.id = a.doctor_id group by d.id, d.name , d.specialist;

-- patient visit history 

select p.id as Patient_Id ,  p.name as Patient_Name , d.name as Doctor_Name  , a.appointment_date , a.appointment_time from appointment a join patient p on a.patient_id = p.id join doctor d on a.doctor_id = d.id;