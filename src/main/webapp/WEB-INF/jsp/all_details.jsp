<%@include file="header.jsp"%>
<style>
a {
	text-decoration: none;
	color: blue;
	font-size: large;
}

table {
	border: 2px solid;
	border-collapse: collapse;
}

th {
	border: 1px solid;
	padding-right: 25px;
	padding-top: 10px;
	text-align: center;
	background-color: windowframe;
}

td {
	border: 1px solid;
	padding-right: 25px;
	padding-top: 10px;
	text-align: center;
	background-color: silver;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>Employee Details</h2>
		<table>
			<tr>
				<th>Employee Name</th>
				<th>Profile</th>
				<th>Salary</th>
				<th>Address</th>
				<th>Action</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${empList}" var="empList">
				<tr>
					<td>${empList.name}</td>
					<td>${empList.profile}</td>
					<td>${empList.salary}</td>
					<td>${empList.address}</td>
					<td>
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
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div align="center">
		<h2>Save More Records</h2>
		<a href="http://localhost:9021/HibernateTest/form"><i>Click
				Here</i></a>
	</div>
</body>
</html>