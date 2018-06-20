<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VendordataPage</title>
</head>
<body>
	<%@include file="master.jsp"%>
	<center>
		<a href="vendorExcel"><img alt="" src="../images/excel.jpg"
			height="50" width="150"></a> <a href="vendorPdf"><img alt=""
			src="../images/pdf.jpg" height="50" width="150"></a>
		<h1>Vendor Data Page</h1>
		<table border=1>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Address</th>
				<th>Location</th>
				<th>Type</th>
			</tr>
			<c:forEach items="${venListObj}" var="ven">
				<tr>
					<td><c:out value="${ven.venId}" /></td>
					<td><c:out value="${ven.venName}" /></td>
					<td><c:out value="${ven.venMail}" /></td>
					<td><c:out value="${ven.mobile}" /></td>
					<td><c:out value="${ven.address}" /></td>
					<td><c:out value="${ven.loc.locName}" /></td>
					<td><c:out value="${ven.loc.locType}" /></td>
					<td><a href='deleteVen?venId=<c:out value="${ven.venId}"/>'><img
							src="../images/delete.png" height="30" width="30"></a></td>
					<td><a href='editVen?venId=<c:out value="${ven.venId }"/>'><img
							src="../images/edit.png" height="30" width="30"></a></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>