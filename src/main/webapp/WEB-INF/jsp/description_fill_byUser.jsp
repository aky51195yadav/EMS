<%@include file="header.jsp"%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.sidenav {
	height: 100%; /* Full-height: remove this if you want "auto" height */
	width: 200px; /* Set the width of the sidebar */
	position: fixed; /* Fixed Sidebar (stay in place on scroll) */
	z-index: 1; /* Stay on top */
	top: 0; /* Stay at the top */
	left: 0;
	background-color: #111; /* Black */
	overflow-x: hidden; /* Disable horizontal scroll */
	padding-top: 20px;
}

/* The navigation menu links */
.sidenav a {
	padding: 6px 8px 6px 16px;
	text-decoration: none;
	font-size: 25px;
	color: white;
	display: block;
}

/* When you mouse over the navigation links, change their color */
.sidenav a:hover {
	color: blue;
}

/* Style page content */
.main {
	margin-left: 160px; /* Same as the width of the sidebar */
	padding: 0px 10px;
}

/* On smaller screens, where height is less than 450px, change the style of the sidebar (less padding and a smaller font size) */
@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
	.sidenav a {
		font-size: 18px;
	}
}

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
<body>

	<div class="sidenav">
		<a href="http://localhost:9021/HibernateTest/onlyName">Profile</a><a
			href="">Images</a> <a href="">Amount</a> <a href="">Delete</a> <a
			href="">Update</a><a
			href="http://localhost:9021/HibernateTest/logout">Logout</a>
	</div>

	<!-- Page content -->
	<div class="main"></div>

	<form action="http://localhost:9021/HibernateTest/getDescription"
		method="post" enctype="multipart/form-data">
		<div align="center">
			Welcome ${emp.name}
			<h3>Enter Description and Amount</h3>
			<table>
				<tr>
					<td><input type="hidden" value="${emp.id}" readonly="readonly"
						name="empId"></td>
				</tr>

				<tr>
					<td><input type="hidden" value="${emp.name}"
						readonly="readonly" name="name"></td>
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