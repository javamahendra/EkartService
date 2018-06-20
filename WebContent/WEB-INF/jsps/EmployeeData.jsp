<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Salary</th>
		</tr>
		<c:forEach items="${chinna}" var="emp">
			<tr>
				<td><c:out value="${emp.empId}"></c:out></td>
				<td><c:out value="${emp.empName}"></c:out></td>
				<td><c:out value="${emp.empSal}"></c:out></td>
				<td><a href='deleteEmp?empId=<c:out value="${emp.empId}"/>'>Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>