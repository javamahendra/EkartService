<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Registration Page</title>
<script type="text/javascript" src="../script/custForm.js"></script>
<link rel="stylesheet" href="../css/custForm.css" />
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){

	
	$("#custId").change(function(){
		
		$.ajax({
		url:'checkCustId',
		data:{"cId":$("#custId").val()},
		success:function(resText){
			$("#errIdMsg").text(resText);
		}		
		});
		
		
		
	});
$("#custEmail").change(function(){
		
		$.ajax({
		url:'checkCustEmail',
		data:{"cEmail":$("#custEmail").val()},
		success:function(resText){
			$("#errEmailMsg").text(resText);
		}		
		});
		
		
		
	});
});



</script>
</head>

<body>
	<%@include file="master.jsp"%>

	<h1>Welcome to Customer Registration Page</h1>
	<form action="insertCustomer" method="post"
		onsubmit="return custValidation();" name="custForm">
		<pre>
<span id="errMainMsg" class="error"></span>
Id      :<input type="text" name="custId" id="custId" /><span
				id="errIdMsg" class="error"></span>
Name    :<input type="text" name="custName" /><span id="errNameMsg"
				class="error"></span>
Mail    :<input type="text" name="custEmail" id="custEmail" /><span
				id="errEmailMsg" class="error"></span>
Type    :<select name="custType">
<option>-select-</option>
<option>Seller</option>
<option>Consumer</option>
</select><span id="errTypeMsg"></span>
<br>
Address  :<textarea name="custAddr"></textarea>
			<br>
<!-- Password :<input type="password" name="password"/><br>
Token    :<input type="text" name="accTock"/><br> -->
Location :<select name="loc.locId">
<option value="-1">-select-</option>
<c:forEach items="${locUtilObj}" var="loc">
<option value="${loc.locId}">${loc.locName}</option>
</c:forEach>
</select><span id="errLocMsg"></span>

<input type="submit" value="Insert" />
</pre>
	</form>
	${msg}


</body>
</html>