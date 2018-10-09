<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Add customer</h3>
	<form modelAttribute="customer" method="post">
		First Name: <input name="firstName" value="${customer.firstName}"}/><br/>
		Last Name: <input name="lastName" value="${customer.lastName}"/><br/>
		Age: <input name="age" value="${customer.age}"/><br/>
		<input type="submit"/>
	</form>
	<label style="color: red; white-space: pre-wrap">${errorMessage}</label>
</body>
</html>