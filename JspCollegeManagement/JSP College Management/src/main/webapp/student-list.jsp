<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>College Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: black">
			<div>
				<a href="" class="navbar-brand"> College Management Application
				</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Students</a></li>
					
				<li><a href="<%=request.getContextPath()%>/listFaculty"
					class="nav-link">Faculty</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Students</h3>
			<hr>

			<div class="row">


				<a href="<%=request.getContextPath()%>/new"
					class="btn btn-success mr-3">Add New User</a> <a
					href="<%=request.getContextPath()%>/newFaculty" class="btn btn-success">Add
					New Faculty</a>
			</div>

			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Student Roll No</th>
						<th>Name</th>
						<th>Department</th>
						<th>Semester</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="student" items="${listStudent}">
						<tr>
							<td><c:out value="${student.rollNo}" /></td>
							<td><c:out value="${student.name}" /></td>
							<td><c:out value="${student.department}" /></td>
							<td><c:out value="${student.sem}" /></td>
							<td><a href="edit?id=<c:out value='${student.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${student.id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->


				</tbody>
			

			</table>



			
		</div>
	</div>
</body>
</html>
