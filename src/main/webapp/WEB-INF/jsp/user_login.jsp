<%@include file="header.jsp"%>

<style type="text/css">
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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="topnav">

		<a class="active" href="http://localhost:9021/HibernateTest/userPwd">Sign
			Up</a>

	</div>
	<script type="text/javascript">
		var msg = "${error}"
		console.log(msg);
	</script>
	<div align="center">

		<form action="http://localhost:9021/HibernateTest/userPwd"
			method="post">

			<table id="table">

				<tr>
					<td>User Name:</td>
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