<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VendorRegpage</title>
<link rel="stylesheet" href="../css/venForm.css" />
<script type="text/javascript" src="../script/venForm.js"></script>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		$("#venId").change(function(){
			
			$.ajax({
				
				url:'checkvId',
				data:{"vId":$("#venId").val()},
			success:function(res1Text){
				$("#errvMsg").text(res1Text);
			}
			});
		});
$("#venMail").change(function(){
			
			$.ajax({
				
				url:'checkvEmail',
				data:{"vEmail":$("#venMail").val()},
			success:function(res2Text){
				$("#errEmailMsg").text(res2Text);
			}
			});
		});
	});
			
</script>
</head>
<body style="background-color: pink">
	<%@include file="master.jsp"%>

	<h1>
		<spring:message code="tittle" />
	</h1>
	<form action="insertVendor" method="post" enctype="multipart/form-data"
		name="venForm" onsubmit="return venValidation();">

		<pre>

<spring:message code="Id" />: <input type="text" name="venId" id="venId" /><span
				id="errvMsg" class="error"></span>

<spring:message code="Name" /> : <input type="text" name="venName" /><span
				id="errNameMsg" class="error"></span>

<spring:message code="Email" /> : <input type="text" name="venMail"
				id="venMail" /><span id="errEmailMsg" class="error"></span>

<spring:message code="Mobile" /> : <input type="text" name="mobile" />

<spring:message code="Address" /> :<textarea name="address"></textarea>

<spring:message code="Location" />: <select name="loc.locId">
<option value="-1">-select--</option>
<c:forEach items="${locListObj}" var="loc">
<option value="${loc.locId}">${loc.locName}</option>
</c:forEach>
</select><span id="errLocationMsg"></span>
<input type="file" name="fObj">
<input type="submit" value="Insert" />
</pre>
		${msg }<br> <a href="viewVendorData">view All Records</a>



	</form>
	<a href="?lang=en">English</a>
	<a href="?lang=hi">Hindi</a>
	<a href="?lang=te">Telugu</a>
</body>
</html>