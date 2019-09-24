<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
	<title>CREATE ROLE</title>
		<style type="text/css" >
		.error{color:Red;}
	</style>
	
	</head>
	<body> 
	
	<form:form action="saverole" method="post" modelAttribute="role">
	<table>

	<tr><td> ID <form:input path="id"/> </td>
	<td><form:errors path="id" cssClass="error"/> </td></tr>
	
	<tr><td> Name <form:input path="name"/> </td>
	<td><form:errors path="name"/> </td></tr>
	
	<tr><td colspan=2><input type="submit" value="save"> </td></tr>
	</table>
	<form:errors path="*" cssClass="error"></form:errors>
	</form:form >
	
	
	</body>


</html>
