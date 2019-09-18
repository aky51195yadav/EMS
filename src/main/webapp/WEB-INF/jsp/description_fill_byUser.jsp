<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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

table {
	background-color: #E8E8E8;
	border: 2px solid;
	margin: 15px;
	padding: 10px 10px 10px 10px;
}

.btnsubmit1:hover {
	color: #FFFFF;
	background-color: #87CEFA;
}

tr {
	padding: 15px;
}

table {
	border: 2px solid;
	align-self: center;
	padding: 8px;
	margin-top: 20%;
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

.topnav a {
	float: right;
	display: block;
	color: black;
	text-align: center;
	padding: 12px 16px;
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

body {
	background-color: skyblue;
	font-family: Arial, Helvetica, sans-serif;
}

input {
	margin-left: 5px;
	margin-right: 5px;
	padding-left: 5px;
	padding-right: 5px;
}

.topnav {
	overflow: hidden;
	background-color: #e9e9e9;
}

body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
	background-color: skyblue;
}
</style>
</head>

<div class="topnav">

	<a class="active" href="http://localhost:9021/HibernateTest/logout">Logout</a>

</div>
<form action="http://localhost:9021/HibernateTest/getDescription"
	method="post" enctype="multipart/form-data">
	<div align="center">
		<h3>Enter Description and Amount</h3>
		<table>
			<tr>
				<td>Employee Name:</td>
				<td><input type="text" value="${emp.name}" readonly="readonly"
					name="name"></td>
			</tr>
			<tr>
				<td><input type="hidden" value="${emp.address}"></td>
			</tr>
			<tr>
				<td>Amount:</td>
				<td><input type="number" placeholder="Enter amount"
					name="amount"></td>
			</tr>
			<tr>
				<td>Image:</td>
				<td><input type="file" name="file"></td>
			</tr>
			<tr>
				<td>Date:</td>
				<td><input type="date" name="date"></td>
			</tr>
			<tr>
				<td>Time:</td>
				<td><input type="time" name="time"></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><textarea rows="4" cols="30" name="desc">Enter text here...</textarea></td>
			</tr>

			<tr>
				<td><input type="hidden" value="${emp.id}" name="empId"></td>
			</tr>

			<tr>
				<td><input type="hidden" value="${emp.profile}"></td>
			</tr>
			<tr>
				<td><input type="hidden" value="${emp.salary}"></td>
			</tr>
			<tr>
				<td><input type="hidden" value="${info.bankName}"></td>
			</tr>
			<tr>

				<td><input type="hidden" value="${info.accountNo}"> <br>
			</tr>
			<tr>
				<td><input type="hidden" value="${info.ifsc}"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Update"></td>
			</tr>
		</table>
	</div>

</form>
</body>
</html>