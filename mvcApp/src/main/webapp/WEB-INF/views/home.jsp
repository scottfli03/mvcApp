<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Buy a Fence</title>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
    <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>
	<div class="container">
		<h1>
			Submit form for more information.  
		</h1>
		<a href="admin">ADMIN</a>
		
		<P>  The time is ${serverTime}. You should buy a fence.</P>
		<form action="/mvcapp/home" method="post">
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">First Name</div><input type="text" class="form-control" id="form-cust txtFName" name="fName">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">Last Name</div><input type="text" class="form-control" id="form-cust txtLName" name="lName">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">Email</div><input type="text" class="form-control" id="form-cust txtEmail" name="email">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">Phone</div><input type="text" class="form-control" id="form-cust txtPhone" name="phone">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">Address line 1</div><input type="text" class="form-control" id="form-cust txtAddr1" name="addr1">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">Address line 2</div><input type="text" class="form-control" id="form-cust txtAddr2" name="addr2">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">City</div><input type="text" id="form-cust txtCity" class="form-control" name="city">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">State</div><input type="text" id="form-cust txtState" class="form-control" name="state">
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">Zip</div><input type="text" id="form-cust txtZip" class="form-control" name="zip">
				</div>
			</div>
			<button class="btn btn-primary">Submit</button>
		</form>
	</div>
	<div class="container"><br/>
	    <div class="alert alert-success">         
	        <strong>Success!</strong> It is working as we expected.
	    </div>
	</div>
	<script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
