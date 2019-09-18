<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
	<form action="http://localhost:9021/HibernateTest/getDiscription"
		method="post">
		<div align="center">
			<h3>Enter Details</h3>
			<table>
				<tr>
					<td>Employee Name:</td>
					<td><input type="text" required="required" name="name"></td>

				</tr>
				<tr>
					<td>User Name:</td>
					<td><input type="text" value="${emp.address}"
						readonly="readonly" name="address"></td>

				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" value="${info.bankName}"
						readonly="readonly"></td>
				<tr>
					<td><input type="submit" class="btnsubmit1" value="Submit"></td>
				</tr>
			</table>
		</div>

	</form>
</body>
</html>