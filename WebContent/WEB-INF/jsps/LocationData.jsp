<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LocationData</title>
</head>
<body style="background-color: pink">
	<%@include file="master.jsp"%>
	<center>
		<a href="locExcel"><img alt="" src="../images/excel.jpg"
			height="50" width="150"></a> <a href="locPdf"><img alt=""
			src="../images/pdf.jpg" height="50" width="150"></a>
		<h1>Welcome to LocationData Page</h1>
		<table border=1>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>type</th>
				<th>STypes</th>
				<th>ConDetails</th>
				<th>ProCode</th>
				<th>date</th>
			</tr>
			<c:forEach items="${listObj}" var="loc">
				<tr>
					<td><c:out value="${loc.locId}" /></td>
					<td><c:out value="${loc.locName}" /></td>
					<td><c:out value="${loc.locType}" /></td>
					<td><c:out value="${loc.shippingTypes}" /></td>
					<td><c:out value="${loc.contactDetails}" /></td>

					<td><c:out value="${loc.processpCode}" /></td>
					<td><c:out value="${loc.d}" /></td>
					<td><a style="color: black"
						href='DeleteLoc?locId=<c:out value="${loc.locId}"/>'><img
							src="../images/delete.png" height="30" width="30"></a></td>
					<td><a style="color: black"
						href='EditLoc?locId=<c:out value="${loc.locId}"/>'><img
							src="../images/edit.png" height="30" width="30"></a></td>
				</tr>

			</c:forEach>
		</table>

	</center>
	${msg}
</body>
</html>