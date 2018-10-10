<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer service</title>
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
	<br/>
	<a href="/index.html">Back</a>	
</body>
</html>