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
		<h1>Welcome to Customer DataEdit Page</h1>
		<form action="updateCustomer" method="post">
			<pre>
Id      :<input type="text" name="custId" readonly="readonly"
					value="${custObj.custId}" /><br>
Name    :<input type="text" name="custName" value="${custObj.custName}" /><br>
Mail    :<input type="text" name="custEmail"
					value="${custObj.custEmail}" /><br>
Type    :<select name="custType">
<option>-select-</option>
<c:choose>
<c:when test="${custObj.custType eq 'Seller' }">
<option selected="selected">Seller</option>
<option>Consumer</option>
</c:when>
<c:otherwise>
<option selected="selected">Consumer</option>
<option>Seller</option>
</c:otherwise>
</c:choose>

<option></option>
</select><br>
Address  :<textarea name="custAddr">${custObj.custAddr}</textarea>
				<br>
Password :<input type="password" name="password"
					value="${custObj.password}" /><br>
Token    :<input type="text" name="accTock" value="${custObj.accTock}" /><br>
Location :<select name="loc.locId">
<option value="-1">-select-</option>
<c:forEach items="${locListObj}" var="loc">
<c:choose>
<c:when test="${custObj.loc.locId eq loc.locId}">
<option value="${loc.locId}" selected="selected">${loc.locName}</option>
</c:when>
<c:otherwise>
<option value="${loc.locId}">${loc.locName}</option>
</c:otherwise>
</c:choose>
</c:forEach>
</select>
<input type="submit" value="update">
</pre>
		</form>

	</center>

</body>
</html>