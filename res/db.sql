drop database if exists university;
create database if not exists university;
use university;

drop table enrollment;
drop table student;
drop table course;

create table student(
id int unique auto_increment primary key,
name char(20),
birth date,
address char(30));

create table course(
id int unique auto_increment primary key,
name char(30),
teacher char(20),
year int);

create table enrollment(
id int unique auto_increment primary key,
student_id int,
course_id int,
foreign key(student_id) references student(id),
foreign key(course_id) references course(id)
);

insert into student(name,birth,address) values
('Marry','1995-02-28','1st December St., no. 17'),
('Anna','1994-11-08','Philadelphia St., no 20'),
('Dan','1995-01-28','Roses St., no. 25'),
('Harvey','1992-08-29','Subway St., no. 10'),
('Hannah','1994-12-03','21 December St., no. 12'),
('Edward','1994-02-03','21 December St., no. 13'),
('Nate','1996-03-11','1st December St., no. 20'),
('Blake','1994-09-20','Philadelphia St., no. 02');

insert into course(name,teacher,year) values
('Software Design','M. Dinsoreanu',3),
('Programming Techniques','I. Salomie',2),
('Software Engineering','E. Todoran',3),
('Object Oriented Programming','A. Vatavu',2),
('Functional programming','L. Negrescu',3);

insert into enrollment(student_id,course_id) values
(1,1),
(1,3),
(1,5),
(2,5),
(3,5),
(7,2),
(7,4);
