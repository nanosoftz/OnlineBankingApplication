<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
	<title>CREATE LOAN FORM</title>
	<style type="text/css" >
		.error{color:Red;}
	</style>

	</head>
	<body>
	<form:form action="/saveloanform" method="post" modelAttribute="loan">
	<table>

	<tr><td> Loan Id <form:input path="loanid"/> </td>
	<td><form:errors path="loanid" cssClass="error"/> </td></tr>
	
	<tr><td> Amount <form:input path="amount"/> </td>
	<td><form:errors path="amount"/> </td></tr>
	
	<tr><td> Branch code <form:input path="bcode"/> </td>
	<td><form:errors path="bcode" cssClass="error" /> </td></tr>
	

	
	<tr><td> Loan Date <form:input   path="loandate"/> </td>
	<td><form:errors path="loandate" cssClass="error" /> </td></tr>
	
	<tr><td> Loan Type <form:input path=""/> </td>
	<td><form:errors path="loanType" cssClass="error"/> 
	
	<select name="loanType">
	<option>Car Loan</option>
	<option>Education Loan</option>
	<option>Home loan</option>
	</select>
	</td></tr>
	
	<tr><td> Customer Id<form:input path="customer"/> </td>
	<td><form:errors path="customer" cssClass="error"/> </td></tr>
	

	
	<tr><td colspan=2><input type="submit" value="save"> </td></tr>
	</table>
	<form:errors path="*" cssClass="error"></form:errors>
	</form:form >
	
	
	</body>


</html>
