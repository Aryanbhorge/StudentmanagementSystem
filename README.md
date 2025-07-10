# StudentmanagementSystem
Java Maven PostgreSQL JDBC

The Student Management System is a console-based application built using Core Java, JDBC, and PostgreSQL. It allows users to perform CRUD (Create, Read, Update, Delete) operations on Student records stored in a PostgreSQL database. The application is menu-driven, providing a simple and intuitive interface for managing Student data.

Features
Add Student: Add a new Student record to the database.
Update Students: Update an existing Student's details (e.g., ID, Rollno, age, marks).
Delete Student: Delete an Student record by ID.
Menu-Driven Interface: Easy-to-use console-based menu for seamless navigation.
Use Collectios For retrive all Student list.
Technologies Used
Core Java: For implementing the application logic and OOPs concepts.
JDBC (Java Database Connectivity): For connecting to and interacting with the PostgreSQL database.
PostgreSQL: For storing and managing student data.
Maven: For project dependency management and building the project.
Dependencies
The project uses the following dependencies:

PostgreSQL JDBC Driver: For connecting to the PostgreSQL database.
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.6.0</version>
</dependency>
Prerequisites
Before running the project, ensure you have the following installed:

Java Development Kit (JDK) 17 or higher.
Apache Maven 3.8.6 or higher.
PostgreSQL 15 or higher.
create PostgreSQL database with the following table:
CREATE TABLE studentsdetails (
    id SERIAL PRIMARY KEY,
    Rollno int NOT NULL,
    age INT NOT NULL,
    ,marks int not null
);
Contact
For any questions or feedback, feel free to reach out:

Your Name : Aryan Bhorge
Email: bhorgearyan@gmail.com
GitHub: Aryanbhorge
Team Member:
Name:Gaurav Hingole
Email:gavravhingole@gmail.com
GitHub:Gaurav_Hingole
Enjoy using the Student Management System! 🚀
