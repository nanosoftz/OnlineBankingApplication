
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="csrf-param" content="authenticity_token" />
<meta name="csrf-token" content="Mn+ohv46xsr0GK3z/0d82DcWyT4jV22gaEpLHAJL4yOukhdLt/K5eHLdoBCF8gYPWyOrpPV8AvI1xxIVFcoO7Q==" />
	
	<title> ONLINE BANKING APPLICATION  </title>
		<style type="text/css" >
		.error{color:Red;}
		
		<style type="text/css" >
		.error{color:Red;}
		body{
	 background-image:url(https://s3.envato.com/files/243754334/primag.jpg);
	 background-repeat:no-repeat;
	 background-size:cover;
	 width:100%;
	 height:100vh;
	 overflow:auto;
	 
}

/*-----for border----*/
.container{
	font-family:Roboto,sans-serif;
	  background-image:url(https://image.freepik.com/free-vector/dark-blue-blurred-background_1034-589.jpg) ;
    
     border-style: 1px solid grey;
     margin: 0 auto;
     text-align: center;
     opacity: 0.8;
     margin-top: 67px;
   box-shadow: 2px 5px 5px 0px #eee;
     max-width: 500px;
     padding-top: 10px;
     height: 363px;
     margin-top: 166px;
}
/*--- for label of first and last name---*/
.lastname{
	 margin-left: 1px;
     font-family: sans-serif;
     font-size: 14px;
     color: white;
     margin-top: 10px;
}
.firstname{
	 margin-left: 1px;
     font-family: sans-serif;
     font-size: 14px;
     color: white;
     margin-top: 5px;
}
#lname{
	 margin-top:5px;
}
	  

/*---for heading-----*/
.heading{
	 text-decoration:bold;
	 text-align : center;
	 font-size:30px;
	 color:#F96;
	 padding-top:10px;
}
/*-------for email----------*/
  /*------label----*/
#email{
	  margin-top: 5px;
}
/*-----------for Password--------*/
     /*-------label-----*/
.mail{
	 margin-left: 44px;
     font-family: sans-serif;
     color: white;
     font-size: 14px;
     margin-top: 13px;
}
.pass{
	 color: white;
     margin-top: 9px;
     font-size: 14px;
     font-family: sans-serif;
     margin-left: 6px;
     margin-top: 9px;
}
#password{
 margin-top: 6px;
}
/*------------for phone Number--------*/
      /*----------label--------*/
.pno{
	 font-size: 18px;
     margin-left: -13px;
     margin-top: 10px;
     color: #ff9;
	
}	

/*--------------for Gender---------------*/
     /*--------------label---------*/
.gender {
	 color: white;
     font-family: sans-serif;
     font-size: 14px;
     margin-left: 28px;
     margin-top: 8px;
}

     /*---------- for Input type--------*/
.col-xs-4.male{
	 color: white;
     font-size: 13px;
     margin-top: 9px;
     padding-bottom: 16px;
}
.col-xs-4.female {
     color: white;
     font-size: 13px;
     margin-top: 9px;
     padding-bottom: 16px;
	 padding-right: 95px;
}	
/*------------For submit button---------*/
.sbutton{
	 color: white;
     font-size: 20px;
     border: 1px solid white;
     background-color: #080808;
     width: 32%;
     margin-left: 41%;
     margin-top: 16px;
	 box-shadow: 0px 2px 2px 0px white;
  	   
   }
.btn.btn-warning:hover {
    box-shadow: 2px 1px 2px 3px #99ccff;
	background:#5900a6;
	color:#fff;
	transition: background-color 1.15s ease-in-out,border-color 1.15s ease-in-out,box-shadow 1.15s ease-in-out;
	
}
	</style>
	
	 <link href='https://fonts.googleapis.com/css?family=Lato:300,400,400italic,700,700italic' rel='stylesheet'>

  <link rel="stylesheet" media="all" href="https://static.codepen.io/assets/global/global-94691e0a48b1a482d81ba3549897e8910ab024d9bece9f0a7a795844dd19c800.css" />
  <link rel="stylesheet" media="all" href="https://static.codepen.io/assets/page/page-808ec7d18fcd8e4d7d21706436188fb44f3e2504eb0f26bf31f51ebad1c17be7.css" />
  <link rel="stylesheet" media="screen" href="https://static.codepen.io/assets/accounts/signup-0392257e72e1eeafec509312c76e0cedb906322102c4355d6aaf2b04bc86d3fe.css" />
  <link rel="stylesheet" media="screen" href="https://static.codepen.io/assets/accounts/form-2309d503f58e7153d779ac00ee69f859b27af244e40f0886032e7a8b38ce5da8.css" />
  <link rel="shortcut icon" type="image/x-icon" href="https://static.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico" />
  <link rel="mask-icon" type="" href="https://static.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg" color="#111" />
	
	
	</head>
	<body>
	<form:form action="register" method="post" modelAttribute="user">
	<table>

	<tr><td> UserName: <form:input path="username"/> </td>
	<td colspan="5"><form:errors path="username" cssClass="error"/> </td></tr>
	
	<tr><td> Password: <form:input path="password"/> </td>
	<td><form:errors path="password"/> </td></tr>
	
	
	<tr>
	<td>Role:</td>
	<c:forEach var="role" items="${roles}">
	<td>  <form:checkbox path="roles" value="${role.id}" label="${role.name}"/> </td>
	<td><form:errors path="roles" cssClass="error"/> </td>	
	</c:forEach>
	</tr>
	
	<tr><td colspan=2><input type="submit" value="submit"> </td></tr>
	</table>
	<form:errors path="*" cssClass="error"></form:errors>
	</form:form >
	
	
	</body>


</html>