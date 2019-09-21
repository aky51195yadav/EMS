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

table {
	float: left;
	margin: 7px;
}

div {
	
}

input {
	margin: 0px 10px 0px 10px;
	padding: 0px 15px 0px 15px;
}

body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: #333;
}

h3 {
	color: white;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center" class="topnav">

		<h3>Employee Management System</h3>

	</div>
	<div align="center">
		<form action="http://localhost:9021/HibernateTest/user">
			<table id="tbl">
				<tr>
					<td><input type="submit" value="User"></td>
				</tr>
			</table>
		</form>


		<form action="http://localhost:9021/HibernateTest/admin">

			<table>
				<tr>
					<td><input type="submit" value="Admin"></td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>