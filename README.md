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
4. Search for information about a course
5. Create a Batch under a course
6. Add a student to a batch
7. View all the students
8. View the students of every batch
9. View all the course details
```

#### Roles for Students  :
```
1. Register himself in a course  
2. To update these details
3. Get all the courses
```
#### Explanation video link :
 <h3 align="center"><a href="https://drive.google.com/file/d/1iIdLZccGGYRsuusu9bvhrbZAcDJkF6c7/view?usp=sharing"><strong>Want to see live Explanation »</strong></a></h3>

<!-- <h5>The ER-Diagram is shown below :</h5>

![project er diagram]("https://www.shutterstock.com/image-illustration/sql-code-on-dark-background-word-1897996366") -->

<img src="https://www.shutterstock.com/image-photo/close-photo-computer-screen-sql-structured-2169190253">

//**************************************************My SQL Database Query*****************************************************************//

//***************************************************************Create Database Here***************************************************************************************//

mysql> create database Student_Management_System;
Query OK, 1 row affected (0.03 sec)

//***************************************************************Use Database Here***************************************************************************************//

mysql> use Student_management_system;
Database changed

//***************************************************************Show All tables under the Database***************************************************************************************//
mysql> show tables;
Empty set (0.02 sec)


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
Query OK, 0 rows affected (0.18 sec)

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
6 rows in set (0.01 sec)

//***************************************************************Hardcode for ragister Admin Here***************************************************************************************//

** Hard Code Value For Admin**

mysql> insert into admin (AdminId, AdminName, AdminMobile, AdminAddress, AdminEmail, AdminPassword) values
(1, "Admin1", "1234567890", "Latur", "a1@gmail.com", "admin1");
Query OK, 1 row affected (0.03 sec)

mysql> insert into admin (AdminId, AdminName, AdminMobile, AdminAddress, AdminEmail, AdminPassword) values
(2, "Alok", "9044414580", "Varanasi", "saelalok001@gmail.com", "!@2614@lok");
Query OK, 1 row affected (0.03 sec)


/************************************************************************Show Admin table Here***************************************************************************************//

mysql> select * from admin;
+---------+-----------+-------------+--------------+-----------------------+---------------+
| AdminId | AdminName | AdminMobile | AdminAddress | AdminEmail            | AdminPassword |
+---------+-----------+-------------+--------------+-----------------------+---------------+
|       1 | Admin1    | 1234567890  | Latur        | a1@gmail.com          | admin1        |
|       2 | Alok      | 9044414580  | Varanasi     | saelalok001@gmail.com | !@2614@lok    |
+---------+-----------+-------------+--------------+-----------------------+---------------+
2 rows in set (0.01 sec)

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
Query OK, 0 rows affected (0.03 sec)

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
8 rows in set (0.00 sec)

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
Query OK, 0 rows affected (0.02 sec)

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
7 rows in set (0.00 sec)

/******************************************************Create Many to Many Relationships for Student, Course Table******************************************************//



4) Many to Many Relationship for Student, Course Table :

mysql> create table student_course(
        StudentRoll int,
        CourseId int,
         foreign key(CourseId) references course(CourseId),
         foreign key(StudentRoll) references student(StudentRoll)
     );
Query OK, 0 rows affected (0.04 sec)

/**************************************************************************desc for  student_course****************************************************************************//


mysql> desc student_course;
+-------------+------+------+-----+---------+-------+
| Field       | Type | Null | Key | Default | Extra |
+-------------+------+------+-----+---------+-------+
| StudentRoll | int  | YES  | MUL | NULL    |       |
| CourseId    | int  | YES  | MUL | NULL    |       |
+-------------+------+------+-----+---------+-------+
2 rows in set (0.00 sec)

