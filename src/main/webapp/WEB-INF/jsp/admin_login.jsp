<%@include file="header.jsp"%>

<style type="text/css">
table {
	border: 2px solid;
	align-self: center;
	padding: 8px;
	margin-top: 20%;
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
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">

		<form action="http://localhost:9021/HibernateTest/userPwd"
			method="post">
			<script type="text/javascript">
				var msg = "${error}"
				alert(msg);
			</script>
			<table id="table">
				<tr>
					<td>Admin User:</td>
					<td><input type="text" placeholder="Enter username"
						required="required" name="userName"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="text" placeholder="Enter password"
						required="required" name="password"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login" id="input"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>