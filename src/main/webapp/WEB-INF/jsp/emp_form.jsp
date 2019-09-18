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

a {
	text-decoration: none;
	color: blue;
	font-size: large;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>${message}</h3>
	</div>
	<br />
	<div align="center">
		<form action="http://localhost:9021/HibernateTest/save" method="post"
			enctype="multipart/form-data">
			<h2>New Employee Details</h2>
			<table id="tbl">

				<tr>
					<td>Name:</td>
					<td><input type="text" name="name" required="required"
						placeholder="Enter name"></td>
				</tr>
				<tr>
					<td>Profile:</td>
					<td><input type="text" name="profile" required="required"
						placeholder="Enter profile"></td>
				</tr>
				<tr>
					<td>Salary:</td>
					<td><input type="number" name="salary" required="required"
						placeholder="Enter salary"></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><input type="text" name="address" required="required"
						placeholder="Enter address"></td>
				</tr>


				<tr>
					<td>Account No:</td>
					<td><input type="number" name="accountNo" required="required"
						placeholder="Enter account no"></td>
				</tr>

				<tr>
					<td>IFSC Code:</td>
					<td><input type="text" name="ifsc" required="required"
						placeholder="Enter Ifsc code"></td>
				</tr>

				<tr>
					<td>Bank Name:</td>
					<td><input type="text" name="bankName" required="required"
						placeholder="Enter bank name"></td>
				</tr>
				<tr>
					<td>Bill:</td>
					<td><input type="file" name="image"></td>
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
					<td>Amount:</td>
					<td><input type="text" name="amount" required="required"
						placeholder="Enter amount"></td>
				</tr>

				<tr>
					<td>User Name:</td>
					<td><input type="text" name="userName" required="required"
						placeholder="Enter user name"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="pwd" required="required"
						placeholder="Enter password"></td>
				</tr>

				<tr>
					<td><input type="submit" value="Save Details" /></td>
			</table>

		</form>
	</div>

	<div align="center">
		<h2>To get All Employees</h2>
		<a href="http://localhost:9021/HibernateTest/showAll"><i>Click
				Here</i></a>
	</div>

</body>
</html>