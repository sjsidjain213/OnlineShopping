<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function home(){
location.href="HomePagelog.jsp";
}</script>
<style>
.home{
background color:green
}
table.out{
width:100%;
height:50px;
background-color:#86acac;
}
table.out td{
width:80%
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
.logout:hover {
    background-color:#ff0000 ;
}
p.your{
text-align:center;
text-transform:uppercase;
line-height:1.7
text-shadow: 2px 2px #ff0000;
}
table.cart{  border-collapse: collapse;
    width: 100%;}
table.cart th{ background-color: #4CAF50;
    color: white;
    width: 33%;
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
<td><form action="Logout" method="get"><input type="submit" class="logout" name="logout" value="LOGOUT"></form></td>
<tr><td><input type="button" name="home" id="home" value="continue shopping" class="home" onclick="home()"/></td><td><p class="your"> Your Cart <p></td></tr>
</table>

<%@include file="dataforcart.jsp"%>
<%}else{ 
	RequestDispatcher rd = request.getRequestDispatcher("/HomePage.jsp");
	rd.forward(request, response);
	
}%>
</body>
</html>