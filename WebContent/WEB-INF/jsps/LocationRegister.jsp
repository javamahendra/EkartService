
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LocationRegister</title>
<link rel="stylesheet" href="../css/locForm.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script type="text/javascript" src="../script/locForm.js"></script>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="../script/angular.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#locId").change(function() {

			$.ajax({

				url : 'checkId',
				data : {
					"lId" : $("#locId").val()
				},
				success : function(resText) {
					$("#errMsg").text(resText);
				}
			});

		});

	});
</script>
</head>
<body>
	<%@include file="master.jsp"%>

	<h1>LocationRegister</h1>
	<form action="InsertLoc" method="post" name="locForm"
		onsubmit="return locValidate();">

		<pre>

Id            :<input type="text" name="locId" id="locId" /><span
				id="errMsg" class="error"></span><br>
Name          :<input type="text" name="locName" /><span
				id="errNameMsg" class="error"></span><br>

Type          :<input type="radio" value="Urban" name="locType"
				class="error">urban<input type="radio" value="Rural"
				name="locType">rural<input type="radio" value="Semi-Urban"
				name="locType">semi-rural<input type="radio"
				value="Semi-Rural" name="locType">semi-urban<span
				id="errLocTypeMsg" class="error"></span><br>
PinCode       :<input type="text" name="pinCode" /><br>
Shipping Types:<select name="shippingTypes">
<option>-select-</option>
<option>Air</option>
<option>Road</option>
<option>Sea</option>
</select><br>
ContactDetails:<input type="text" name="contactDetails" /><br>
ProcessCode   :<input type="text" name="processpCode" /><br>
<input type="submit" value="submit" />

</pre>

	</form>
	${msg}
	<br>

	<a href="ShowLocs">View All Records</a>

</body>
</html>