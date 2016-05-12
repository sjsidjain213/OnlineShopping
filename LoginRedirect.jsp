<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%System.out.println("Last PATH(post)::"+session.getAttribute("path"));
response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires",0);
System.out.println("PATH(post)::"+session.getAttribute("path"));
response.sendRedirect("http://localhost:9080/OnlineShopping/Registration");
%>
</body>
</html>