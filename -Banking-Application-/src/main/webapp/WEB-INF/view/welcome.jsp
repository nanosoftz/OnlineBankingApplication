<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>


<!DOCTYPE html>
<html>
<head>


<title> WELCOME FORM </title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style type="text/css" >
		.error{color:Red;}
		.navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
    
  .carousel-inner img {
      width: 100%; /* Set width to 100% */
      margin: auto;
      min-height:200px;
  }

  /* Hide the carousel text when the screen is less than 600 pixels wide */
  @media (max-width: 600px) {
    .carousel-caption {
      display: none; 
    }
  }

</style>
	
	</head>
<body>


Welcome to ${pageContext.request.userPrincipal.name}<br>

<h1>Logged as:${pageContext.request.userPrincipal.name}</h1>

<security:authorize access="hasAuthority('Admin')">
<div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/createaccount"> CREATE ACCOUNT</a><br></li>
</ul>
      
    </div>

</security:authorize>


    
    
<security:authorize access="hasAuthority('DBA')">
<a href="/dbaForm"> DBA FORM-ONLY FOR DBA ROLE</a><br>
</security:authorize>


<security:authorize access="hasAuthority('HR')">
<a href="/hrForm"> HR FORM-ONLY FOR HR ROLE</a><br>
</security:authorize>


<security:authorize access="hasRole('ROLE_USER')">

<div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/depositform"> DEPOSIT AMOUNT</a><br></li>
         <li class="active"> <a href="/withdrawform"> WITHDRAW FORM</a><br></li>
          <li class="active">  <a href="/transamt"> TRANSFER AMOUNT</a><br></li>
           <li class="active"><a href="/customerform"> CUSTOMER FORM</a><br></li>
           <li class="active">  <a href="/loanform"> LOAN FORM</a><br><br></li>
           <li class="active">  <a href="/login?logout"> LOGOUT</a><br><br></li>
          </ul>
           <ul class="nav navbar-nav navbar-right">
        <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li></ul>
           
      </div>


</security:authorize>

<security:authorize access="hasAuthority('Manager')">
  <div class="w3-col s3">
<a href="/managerform"> MANAGER FORM ONLY FOR MANAGERS</a><br></div>

</security:authorize>

<!-- 
      <ul class="nav navbar-nav navbar-right">
        <li class="active"><a href="/login?logout"> LOGOUT</a></li></ul> -->

  

</body>


</html>