<%@ page import="java.util.List"%>
<%@ page import="model.Student"%>

<%
List<Student> listStudent = (List<Student>) request.getAttribute("listStudent");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap"
	rel="stylesheet">

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Poppins', sans-serif;
}

body {
	background: #f4f7fc;
	padding: 40px;
}

.container {
	max-width: 1000px;
	margin: auto;
	background: white;
	padding: 30px;
	border-radius: 20px;
	box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
}

.top-bar {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 25px;
}

h2 {
	color: #333;
}

.add-btn {
	padding: 12px 20px;
	background: #4CAF50;
	color: white;
	text-decoration: none;
	border-radius: 10px;
	transition: 0.3s;
}

.add-btn:hover {
	background: #43a047;
}

table {
	width: 100%;
	border-collapse: collapse;
}

table th {
	background: #667eea;
	color: white;
	padding: 15px;
}

table td {
	padding: 15px;
	border-bottom: 1px solid #eee;
	text-align: center;
}

tr:hover {
	background: #f9f9f9;
}

.edit-btn, .delete-btn {
	padding: 8px 14px;
	border-radius: 8px;
	text-decoration: none;
	color: white;
	font-size: 14px;
}

.edit-btn {
	background: #2196f3;
}

.delete-btn {
	background: #f44336;
}

.edit-btn:hover {
	background: #1976d2;
}

.delete-btn:hover {
	background: #d32f2f;
}

.truncate-btn {
	padding: 12px 20px;
	background: #ff5722;
	color: white;
	text-decoration: none;
	border-radius: 10px;
	transition: 0.3s;
}

.truncate-btn:hover {
	background: #e64a19;
}
</style>
</head>

<body>

	<div class="container">

		<div style="display: flex; gap: 10px;">

			<a class="add-btn" href="students?action=new"> + Add Student </a> <a
				class="truncate-btn" href="students?action=truncate"
				onclick="return confirm('WARNING: Delete ALL student records?')">
				Truncate Table </a>

		</div>

		<table>

			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Age</th>
				<th>Course</th>
				<th>Actions</th>
			</tr>

			<%
			if (listStudent != null) {
				for (Student student : listStudent) {
			%>

			<tr>
				<td><%=student.getId()%></td>
				<td><%=student.getName()%></td>
				<td><%=student.getAge()%></td>
				<td><%=student.getCourse()%></td>
				<td><a class="edit-btn"
					href="students?action=edit&id=<%=student.getId()%>"> Edit </a> <a
					class="delete-btn"
					href="students?action=delete&id=<%=student.getId()%>"
					onclick="return confirm('Delete this student?')"> Delete </a></td>
			</tr>
			<%
			}
			}
			%>
		</table>
	</div>
</body>
</html>