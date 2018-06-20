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
			<th>Items</th>
			<th>Model</th>
		</tr>
		<c:forEach items="${listTxObj}" var="tx">
			<tr>
				<td><c:out value="${tx.txId}"></c:out></td>
				<td><c:out value="${tx.txCustName}"></c:out></td>
				<td><c:out value="${tx.txCost}"></c:out></td>
				<td><c:out value="${tx.txItems}"></c:out></td>
				<td><c:out value="${tx.txModel}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>