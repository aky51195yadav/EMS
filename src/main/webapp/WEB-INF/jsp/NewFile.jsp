<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
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
body {
	background-color: rgba(255, 99, 71, 0.4);
	margin: 0;
}
</style>
</head>
<body>

	<div class="topnav">

		<a class="active"
			href="http://localhost:9021/HibernateTest/amountpageto_homepahe">Home</a>
	</div>
	<div align="center">
		<table>
			<tr>
				<th><h2>Total Amount</h2></th>
			</tr>
			<tr>
				<th>
					<%
						float total = 0;
						String[] exp = request.getParameterValues("addcheck");
						if (exp != null) {

							for (int i = 0; i < exp.length; i++) {

								total += Float.parseFloat(exp[i]);
							}
							out.println(total + " /-");

						}
					%>
				</th>
			</tr>
		</table>
		<h3>your amount is approve</h3>
	</div>
</body>
</html>
