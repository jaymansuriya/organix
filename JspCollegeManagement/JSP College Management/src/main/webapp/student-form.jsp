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
				<c:if test="${student != null}">					
					<form action="update" method="get">
				</c:if>
				
				
				<c:if test="${student == null}">
					<form action="insert" method="post">
				</c:if>

		
					<h2>
						<c:if test="${student != null}">
            			Edit User
            		</c:if>
						<c:if test="${student == null}">
            			Add New User
            		</c:if>
					</h2>
			

				<c:if test="${student != null}">
					<input type="hidden" name="id" value="<c:out value='${student.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Student Name</label> <input type="text"
						value="<c:out value='${student.name}' />" class="form-control"
						name="sname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Student Roll no</label> <input type="number" min="1"
						value="<c:out value='${student.rollNo}' />" class="form-control"
						name="srno">
				</fieldset>

				<fieldset class="form-group">
					<label>Student Department</label> <input type="text"
						value="<c:out value='${student.department}' />" class="form-control"
						name="sdept">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Student Sem</label> <input type="number" min="1" max="8"
						value="<c:out value='${student.sem}' />" class="form-control"
						name="ssem">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
