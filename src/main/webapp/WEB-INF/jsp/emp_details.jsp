<%@include file="header.jsp"%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
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

body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
	background-color: skyblue;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	background-color: white;
}

th {
	padding: 8px 8px 8px 8px;
	background-color: gray;
	color: white;
}

td {
	padding: 5px 5px 5px 5px;
	text-align: center;
}

h2 {
	text-decoration: none;
}

.active {
	padding-top: 1px;
}
</style>
</head>
<body>
	<div class="topnav">

		<a class="active" href="http://localhost:9021/HibernateTest/home">Home</a>

	</div>
	<div align="center">
		<h2>Employee Details</h2>
		<table style="width: 70%">
			<tr>
				<th>Employee Name</th>
				<th>Designation</th>
				<th>Salary</th>
				<th>Bank Name</th>
				<th>Account Number</th>
				<th>IFSC-Code</th>
				<th>Action</th>
			</tr>
			<tr>
				<td>${emp.name}</td>
				<td>${emp.profile}</td>
				<td>${emp.salary}</td>
				<td>${info.bankName}</td>
				<td>${info.accountNo}</td>
				<td>${info.ifsc}</td>
				<td>
					<form action="http://localhost:9021/HibernateTest/empId"
						method="post">
						<input type="hidden" value="${emp.id}" name="empId"> <input
							type="submit" value="Edit Details">
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>