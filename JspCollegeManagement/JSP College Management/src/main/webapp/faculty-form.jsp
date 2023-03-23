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
				<a href="" class="navbar-brand"> College Management Application </a>
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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${faculty != null}">					
					<form action="updateFaculty" method="get">
				</c:if>
				
				
				<c:if test="${faculty == null}">
					<form action="insertFaculty" method="post">
				</c:if>

		
					<h2>
						<c:if test="${faculty != null}">
            			Edit Faculty
            		</c:if>
						<c:if test="${faculty == null}">
            			Add New Faculty
            		</c:if>
					</h2>
			

				<c:if test="${faculty != null}">
					<input type="hidden" name="id" value="<c:out value='${faculty.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Faculty Name</label> <input type="text"
						value="<c:out value='${faculty.name}' />" class="form-control"
						name="fname" required="required">
				</fieldset>


				<fieldset class="form-group">
					<label>Faculty Department</label> <input type="text"
						value="<c:out value='${faculty.department}' />" class="form-control"
						name="fdept">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Faculty Salary</label> <input type="number"
						value="<c:out value='${faculty.salary}' />" class="form-control"
						name="fsalary">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
