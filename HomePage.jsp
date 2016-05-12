<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

table.registration {
    border-collapse: collapse;
    width: 100%;
    
}

table.registration th{
    height: 50px;
background-color:#86acac;
color:#000000;

}
.register {
background-color:#86acac;
    border: none;
    color: #000000;
    padding: 15px 52px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
width:50%
}
.register:hover {
    background-color: #4CAF50; /* Green */
    color: white;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>xyz</title>
<script>
function Login()
{
	alert("enter");
	 window.location.href = 'LogIn.jsp';

}
function Signup()
{alert("enter ");
	 window.location.href = 'Signup.jsp';

}

</script>
</head>
<body bgcolor="#d1e0e0">
<%System.out.println(session.getAttribute("UserName")+"trying stop");
if(session.getAttribute("UserName")!=null){
	System.out.println(session.getAttribute("Username"+"trying stop"));
	RequestDispatcher rd = request.getRequestDispatcher("/HomePagelog.jsp");
	rd.forward(request, response);
	
}
 %>
<%
response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");                              
response.setDateHeader("Expires",0);
System.out.println("Last PATH::"+session.getAttribute("path"));
session.setAttribute("path", "nonlog");
System.out.println("PATH::"+session.getAttribute("path"));
%>
<table class="registration">
<tr><th>xyz@shop.com</th><th><input  type="button"  class="register" name="Login" value="Login" onclick="Login()"/></th>
<th><input type="button" class="register" name="Signup" value="Signup" onclick="Signup()"/>
</th></tr></table>
<%@ include file="Header.jsp" %>
<%@ include file="Product.jsp" %>
</body>
</html>