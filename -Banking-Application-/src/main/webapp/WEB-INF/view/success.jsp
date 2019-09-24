<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html>

<html>
	<head>
		<title>success page</title>
		<style type="text/css" >
			.error{color:red}
		</style>
	</head>
	<body>
	<h1>Logged as: ${pageContext.request.userPrincipal.name}</h1><br>
	<p>${contextPath}</p>
		<p>
			Welcome to ${pageContext.request.userPrincipal.name}
		</p>
	</body>
<!-- k -->
</html>