<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="xyz.ProductBean2, java.util.HashMap;"%>

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
p.mrp
{text-decoration: underline;
color:green
}
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
function funt(clicked_id)
{
var c = clicked_id;
location.href ="MidCart.jsp?product="+c;
}
</script>
</head>
<body>
<%
//System.out.println("LastPATH::"+session.getAttribute("path"));
//System.out.println("PATH::"+session.getAttribute("path"));
try{if(session.getAttribute("categ")!=null)
{	if(session.getAttribute("refrencebean")!=null){
ProductBean2 pb = (ProductBean2)session.getAttribute("refrencebean");
HashMap<Integer,String> hmname = new HashMap<Integer,String>();
HashMap<Integer,String> hmdescription = new HashMap<Integer,String>();
HashMap<Integer,String> hmID = new HashMap<Integer,String>();
HashMap<Integer,String> hmprice = new HashMap<Integer,String>();

hmname = pb.getProductName();
System.out.println(hmname.size()+"this is sizd of hashmap in prolog");
hmdescription = pb.getDescription();
hmID = pb.getProductID();
hmprice = pb.getProductPrice();
System.out.println(hmprice.size()+"hmprice"+hmprice.get(1));
for(int i=1;i<=hmname.size();i++)
{%>
<table class=product><tr><th>
<%out.println("<p class=name>"+hmname.get(i)+"</p></th><th> <p class=mrp>MRP:"+hmprice.get(i)+"</p></th></tr>");
out.println("<tr><td><p class=desc>"+hmdescription.get(i)+"</p></td></tr>");%>
<tr><td><input type="button" class="add" id=<%=hmID.get(i)%> name="top" value="add to cart" onclick="funt(this.id)"/></td></tr></table><br>
<% 
}

pb.nameempty();
}
else{
	System.out.println("bean not invoked");

}
}
}
catch(Exception e){ e.printStackTrace();}
%>
</body>
</html>