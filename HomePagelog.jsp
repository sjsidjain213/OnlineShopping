<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function toend()
{window.location.href='MidCart.jsp?product=null';
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table.out{
width:100%;
height:50px;
background-color:#86acac;
}
table.out td{
width:25%
}
p.cent{
color:white}
p.welcome
{
color:white;
text-transform: uppercase;
}
.logout
{
align:right;
width: 250px;
}
.logout {
    background-color: #4CAF50; 
    border: none;
    color: white;
    padding: 15px 102px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    cursor: pointer;
    float: left;
   
}

.cart {
    background-color:#537979;
border: none;
    color: white;
    padding: 15px 102px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    cursor: pointer;
    float: left;
   border-radius: 15px;
}

.logout:hover {
    background-color:#ff0000 ;
}
.cart:hover {
background-color: #4CAF50; /* Green */
     }

 </style>
</head>
<body bgcolor="#d1e0e0">
<% if(session.getAttribute("UserName")!=null){%>
<%
System.out.println("LastPATH::"+session.getAttribute("path"));
response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");                              
response.setDateHeader("Expires",0);
session.setAttribute("path","log");
System.out.println("PATH::"+session.getAttribute("path"));
%>
<table class="out">
<tr><td>
<p class="welcome"> WELCOME :: <%=session.getAttribute("UserName") %></p>
</td>
<td><p class="cent">XYZ@SHOP</p></td>
<td><input type="button" class="cart" value="Cart" onclick="toend()">
<td><form action="Logout" method="get"><input type="submit" class="logout" name="logout" value="LOGOUT"></form></td>
</table>
<%@include file="Header.jsp" %>
<%@include file="Productlog.jsp"%>
<%}else{ 
	RequestDispatcher rd = request.getRequestDispatcher("/HomePage.jsp");
	rd.forward(request, response);

	
}%>
</body>
</html>