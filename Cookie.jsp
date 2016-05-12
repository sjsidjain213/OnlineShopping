<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String id =request.getParameter("productid");
String s1 = (String)session.getAttribute("categ");
if(s1.equals("product"))
{s1="prd";
	}
else if(s1.equals("books"))
{s1="bks";
	}
else if(s1.equals("media"))
{s1="mda";}
else if(s1.equals("sports"))
{s1="spt";
	}

String total = id;
Cookie arr[],arr2[];
Cookie c1[]= new Cookie[100];
arr=request.getCookies();
for(int i=arr.length;i<=arr.length;i++){
		 c1[i] = new Cookie(s1+id,id);
response.addCookie(c1[i]);	
//System.out.println(arr[i]);
}
arr2=request.getCookies();
for(int l=1;l<arr2.length;l++)
{System.out.println(arr[l].getName()+"this is name of cookie");
	}

%>
<jsp:forward page="LogIn.jsp"/>
</body>
</html>