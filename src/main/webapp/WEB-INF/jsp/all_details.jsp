<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	border-bottom-color: slyblue;
}

a {
	text-decoration: none;
	color: blue;
	font-size: large;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
}

body {
	margin: 0;
	border-bottom-color: slyblue;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: left;
	color: #f2f2f2;
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
	background-color: #4CAF50;
	color: white;
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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="topnav">

		<a class="active"
			href="http://localhost:9021/HibernateTest/adminLogout">Logout</a>
	</div>
	<div align="center">
		<h2>Employee Data</h2>
		<table style="width: 70%">
			<tr>
				<th>Employee Name</th>
				<th>Profile</th>
				<th>Salary</th>
				<th>Address</th>
				<th>Amount</th>
				<th>Description</th>
				<th>BillsImage</th>
				<th>Date</th>
				<th>Time</th>
				<th>AccountNo</th>
				<th>IFSCCode</th>
				<th>BankName</th>

				<%-- <th>Action</th>
				<th>Action</th>--%>
			</tr>

			<tr>
				<td>${emp.name}</td>
				<td>${emp.profile}</td>
				<td>${emp.salary}</td>
				<td>${emp.address}</td>




				<td>${eex.amount}</td>
				<td>${eex.description}</td>
				<td>${eex.image}</td>
				<td>${eex.date}</td>
				<td>${eex.time}</td>


				<td>${info.accountNo}</td>
				<td>${info.ifsc}</td>
				<td>${info.bankName}</td>
			</tr>
			<%-- <td>
						<form action="http://localhost:9021/HibernateTest/recordsToUpdate"
							method="post">
							<input type="hidden" value="${list.id}" name="empId"> <input
								type="hidden" value="${list.name}" name="empName"> <input
								type="hidden" value="${list.profile}" name="profile"> <input
								type="hidden" value="${list.salary}" name="salary"> <input
								type="hidden" value="${list.address}" name="address"> <input
								type="submit" value="Edit Record" style="margin-left: 20px">
						</form>
					</td>

					<td>
						<form action="http://localhost:9021/HibernateTest/fetchIdToDelete"
							method="post">
							<input type="hidden" value="${list.id}" name="empId"> <input
								type="hidden" value="${list.name}" name="empName"> <input
								type="hidden" value="${list.profile}" name="profile"> <input
								type="hidden" value="${list.salary}" name="salary"> <input
								type="hidden" value="${list.address}" name="address"> <input
								type="submit" value="Delete Record" style="margin-left: 20px">
						</form>
					</td>--%>


		</table>
	</div>
</body>
</html>