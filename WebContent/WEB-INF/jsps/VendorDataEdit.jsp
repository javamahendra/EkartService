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
		<h1>welcome to Vendor EditPage</h1>
		<form action="updateVendor" method="post">

			<pre>

Id      : <input type="text" name="venId" value="${venObj.venId}"
					readonly="readonly" />

Name    : <input type="text" name="venName" value="${venObj.venName}" />

Email   : <input type="text" name="venMail" value="${venObj.venMail}" />

Mobile  : <input type="text" name="mobile" value="${venObj.mobile}" />

Address :<textarea name="address">${venObj.address}</textarea>

Location: <select name="loc.locId">
<option value="-1">-select--</option>
<c:forEach items="${locListObj}" var="loc">
<c:choose>
<c:when test="${venObj.loc.locId eq loc.locId}">
<option value="${loc.locId}" selected="selected">${loc.locName}</option>
</c:when>
<c:otherwise>
<option value="${loc.locId}">${loc.locName}</option>
</c:otherwise>
</c:choose>
</c:forEach>
</select>

<input type="submit" value="update" />
</pre>

			<a href="ViewVendorData">view All Records</a>



		</form>
	</center>
</body>
</html>