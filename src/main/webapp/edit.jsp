<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Student"%>

<%
Student student = (Student) request.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">

<style>

*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Poppins', sans-serif;
}

body{
    height:100vh;
    display:flex;
    justify-content:center;
    align-items:center;
    background:linear-gradient(135deg,#667eea,#764ba2);
}

.container{
    width:420px;
    background:white;
    padding:35px;
    border-radius:20px;
    box-shadow:0 10px 30px rgba(0,0,0,0.2);
}

h2{
    text-align:center;
    margin-bottom:25px;
    color:#333;
}

.form-group{
    margin-bottom:20px;
}

label{
    display:block;
    margin-bottom:8px;
    color:#444;
    font-weight:500;
}

input{
    width:100%;
    padding:12px;
    border:1px solid #ccc;
    border-radius:10px;
    outline:none;
    font-size:15px;
}

input:focus{
    border-color:#667eea;
    box-shadow:0 0 6px rgba(102,126,234,0.4);
}

button{
    width:100%;
    padding:12px;
    border:none;
    border-radius:10px;
    background:#667eea;
    color:white;
    font-size:16px;
    cursor:pointer;
}

button:hover{
    background:#5a67d8;
}

.back-link{
    display:block;
    text-align:center;
    margin-top:18px;
    text-decoration:none;
    color:#555;
}

</style>
</head>

<body>

<div class="container">

    <h2>Edit Student</h2>

    <form action="students?action=update" method="post">

        <input type="hidden"
               name="id"
               value="<%=student.getId()%>">

        <div class="form-group">

            <label for="name">Name</label>

            <input type="text"
                   id="name"
                   name="name"
                   value="<%=student.getName()%>"
                   required>

        </div>

        <div class="form-group">

            <label for="age">Age</label>

            <input type="number"
                   id="age"
                   name="age"
                   value="<%=student.getAge()%>"
                   required>

        </div>

        <div class="form-group">

            <label for="course">Course</label>

            <input type="text"
                   id="course"
                   name="course"
                   value="<%=student.getCourse()%>"
                   required>

        </div>

        <button type="submit">
            Update Student
        </button>

    </form>

    <a class="back-link" href="students">
        ← Back to Student List
    </a>

</div>

</body>
</html>