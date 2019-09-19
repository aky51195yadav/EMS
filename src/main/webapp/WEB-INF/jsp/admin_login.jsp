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

body {
	margin: 0;
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
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="topnav">

		<a class="active" href="http://localhost:9021/HibernateTest/home1">Home</a>
	</div>
	<div align="center">

		<form action="http://localhost:9021/HibernateTest/detailsAdminById"
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
					<td><input type="password" placeholder="Enter password"
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