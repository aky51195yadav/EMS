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
	margin-left: 30px;
}

td {
	padding-bottom: 10px;
	font-size: larger;
}

table {
	background-color: #E8E8E8;
	border: 2px solid;
	margin: 15px;
	padding: 10px 10px 10px 10px;
}

btnsubmit1 {
	padding: 5px 5px 5px 5px;
}

.btnsubmit1:hover {
	color: #FFFFF;
	background-color: #87CEFA;
}

.fa fa-search:hover {
	color: #FFFFF;
	background-color: #87CEFA;
}

a {
	color: #4169E1;
	text-decoration: none;
}

.host:hover {
	color: #4169E1;
	background-color: skyblue;
}
</style>
</head>
<body>
	<form action="http://localhost:9021/HibernateTest/getDiscription"
		method="post">
		<div align="center">
			<h3>Enter Description and Amount</h3>
			<table>
				<tr>
					<td><input type="hidden" value="${emp.id}" readonly="readonly"
						name="empId"></td>

				</tr>
				<tr>
					<td>Employee Name:</td>
					<td><input type="text" value="${emp.name}" readonly="readonly"
						name="name"></td>

				</tr>
				<tr>
					<td>Profile:</td>
					<td><input type="text" value="${emp.profile}"
						readonly="readonly" name="profile"></td>

				</tr>
				<tr>
					<td>Salary:</td>
					<td><input type="number" value="${emp.salary}"
						readonly="readonly" name="salary"></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><input type="text" value="${emp.address}"
						readonly="readonly" name="address"></td>

				</tr>
				<tr>
					<td>Bank:</td>
					<td><input type="text" value="${info.bankName}"
						readonly="readonly"></td>

				</tr>
				<tr>
					<td>Account Number:</td>
					<td><input type="number" value="${info.accountNo}"
						readonly="readonly"> <br>
				</tr>
				<tr>
					<td>IFSC-Code:</td>
					<td><input type="text" value="${info.ifsc}"
						readonly="readonly"></td>
				</tr>
				<tr>
					<td>Amount:</td>
					<td><input type="number" placeholder="Enter amount"
						name="amount"></td>
				</tr>
				<tr>
					<td>Description:</td>
					<td><textarea rows="4" cols="30" name="disc">Enter text here...</textarea></td>
				</tr>

				<tr>
					<td><input type="submit" class="btnsubmit1" value="Update"></td>
				</tr>
			</table>
		</div>

	</form>
</body>
</html>