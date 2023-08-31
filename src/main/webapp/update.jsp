
<%@page import="com.user.registration.UserData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UpdateServlet" method="post">
		<table>
			

				<tr>
					<td>Employee ID</td>
					<td><input type="text" name="employeeId"
						placeholder="Enter Employee Name"></td>
					<%-- value="<%=users.get(0).getEmployeeId() %>" --%>
				</tr>
				<tr>
					<td>Caste</td>
					<td><input type="text" name="caste" placeholder="Enter Caste"></td>
				</tr>
				<tr>
					<td>Date Of Joining</td>
					<td><input type="date" name="dateOfJoining"></td>
				</tr>
				<tr>
					<td>Employee Name</td>
					<td><input type="text" name="employeeName"
						placeholder="Enter Employee Name"></td>
				</tr>
				<tr>
					<td>Sub Caste</td>
					<td><input type="text" name="subCaste"></td>
				</tr>
				<tr>
					<td>Employee Father Name</td>
					<td><input type="text" name="employeeFatherName"
						placeholder="Enter FatherName"></td>
				</tr>
				<tr>
					<td>Thrift Desposit</td>
					<td><input type="number" name="thriftDeposit"
						placeholder="Enter ThriftDeposit Amount"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit"></td>
				</tr>
		</table>

	</form>
</body>
</html>