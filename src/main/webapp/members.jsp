
<%@page import="com.user.registration.UserData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Assistant:wght@400;600&family=Inter:wght@600;700&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/7dbe0d5993.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="members.css">
<body>
	<div class="maindiv">

		<!--left side-->
		<div class="head1">
			<div class="image">
				<img src="signode.png" alt="">
			</div>
			<div class="options">
				<div class="opt">
					<img src="dashboard.png" alt="" height="20px" width="20px"
						style="padding-top: 5px;"><a href="loanpage1.html">Dashboard</a>
				</div>
				<div class="opt1" style="height: 40px;">
					<img src="us.png" alt="" height="20px" width="20px"
						style="padding-top: 5px;"><a href="ViewServlet">Members</a>
				</div>
				<div class="opt">
					<img src="loans.png" alt="" height="20px" width="20px"
						style="padding-top: 5px;"><a href="loans.html">Loans</a>
				</div>
				<div class="opt">
					<img src="payroll.png" alt="" height="20px" width="20px"
						style="padding-top: 5px;"> <a href="payroll.html">Payroll
						Reports</a>
				</div>
			</div>
		</div>
		<div class="head2">
			<div class="menu">
				<i class="fa-solid fa-bars"></i>
				<div class="admin">
					<select>
						<option value="logout">Satish Admin</option>
						<option value="login">Java</option>
					</select> <img src="banner.jpg" alt="no-img" height="50px" width="50px"
						style="border-radius: 50%;">
				</div>
			</div>
			<div class="members">

				<div class="h1">
					<h3 style="color: #232e50;">View Members</h3>
					<br>


					<table
					align="center" cellspacing="5px" cellpadding="50px"
						border="2" width="200%"; text-align="center";>
						
						<tr style="font-weight: bold; text-align: center; height: 100%;">
							<td>EmployeeId</td>
							<td >EmployeeName</td>
							<td>EmployeeFatherName</td>
							<td>DateOfJoining</td>
							<td >Caste</td>
							<td >ThriftDeposit</td>
							<td >Actions</td>
						</tr>
						<%
						List<UserData> users = (List<UserData>) request.getAttribute("users");
						// 						request.setAttribute("user", users);
						// 						request.getRequestDispatcher("update.jsp").include(request, response);
						%>
						<c:forEach items="${users}" var="user">
						
							<tr style="text-align: center;">
								<td>${user.employeeId}</td>
								<td >${user.employeeName}</td>
								<td >${user.employeeFatherName}</td>
								<td >${user.dateOfJoining}</td>
								<td >${user.caste }:${user.subCaste}</td>
								<td >${user.thriftDeposit}</td>
								<td><a
									href="update.jsp?employeeId=<c:out value='${user.employeeId}'/>"><button>Edit</button></a>
									&nbsp; &nbsp; &nbsp; <a
									href="DeleteServlet?employeeId=<c:out value='${user.employeeId}'/>"><button>Delete</button></a></td>
								<%--<a href="edit?id=<c:out value='${user.id}' />--%>
							</tr>
						</c:forEach>
					</table>


				</div>
				<div class="h2">
				<a href="addnew.html">
					<button class="btn" style="color: white;">
						<i class= "fa fa-user-plus" style='padding: 4px;' ></i>+AddNew
					</button>
				</a>
				</div>
				<div class="h2">
					<form action="SearchServlet" method="get">
						<input type="text" placeholder="Search" name="employeeId"
							class="search">&nbsp;
						<button class="bt" style='color: white;'>
							<i class="fa fa-search"></i>
						</button>

					</form>

				</div>
			</div>

		</div>
</body>

</html>