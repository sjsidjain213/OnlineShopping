<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="xyz.ProductBean2, java.util.HashMap;
    "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table.product{width:100%;
}
table.product th{background-color: #86acac;color:white;text-align:center;}
table.product td{text-align:center;}
p.name{
text-align:center;
line-height:0.5;
text-decoration: underline;
color:black
}
p.desc{
text-align:center;
color:#333333;

}
.add{
 background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 10px 34px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 13px;
    border-radius: 12px;
    }
.add {
    background-color: white; 
    color: black; 
    border: 2px solid #4CAF50;
}

.add:hover {
    background-color: #4CAF50;
    color: white;
}
    

</style>
<script>
function trans(clicked_id)
{
	var c = clicked_id;
	location.href ="Cookie.jsp?productid="+c;
}
</script>
</head>
<body>
<form>
<%
response.setHeader("Cache-Control", "no-cache, no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");                              
response.setDateHeader("Expires",0);
System.out.println("LastPATH::"+session.getAttribute("path"));
try{
	//if(session.getAttribute("path").equals("ProductAssign")){
ProductBean2 pb = (ProductBean2)session.getAttribute("refrencebean");
HashMap<Integer,String> hmname = new HashMap<Integer,String>();
HashMap<Integer,String> hmdescription = new HashMap<Integer,String>();
HashMap<Integer,String> hmID = new HashMap<Integer,String>();
hmname.clear();hmdescription.clear();hmID.clear();
hmname = pb.getProductName();
hmdescription = pb.getDescription();
hmID = pb.getProductID();
for(int i=1;i<=hmname.size();i++)
{%>
<table class="product"><tr><th>
<% out.println("<p class=name>"+hmname.get(i)+"</p></th></tr>");
out.println("<tr><td><p class=desc>"+hmdescription.get(i)+"</p></td></tr>");%>
<tr><td><input type="button" class="add" id=<%=hmID.get(i)%> name="top" value="add to cart" onclick="trans(this.id)"/></td></tr></table>
<%}
//}
	}catch(Exception e){ }
//session.setAttribute("path","nonlog");
System.out.println(session.getAttribute("path"));

System.out.println("this is Product.jsp");%>
</form>
</body>
</html>