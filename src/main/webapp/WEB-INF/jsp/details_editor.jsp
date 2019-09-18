<%@include file="header.jsp"%>
<style>
input {
	border-bottom-width: 5px;
}

td {
	padding-bottom: 10px;
	font-size: larger;
}

#tbl {
	border: 2px solid;
	padding: 20px 20px 20px 20px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>Update Employee Details</h2>
		<form action="http://localhost:9021/HibernateTest/fetchUpdatedRecord"
			method="post">
			<table id="tbl">
				<tr>
					<td><input type="hidden" value="${employee.id}" name="id" /></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input type="text" value="${employee.name}" name="name" /></td>
				</tr>

				<tr>
					<td>Designation:</td>
					<td><input type="text" value="${employee.profile} "
						name="profile" /></td>
				</tr>

				<tr>
					<td>Salary:</td>
					<td><input type="number" value="${employee.salary}"
						name="salary" /></td>
				</tr>

				<tr>
					<td>Address:</td>
					<td><input type="text" value="${employee.address}"
						name="address" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Update"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>