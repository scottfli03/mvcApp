<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Buy a Fence</title>
</head>
<body>
<h1>
	Won't you buy a fence?  
</h1>
<a href="admin">ADMIN</a>

<P>  The time is ${serverTime}. You should buy a fence.</P>
<form action="/mvcapp/home" method="post">
	<label>First Name : </label><input type="text" id="txtName" name="fName">
	<label>Last Name : </label><input type="text" id="txtName" name="lName">
	<label>Email : </label><input type="text" id="txtName" name="email">
	<label>Phone : </label><input type="text" id="txtName" name="phone">
	<label>Address line 1 : </label><input type="text" id="txtName" name="addr1">
	<label>Address line 2 : </label><input type="text" id="txtName" name="addr2">
	<label>City : </label><input type="text" id="txtName" name="city">
	<label>State : </label><input type="text" id="txtName" name="state">
	<label>Zip : </label><input type="text" id="txtName" name="zip"> 
	<button>Submit</button>
</form>
</body>
</html>
