<%@include file="header.jsp"%>

<style type="text/css">
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
		<h2>Total Employee Details</h2>
		<form action="">
			<table>

				<tr>
					<th>Expenses Type</th>
					<th>Total Bills</th>
					<th>Total Amount</th>
					<th>Action</th>
				</tr>


				<tr>
					<td>${empCal.expenseFood}</td>
					<td>${empCal.noOfFoodBill}</td>
					<td>${empCal.totalFoodAmount}</td>

				</tr>

				<tr>
					<td>${empCal.expenseFood}</td>
					<td>${empCal.noOfFoodBill}</td>
					<td>${empCal.totalFoodAmount}</td>

				</tr>

				<tr>
					<td>${empCal.expenseFood}</td>
					<td>${empCal.noOfFoodBill}</td>
					<td>${empCal.totalFoodAmount}</td>

				</tr>

			</table>

		</form>
	</div>
</body>
</html>