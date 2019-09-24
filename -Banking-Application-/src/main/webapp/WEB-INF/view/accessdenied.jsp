
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>


<!DOCTYPE html>
<html>
<title> HELLO </title>
	<style type="text/css" >
		.error{color:Red;}
	</style>
<body>

Access Denied ${pageContext.request.userPrincipal.name}<br>

<h1>AccessDenied For You:${pageContext.request.userPrincipal.name}</h1>

	Return to: <a href="/welcome">welcome</a>page.


</body>
</html>