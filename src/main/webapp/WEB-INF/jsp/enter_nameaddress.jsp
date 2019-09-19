<%@include file="header.jsp"%>
<link rel="stylesheet" href="style.css">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.11.2.js"></script>
<script src="js/bootstrap.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
	background-color: skyblue;
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

input {
	border-bottom-width: 5px;
}

td {
	padding-bottom: 10px;
	font-size: larger;
}

#tbl {
	border: 2px solid;
	padding: 10px 10px 10px 10px;
	background-color: #E8E8E8;
}

table {
	background-color: #E8E8E8;
	border: 2px solid;
	margin: 15px;
}

.btnsubmit1:hover {
	color: #FFFFF;
	background-color: #87CEFA;
}

.btnsubmit1 {
	padding-left: 13px;
	padding-right: 13px;
}

.search {
	color: #FFFFF;
	margin-left: 3px;
	margin-right: 3px;
}

a {
	color: #4169E1;
	text-decoration: none;
}

.host:hover {
	color: #4169E1;
	background-color: skyblue;
}

* {
	box-sizing: border-box;
}

.topnav {
	overflow: hidden;
	background-color: #e9e9e9;
}

.topnav a {
	float: left;
	display: block;
	color: black;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #2196F3;
	color: white;
}

.topnav .search-container {
	float: right;
}

.topnav input[type=text] {
	padding: 6px;
	margin-top: 8px;
	font-size: 17px;
	border: none;
}

.topnav .search-container button {
	float: right;
	padding: 6px 10px;
	margin-top: 8px;
	margin-right: 16px;
	background: #ddd;
	font-size: 17px;
	border: none;
	cursor: pointer;
}

.topnav .search-container button:hover {
	background: #ccc;
}

@media screen and (max-width: 600px) {
	.topnav .search-container {
		float: none;
	}
	.topnav a, .topnav input[type=text], .topnav .search-container button {
		float: none;
		display: block;
		text-align: left;
		width: 100%;
		margin: 0;
		padding: 14px;
	}
	.topnav input[type=text] {
		border: 1px solid #ccc;
	}
}

.f1 {
	padding-left: 7px;
}
</style>
</head>
<body>

	<div class="topnav">

		<form action="http://localhost:9021/HibernateTest/getEmpId" class="f1"
			method="post">
			Search Details: <input type="text" placeholder="Enter Employee Id..."
				value="${emp.id }" name="empId">
			<button type="submit" class="search">Submit</button>
		</form>
	</div>


	<div align="center">
		<form action="http://localhost:9021/HibernateTest/getDetails"
			method="post">
			<h2>Search Employee Id</h2>
			<table id="tbl">

				<tr>
					<td>Name:</td>
					<td><input type="text" name="name" placeholder="Enter name"
						required="required"></td>
				</tr>

				<tr>
					<td>Address:</td>
					<td><input type="text" name="address"
						placeholder="Enter address" required="required"></td>
				</tr>

				<tr>
				
					<td><input type="submit" class="btnsubmit1" value="Get Id" /></td>
					
				</tr>
			</table>

		</form>
	</div>
</body>
</html>