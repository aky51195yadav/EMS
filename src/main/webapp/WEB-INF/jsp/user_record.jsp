<%@include file="header.jsp"%>
<style type="text/css">
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
	background-color: skyblue;
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
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		Welcome ${sessionScope.empId}
		<h3>Enter Description and Amount</h3>
		<table>
			<tr>
				<th>Expenses Id</th>
				<th>Description</th>
				<th>Amount</th>
				<th>Bill:</th>
				<th>Date</th>
				<th>Time</th>
				<th>Action</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${list}" var="l">
				<tr>
					<td>${l.expId}</td>
					<td>${l.description}</td>
					<td>${l.amount}</td>
					<td><img src="${l.image}" alt="Bill"></td>
					<td>${l.date}</td>
					<td>${l.time}</td>
					<td>
						<form action="http://localhost:9021/HibernateTest/recordToDelete"
							method="post">

							<input type="hidden" value="${l.expId}" name="expId"> <input
								type="submit" value="Delete">
						</form>

					</td>
					<td>
						<form action="http://localhost:9021/HibernateTest/recordToDelete"
							method="post">

							<input type="hidden" value="${l.expId}" name="expId"> <input
								type="text" value="${l.description}" name="desc"> <input
								type="hidden" value="${l.amount}" name="amount"> <input
								type="hidden" value="${l.image}" name="image"> <input
								type="hidden" value="${l.date}" name="date"> <input
								type="hidden" value="${l.time}" name="time"> <input
								type="submit" value="Update">
						</form>

					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>