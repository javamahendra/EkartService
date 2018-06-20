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
	<center>
		<a href="customerExcel"><img alt="" src="../images/excel.jpg"
			height="50" width="150"></a> <a href="customerPdf"><img alt=""
			src="../images/pdf.jpg" height="50" width="150"></a>
		<h1>Welcome to Customer data Page</h1>
		<table border="1">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Type</th>


			</tr>
			<c:forEach items="${custObj}" var="cust">
				<tr>
					<td><c:out value="${cust.custId}"></c:out></td>
					<td><c:out value="${cust.custName}"></c:out></td>
					<td><c:out value="${cust.custType}"></c:out></td>
					<c:choose>
						<c:when test="${cust.custType eq 'Seller'}">
							<td><a
								href="showItems?custId=<c:out value='${cust.custId}'/>">view
									Items</a></td>
						</c:when>
						<c:otherwise>
							<td><a href="showTranxs?custId='${cust.custId}'">view
									Transactions</a></td>
						</c:otherwise>
					</c:choose>
					<td><a
						href="deleteCustomer?custId=<c:out value='${cust.custId}'/>"><img
							src="../images/delete.png" height="30" width="30" /></a></td>
					<td><a
						href="editCustomer?custId=<c:out value='${cust.custId}'/>"><img
							src="../images/edit.png" height="30" width="30" /></a></td>

				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>