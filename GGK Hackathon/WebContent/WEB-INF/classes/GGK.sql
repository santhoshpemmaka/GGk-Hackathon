create database GGK;
use GGK;


create table EmployeeTable( Name varchar(30), Gender varchar(10), Email varchar(30) primary key, phone varchar(10), password varchar(20),
							Algorithm_Code varchar(10), Login_Number varchar(5), Last_Login_Time varchar(30), Session varchar(10), Last_Logout_Time varchar(30));
select * from EmployeeTable;
drop table EmployeeTable;
truncate EmployeeTable;



create table AlgorithmTable( roll int auto_increment primary key, Algorithm_Name varchar(30), Algorithm_Type varchar(10),
							 Algorithm_Class varchar(50), Algorithm_Code varchar(10));
select * from AlgorithmTable;
drop table AlgorithmTable;
insert into AlgorithmTable values(roll,"sum Increment","numeric","com.GGK.Algorithm.algorithm","Aanum1"),
(roll,"Next character","character","com.GGK.Algorithm.algorithm","Aachar1"),
(roll,"Fibanocci","character","com.GGK.Algorithm.algorithm","Aachar2"),
(roll,"ASCII XOR","character","com.GGK.Algorithm.algorithm","Aachar3"),
(roll,"Prime","character","com.GGK.Algorithm.algorithm","Aachar4"),
(roll,"String Sum Key ","character","com.GGK.Algorithm.algorithm","Aachar5"),
(roll,"Octal","character","com.GGK.Algorithm.algorithm","Aachar6"),
(roll,"Fibanocci Type2","character","com.GGK.Algorithm.algorithm","Aachar7"),
(roll,"Character ASCII key","character","com.GGK.Algorithm.algorithm","Aachar8"),
(roll,"Constant Key","character","com.GGK.Algorithm.algorithm","Aachar9"),
(roll,"Hexa Decimal","character","com.GGK.Algorithm.algorithm","Aachar10"),
(roll,"Left Shift","character","com.GGK.Algorithm.algorithm","Aachar11");


create table BDNATable( roll int auto_increment primary key, Email varchar(30), Table1_data varchar(128), Table2_data varchar(64), 
						key_N varchar(20), FOREIGN KEY(Email) REFERENCES EmployeeTable(Email) );
select * from BDNATable;
drop table BDNATable;
truncate bdnatable;

drop database GGK;