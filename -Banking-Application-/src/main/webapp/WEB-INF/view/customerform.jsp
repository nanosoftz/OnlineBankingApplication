<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
	<title>CUSTOMER ENTRY</title>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
		<style type="text/css" >
		.error{color:Red;}
		url(https://fonts.googleapis.com/css?family=Roboto:300);

.login-page {
  width: 360px;
  padding: 8% 0 0;
  margin: auto;
}
.form {
  position: relative;
  z-index: 1;
  background: #FFFFFF;
  max-width: 360px;
  margin: 0 auto 100px;
  padding: 45px;
  text-align: center;
  box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
}
.form input {
  font-family: "Roboto", sans-serif;
  outline: 0;
  background: #f2f2f2;
  width: 100%;
  border: 0;
  margin: 0 0 15px;
  padding: 15px;
  box-sizing: border-box;
  font-size: 14px;
}
.form button {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background: #4CAF50;
  width: 100%;
  border: 0;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}
.form button:hover,.form button:active,.form button:focus {
  background: #43A047;
}
.form .message {
  margin: 15px 0 0;
  color: #b3b3b3;
  font-size: 12px;
}
.form .message a {
  color: #4CAF50;
  text-decoration: none;
}
.form .register-form {
  display: none;
}
.container {
  position: relative;
  z-index: 1;
  max-width: 300px;
  margin: 0 auto;
}
.container:before, .container:after {
  content: "";
  display: block;
  clear: both;
}
.container .info {
  margin: 50px auto;
  text-align: center;
}
.container .info h1 {
  margin: 0 0 15px;
  padding: 0;
  font-size: 36px;
  font-weight: 300;
  color: #1a1a1a;
}
.container .info span {
  color: #4d4d4d;
  font-size: 12px;
}
.container .info span a {
  color: #000000;
  text-decoration: none;
}
.container .info span .fa {
  color: #EF3B3A;
}
body {
  background: #76b852; /* fallback for old browsers */
  background: -webkit-linear-gradient(right, #76b852, #8DC26F);
  background: -moz-linear-gradient(right, #76b852, #8DC26F);
  background: -o-linear-gradient(right, #76b852, #8DC26F);
  background: linear-gradient(to left, #76b852, #8DC26F);
  font-family: "Roboto", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;      
}
	</style>

	</head>
	<body>
	<form:form action="savecustomer" method="post" modelAttribute="customer">
	<table>

	<tr><td>Customer Id<form:input path="customerid"/> </td>
	<td><form:errors path="customerid" cssClass="error"/> </td></tr>
	
	<tr><td>Passport Id <form:input path="passportid"/> </td>
	<td><form:errors path="passportid"/> </td></tr>
	
	<tr><td>Customer First Name<form:input path="customerfname"/> </td>
	<td><form:errors path="customerfname" cssClass="error" /> </td></tr>
	

	
	<tr><td> Customer Last Name <form:input   path="customerlname"/> </td>
	<td><form:errors path="customerlname" cssClass="error" /> </td></tr>
	
	<tr><td> Gender <form:input path="gender"/> </td>
	<td><form:errors path="gender" cssClass="error"/> </td></tr>
	
	<tr><td> DateofBirth <form:input   path="dob"/> </td>
	<td><form:errors path="dob" cssClass="error" /> </td></tr>
	
	<tr><td> Mobile <form:input path="mobile" /> </td>
	<td><form:errors path="mobile" cssClass="error" /> </td></tr>
	
		<tr><td> Email <form:input path="email" /> </td>
	<td><form:errors path="email" cssClass="error" /> </td></tr>
	
	<tr><td> Account Details <form:input path="account" /> </td>
	<td><form:errors path="account" cssClass="error" /> </td></tr>
	
	
	<tr><td colspan=2><input type="submit" value="save"> </td></tr>
	</table>
	<form:errors path="*" cssClass="error"></form:errors>
	</form:form >
	
	
	</body>


</html>
