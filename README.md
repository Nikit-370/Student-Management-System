# Student Management System

A full CRUD-based Student Management System developed using **Java JSP, Servlet, JDBC, and MySQL** following the **MVC Architecture**.

This project allows users to:
- Add Students
- View Student List
- Update Student Details
- Delete Students
- Truncate Entire Table

---

# 🚀 Technologies Used

- Java
- JSP (Java Server Pages)
- Servlet
- JDBC
- MySQL
- Apache Tomcat
- HTML5
- CSS3

---

# 📂 Project Structure

```bash
student-management-system/
│
├── src/main/java/
│   │
│   ├── controller/
│   │   └── StudentController.java
│   │
│   ├── dao/
│   │   └── StudentDAO.java
│   │
│   └── model/
│       └── Student.java
│
├── src/main/webapp/
│   │
│   ├── index.jsp
│   ├── list.jsp
│   └── edit.jsp
│
```

---

# 📌 Features

## ✅ Add Student
Users can add new student records.

## ✅ View Students
Displays all students from database in a responsive table.

## ✅ Edit Student
Update existing student details.

## ✅ Delete Student
Delete individual student records.

## ✅ Truncate Table
Delete all student records with confirmation.

## ✅ MVC Architecture
Project follows proper MVC design pattern:
- Model
- View
- Controller

---

# 🗄️ Database Configuration

## Database Name

```sql
curdapp
```

## Table Structure

```sql
CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    age INT,
    course VARCHAR(100)
);
```

---

# ⚙️ JDBC Configuration

Inside `StudentDAO.java`

```java
private String jdbcURL = "jdbc:mysql://localhost:3306/curdapp";
private String jdbcUsername = "root";
private String jdbcPassword = "";
```

Update these values according to your MySQL setup.

---

# ▶️ How to Run the Project

## 1️⃣ Clone Repository

```bash
git clone https://github.com/Nikit-370/student-management-system.git
```

---

## 2️⃣ Import Project

Import project into:
- Eclipse
- IntelliJ IDEA
- STS

---

## 3️⃣ Configure Tomcat Server

Add Apache Tomcat server in IDE.

Recommended:
- Tomcat 10+

---

## 4️⃣ Setup Database

Create MySQL database:

```sql
CREATE DATABASE curdapp;
```

Then create `students` table.

---

## 5️⃣ Add MySQL Connector

Add MySQL JDBC dependency.

If using Maven:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.0.33</version>
</dependency>
```

---

## 6️⃣ Run Project

Run project on Tomcat server.

Open:

```bash
http://localhost:8080/JDBCWithServletJSP/students
```

---

# 🧠 MVC Flow Explanation

## Controller
`StudentController.java`

Handles:
- HTTP requests
- Routing
- CRUD operations

---

## DAO
`StudentDAO.java`

Handles:
- Database connection
- SQL queries
- CRUD logic

---

## Model
`Student.java`

Represents Student entity.

Contains:
- Fields
- Constructors
- Getters & Setters

---

## View
JSP Files:
- `index.jsp`
- `list.jsp`
- `edit.jsp`

Used for frontend UI.

---

# 📖 CRUD Operations

| Operation | Description |
|---|---|
| Create | Add Student |
| Read | View Students |
| Update | Edit Student |
| Delete | Remove Student |

---

# 🌟 Future Improvements

- Authentication/Login
- Search Feature
- Pagination
- Bootstrap Integration
- REST API
- Validation
- Session Management
- Deployment Support

---

# Author

## Nikit Singh Kanyal

- MCA Student
- Java & DSA Learner
- Cloud & Software Enthusiast

GitHub:
[Nikit-370](https://github.com/Nikit-370)

---

---

# 📄 License

This project is open-source and free to use.
