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
	<%@include file="master.jsp"%>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Cost</th>
		</tr>
		<c:forEach items="${listItemObj}" var="item">
			<tr>
				<td><c:out value="${item.itemId}"></c:out></td>
				<td><c:out value="${item.itemName}"></c:out></td>
				<td><c:out value="${item.itemCost}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>