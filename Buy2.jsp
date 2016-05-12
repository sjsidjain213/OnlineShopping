<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="xyz.CartBean,java.util.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% ArrayList <String > al = new ArrayList<String>();

CartBean cb = (CartBean)request.getSession().getAttribute("CartBean");
 al = cb.getProductPrice();
String id  = (String)session.getAttribute("qty"); 
System.out.println(id+"this is id"+request.getParameter("cty")+"this is cty");
double amount=0;
double qty=0;
int start=0;
String d=null;

for(int i=0;i<al.size();i++)
{
	start = id.indexOf("**",start+1);
	String num = id.substring(start+2, id.indexOf("**",start+1));
	qty =Double.parseDouble(num);
	String s = al.get(i);
s = s.substring(1,s.length());
System.out.println(s+"tthis is amount"+qty+"this is quantity"+"dfbfvfv"+num);
amount = amount + qty*Double.parseDouble(s);
}
System.out.println(amount+"this is amount");
request.getSession().setAttribute("amount",amount);
out.println("total:"+amount);

%>
</body>
</html>