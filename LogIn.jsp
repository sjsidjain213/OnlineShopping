<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>

table.logsub {
    border-collapse: collapse;
    width: 100%;
}

table.logsub th {
    height: 50px;
}
.logsubb {
  display: inline-block;
  border-radius: 4px;
  background-color: #4db7ff;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 20px;
  padding: 15px;
  width: 120px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.logsubb span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.logsubb span:after {
  content: '»';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.logsubb:hover span {
  padding-right: 25px;
}

.logsubb:hover span:after {
  opacity: 1;
  right: 0;
}
.logsubb:hover {
    background-color: #4CAF50; /* Green */
    color: white;
}
body {
    text-align: center;

    line-height: 2.2;
}
p.big{    line-height: 8.8;
}
</style>
<body bgcolor="#e5fffa">
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
session.setAttribute("path","Login");
System.out.println("PATH::"+session.getAttribute("path"));
%>
<p class="big">Login Form</p>
<table class="logsub">
<tr></tr>
<tr>
<form action="Registration" method="post">
<table align="center"><tr><td>Name:</td><td><input type="text" name="Name"/><br></td></tr>
<tr><td>Password:</td><td><input type="password" name="Password"/><br></td></tr></table>
<input type="submit" class="logsubb" name="submit" value="submit"/>
</form>
</tr>
</table>

</body>
</html>