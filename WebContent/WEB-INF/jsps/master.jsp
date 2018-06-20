<!DOCTYPE html>
<html>
<head>
<style>
.container {
	overflow: hidden;
	background-color: #333;
	font-family: Arial;
}

.container a {
	float: left;
	font-size: 16px;
	color: White;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: black;
	padding: 14px 16px;
	background-color: inherit;
}

.container a:hover,.dropdown:hover .dropbtn {
	background-color: blue;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}
</style>
</head>
<body background="../images/background.png">
	<!-- <img src="../images/chinna.jpg" width="550" height="100"> -->
	<div class="container">

		<!--  <a href="#news">News</a> -->
		<div class="dropdown">
			<button class="dropbtn">Location</button>
			<div class="dropdown-content">
				<a href="LocReg">Register</a> <a href="ShowLocs">View Data</a>
			</div>
		</div>

		<div class="dropdown">
			<button class="dropbtn">Vendor</button>
			<div class="dropdown-content">
				<a href="venReg">Register</a> <a href="viewVendorData">View Data</a>
			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn">Customer</button>
			<div class="dropdown-content">
				<a href="custReg">Register</a> <a href="viewCustomerData">View
					Data</a>
			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn">Report</button>
			<div class="dropdown-content">
				<a href="viewLocReport">Location Report</a> <a href="customerChart">Customer
					Report</a> <a href="vendorChart">Vendor Report</a>
			</div>
		</div>
		<div class="dropdown">
			<button class="dropbtn">Document</button>
			<div class="dropdown-content">

				<a href="showDocs">Show Documents</a>

			</div>
		</div>
	</div>
</body>
</html>
