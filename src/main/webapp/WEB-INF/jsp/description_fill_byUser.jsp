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
</style>
</head>
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