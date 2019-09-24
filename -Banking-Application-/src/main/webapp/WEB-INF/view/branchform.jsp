<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
	<title> BRANCH FORM</title>
	
	</head>
	<body>
	<form:form action="savebranchform" method="post" modelAttribute="branch">
	<table>

	<tr><td> Branch Code <form:input path="bcode"/> </td>
	<td><form:errors path="bcode"/> </td></tr>
	
	<tr><td> Name <form:input path="name"/> </td>
	<td><form:errors path="name"/> </td></tr>
	
	<tr><td> Location <form:input path="location"/> </td>
	<td><form:errors path="location"/> </td></tr>
	
	
	
	<tr><td colspan=2><input type="submit" value="save"> </td></tr>
	</table>
	
	</form:form>
	
	
	</body>


</html>
