<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer service</title>
</head>
<body>
	<h3>All customers</h3>
	<table>
		<thead><tr><th>First Name</th><th>Last Name</th><th>Age</th></tr></thead>
		<tbody>
			<c:forEach items="${customers}" var="customer">
				<tr><td>${customer.firstName}</td><td>${customer.lastName}</td><td>${customer.age}</td></tr>
			</c:forEach>
		</tbody>
	</table>
	<br/>
	<a href="/index.html">Back</a>
</body>
</html>