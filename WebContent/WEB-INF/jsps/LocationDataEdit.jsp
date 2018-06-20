<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: pink">
	<%@include file="master.jsp"%>
	<h1>LocationEditPage</h1>
	<form action="UpdateLoc" method="post">

		<pre>

id                :<input type="text" name="locId"
				value="${locObj.locId}" readonly="readonly" /><br>
name              :<input type="text" name="locName"
				value="${locObj.locName}" /><br>

<c:if test="${locObj.locType eq 'Urban'}">
type :<input type="radio" value="Urban" name="locType" checked="checked">urban<input
					type="radio" value="Rural" name="locType">rural<input
					type="radio" value="Semi-Rural" name="locType">semi-rural<input
					type="radio" value="Semi-Urban" name="locType">semi-Urban
</c:if>
<c:if test="${locObj.locType eq 'Semi-Urban'}">
type :<input type="radio" value="Urban" name="locType">urban<input
					type="radio" value="Rural" name="locType">rural<input
					type="radio" value="Semi-Rural" name="locType">semi-rural<input
					type="radio" value="Semi-Urban" name="locType" checked="checked">semi-Urban
</c:if>
<c:if test="${locObj.locType eq 'Rural'}">
type :<input type="radio" value="Urban" name="locType" checked="checked">urban<input
					type="radio" value="Rural" name="locType">rural<input
					type="radio" value="Semi-Rural" name="locType">semi-rural<input
					type="radio" value="Semi-Urban" name="locType">semi-Urban
</c:if>
<c:if test="${locObj.locType eq 'Semi-Rural'}">
type  :<input type="radio" value="Urban" name="locType"
					checked="checked">urban<input type="radio" value="Rural"
					name="locType">rural<input type="radio" value="Semi-Rural"
					name="locType">semi-rural<input type="radio"
					value="Semi-Urban" name="locType" checked="checked">semi-Urban
</c:if>
PinCode           :<input type="text" name="pinCode"
				value="${locObj.pinCode}" /><br>

ContactDetails    :<input type="text" name="contactDetails"
				value="${locObj.contactDetails}" /><br>
ProcessCode       :<input type="text" name="processpCode"
				value="${locObj.processpCode}" /><br>
Shipping Types    :<select name="shippingTypes">
<option>-select-</option>
<c:choose>
<c:when test="${locObj.shippingTypes eq 'Air'}">
<option selected="selected">Air</option>
<option>Road</option>
<option>Sea</option>
</c:when>
</c:choose>
<c:choose>
<c:when test="${locObj.shippingTypes eq 'Road'}">
<option>Air</option>
<option selected="selected">Road</option>
<option>Sea</option>
</c:when>
</c:choose>
<c:choose>
<c:when test="${locObj.shippingTypes eq 'Sea'}">
<option>Air</option>
<option>Road</option>
<option selected="selected">Sea</option>
</c:when>
<c:otherwise>
<option>Air</option>
<option>Road</option>
<option>Sea</option>
</c:otherwise>
</c:choose>

</select>

<input type="submit" value="Update" />

</pre>

	</form>

</body>
</html>