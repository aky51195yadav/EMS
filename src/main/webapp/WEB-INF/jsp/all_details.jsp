<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
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

.topnav input[type=text] {
	float: right;
	padding: 6px;
	margin-top: 8px;
	margin-right: 16px;
	border: none;
	font-size: 17px;
}

@media screen and (max-width: 600px) {
	.topnav a, .topnav input[type=text] {
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

.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
	background-color: red;
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

label {
	color: white;
	text-align: right;
}

.lab {
	padding: 100px;
}

.frm {
	color: red;
	margin-top: 5px;
}

.cost {
	margin-top: 10px;
}

span {
	color: red;
}

.extable {
	margin-bottom: 10px;
}

.Sbutton:hover {
	color: #ffffff;
	background-color: MediumSeaGreen;
}

.Sbutton {
	margin-left: 5px;
	margin-right: 5px;
	padding-left: 5px;
	padding-right: 5px;
	margin-top: 10px;
}
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="topnav">

		<a class="active"
			href="http://localhost:9021/HibernateTest/adminLogout">Logout</a>
		<div class="dropdown">
			<button class="dropbtn">
				Optional<i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="http://localhost:9021/HibernateTest/getexpenses">Approve</a>
				<a href="http://localhost:9021/HibernateTest/disapprove">Disapprove</a>

			</div>
		</div>
		<div align="right">
			<form action="" class="frm">

				Total Amount : <input type="text" placeholder="Total Amount....."
					name="amount" id="field_results">
			</form>
		</div>
	</div>
	<div align="center">
		<h2>Employee Data</h2>
		<table style="width: 70%">
			<tr>
				<th>Employee Name</th>
				<th>Profile</th>
				<th>Salary</th>
				<th>Address</th>
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
				<td>${info.accountNo}</td>
				<td>${info.ifsc}</td>
				<td>${info.bankName}</td>
			</tr>
		</table>
	</div>
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


	<div align="center">
		<h2>Employee Expenses</h2>

		<table id="extable">
			<tr>
				<th>Approval</th>
				<th>Amount</th>
				<th>Description</th>
				<th>BillsImage</th>
				<th>Date</th>
				<th>Time</th>

			</tr>
			<form action="http://localhost:9021/HibernateTest/showpage"
				method="post">
				<c:forEach items="${expenses}" var="eex">
					<tr>

						<div class="checkbox">
							<td><input type="checkbox" value="${eex.amount}"
								name="addcheck" onClick="test(this);" /></td> ${amount}<br />
						</div>


						<td>${eex.amount}</td>
						<td>${eex.description}</td>
						<td><img src="getStudentPhoto/<c:out value='${eex.image}'/>"></td>
						<td>${eex.date}</td>
						<td>${eex.time}</td>

					</tr>
				</c:forEach>
		</table>
		<div></div>
		<input type="submit" value="Submit" id="input" class="Sbutton">
	</div>
	</from>
	</div>
	<script type="text/javascript">
		var total = 0;

		function test(item) {
			if (item.checked) {
				total += parseInt(item.value);
			} else {
				total -= parseInt(item.value);
			}
			//alert(total);
			//document.getElementById('total_cost').innerHTML = total + " /-";
			document.getElementById('field_results').value = total + " /-";
		}
	</script>
	<div align="center" class="cost">
		<form action="http://localhost:9021/HibernateTest/approve"
			method="get">
			<span id="total_cost"> </span>
		</form>
	</div>

</body>
</html>