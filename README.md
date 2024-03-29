# Automated Student Registration System

<img src="https://www.shutterstock.com/image-vector/vector-horizontal-banner-concept-learning-260nw-689761090.jpg">

### Problem Description :
<p> In an Educational Institute, every year technology training is conducted during the summer and winter seasons. Students are enrolled in different courses under different technology tracks like- Android, Java, JEE, PHP, Oracle, etc. This automated application help Institute to enroll students efficiently, create batches under a course, and allocates the students in a batch. </p>

### User of the System :
```
1) Administrator (Admin)
2) Students
```

### Roles for Administrator :
```
1. Add a new Course 
2. Update Fees of course
3. Delete a course from any Training session
0. Log Out from Admin Section
```

#### Roles for Students  :
```
1. Register himself in a course  
2. To update these details
3. Get all the courses
0. Log Out from Student Section
```
#### Explanation video link :
 <h3 align="center"><a href="https://drive.google.com/file/d/1iIdLZccGGYRsuusu9bvhrbZAcDJkF6c7/view?usp=sharing"><strong>Want to see live Explanation »</strong></a></h3>

<h5>The ER-Diagram is shown below :</h5>

![project er diagram](https://user-images.githubusercontent.com/107916214/204328509-5dd037d2-d10d-4c5d-8b7b-65bb296438c6.png)



//**************************************************My SQL Database Query*****************************************************************//

//***************************************************************Create Database Here***************************************************************************************//

mysql> create database Student_Management_System;

//***************************************************************Use Database Here***************************************************************************************//

mysql> use Student_management_system;

//***************************************************************Show All tables under the Database***************************************************************************************//
mysql> show tables;
//***************************************************************Make Admin table Here***************************************************************************************//
1) Admin Table : 

mysql> create table admin(
        AdminId int primary key auto_increment,
         AdminName varchar(30),
         AdminMobile varchar(12),
         AdminAddress varchar(30),
         AdminEmail varchar(40) not null unique,
         AdminPassword varchar(40) not null
     );

//***************************************************************check Admin table Here***************************************************************************************//

mysql> desc admin;
+---------------+-------------+------+-----+---------+----------------+
| Field         | Type        | Null | Key | Default | Extra          |
+---------------+-------------+------+-----+---------+----------------+
| AdminId       | int         | NO   | PRI | NULL    | auto_increment |
| AdminName     | varchar(30) | YES  |     | NULL    |                |
| AdminMobile   | varchar(12) | YES  |     | NULL    |                |
| AdminAddress  | varchar(30) | YES  |     | NULL    |                |
| AdminEmail    | varchar(40) | NO   | UNI | NULL    |                |
| AdminPassword | varchar(40) | NO   |     | NULL    |                |
+---------------+-------------+------+-----+---------+----------------+

//***************************************************************Hardcode for ragister Admin Here***************************************************************************************//

** Hard Code Value For Admin**

mysql> insert into admin (AdminId, AdminName, AdminMobile, AdminAddress, AdminEmail, AdminPassword) values
(1, "Admin1", "1234567890", "Latur", "a1@gmail.com", "admin1");

mysql> insert into admin (AdminId, AdminName, AdminMobile, AdminAddress, AdminEmail, AdminPassword) values
(2, "Alok", "9044414580", "Varanasi", "saelalok001@gmail.com", "!@2614@lok");


/************************************************************************Show Admin table Here***************************************************************************************//

mysql> select * from admin;
+---------+-----------+-------------+--------------+-----------------------+---------------+
| AdminId | AdminName | AdminMobile | AdminAddress | AdminEmail            | AdminPassword |
+---------+-----------+-------------+--------------+-----------------------+---------------+
|       1 | Admin1    | 1234567890  | Latur        | a1@gmail.com          | admin1        |
|       2 | Alok      | 9044414580  | Varanasi     | saelalok001@gmail.com | !@2614@lok    |
+---------+-----------+-------------+--------------+-----------------------+---------------+

/******************************************************************create student  table Here***************************************************************************************//

2) Student Table :

mysql> create table student(
        StudentRoll int primary key auto_increment,
         StudentName varchar(20) not null,
         StudentEmail varchar(40) unique,
         StudentPassword varchar(40) not null,
         StudentMobile varchar(12),
         StudentAddress varchar(50),
         StudentBatch varchar(50),
         StudentAdmissionDate varchar(15)
     );

/******************************************************************Show  student  table Here***************************************************************************************//

mysql> desc student;
+----------------------+-------------+------+-----+---------+----------------+
| Field                | Type        | Null | Key | Default | Extra          |
+----------------------+-------------+------+-----+---------+----------------+
| StudentRoll          | int         | NO   | PRI | NULL    | auto_increment |
| StudentName          | varchar(20) | NO   |     | NULL    |                |
| StudentEmail         | varchar(40) | YES  | UNI | NULL    |                |
| StudentPassword      | varchar(40) | NO   |     | NULL    |                |
| StudentMobile        | varchar(12) | YES  |     | NULL    |                |
| StudentAddress       | varchar(50) | YES  |     | NULL    |                |
| StudentBatch         | varchar(50) | YES  |     | NULL    |                |
| StudentAdmissionDate | varchar(15) | YES  |     | NULL    |                |
+----------------------+-------------+------+-----+---------+----------------+

/******************************************************************Create Course  table Here***************************************************************************************//

3) Course Table : 

mysql> create table course(
        CourseId int primary key auto_increment,
        CourseName varchar(12),
        CourseFee int not null,
        CourseDuration varchar(30) not null,
        CourseStart varchar(15) not null,
         TotalSeat  int ,
          AvilableSeat int
        );

/******************************************************************Show  Course desc  Here***************************************************************************************//

mysql> desc course;
+----------------+-------------+------+-----+---------+----------------+
| Field          | Type        | Null | Key | Default | Extra          |
+----------------+-------------+------+-----+---------+----------------+
| CourseId       | int         | NO   | PRI | NULL    | auto_increment |
| CourseName     | varchar(12) | YES  |     | NULL    |                |
| CourseFee      | int         | NO   |     | NULL    |                |
| CourseDuration | varchar(30) | NO   |     | NULL    |                |
| CourseStart    | varchar(15) | NO   |     | NULL    |                |
| TotalSeat      | int         | YES  |     | NULL    |                |
| AvilableSeat   | int         | YES  |     | NULL    |                |
+----------------+-------------+------+-----+---------+----------------+

/******************************************************Create Many to Many Relationships for Student, Course Table******************************************************//

4) Many to Many Relationship for Student, Course Table :

mysql> create table student_course(
        StudentRoll int,
        CourseId int,
         foreign key(CourseId) references course(CourseId),
         foreign key(StudentRoll) references student(StudentRoll)
     );

/**************************************************************************desc for  student_course****************************************************************************//


mysql> desc student_course;
+-------------+------+------+-----+---------+-------+
| Field       | Type | Null | Key | Default | Extra |
+-------------+------+------+-----+---------+-------+
| StudentRoll | int  | YES  | MUL | NULL    |       |
| CourseId    | int  | YES  | MUL | NULL    |       |
+-------------+------+------+-----+---------+-------+

