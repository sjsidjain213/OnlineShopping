<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>In</title>
</head>
<body>
<%
session.setAttribute("qty",request.getParameter("qty"));
String forcheck = request.getParameter("cty");
forcheck = forcheck.substring(1,forcheck.length());
if(forcheck.matches("^[0-9]*$"))
{
	System.out.println("matched"+request.getParameter("qty")+"popopopop");
	response.getWriter().println("1");
	}else{
		response.getWriter().println("invalid quantity");
	return;
	}
%>
</body>
</html>