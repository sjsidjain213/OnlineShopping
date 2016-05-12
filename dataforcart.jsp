<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList, xyz.CartBean;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function fun(clicked_id)
{
var c = clicked_id;
location.href ="remove.jsp?id="+c;
}
function forbuy(idd)
{	var s;
	var id = idd
	var quan=0;
		var p=0;
var l;
		for(l=0;l<id;l++)
		{if(document.getElementById(l).value.trim()== ""){

			alert("emptyfield");
			
			return false;
		}}
		
		for(var s = 0;s<id;s++)
	{
		p =p+"**"+document.getElementById(s).value;
	
		quan=quan+document.getElementById(s).value;
	}
	p=p+"**";
	//	location.href="Buy2.jsp?qty="+p+"&cty="+"ksl";
	// this is ajax request to buy.jsp for checkng the format of quantity
	// transferring to Buy2.jsp
	try{
		xmlHttp = new XMLHttpRequest();
	}
	catch(e1)
	{try{
		xmlHttp= new ActiveXObject("Micosoft.XMLHTTP");
	}catch(e2)
	{
		try{
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e3)
		{
			alert('ajax is not supported');
			return false;
		}
	}
}
	xmlHttp.onreadystatechange = processResponse;
	xmlHttp.open("get",'CheckOut?cty='+quan+"&qty="+p,true); //is it case sensitive
	xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlHttp.send(null); // in case of get if it was post then the variable which is need to be pass is passed here insted of url ex::send('roll')
	// do javascript also have local variable and instance variable like java ??? it should have that thing like java
	}
	function processResponse()
	{
		if(xmlHttp.readyState==4 && xmlHttp.status==200)
		{
		var sp = document.getElementById('result');
		sp.innerText = xmlHttp.responseText;
		alert(xmlHttp.responseText+"this is response");
		if(xmlHttp.responseText==1){
alert("this is insode response");
		

			window.location.href = 'Buy2.jsp';

		}else{}
		}
	}
	
</script>

<style>
.add {
    border: none;
    color: white;
    padding: 16px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    -webkit-transition-duration: 0.4s; /* Safari */
    transition-duration: 0.4s;
    cursor: pointer;
    
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

table.product {
border-collapse: collapse;
    width: 100%;
}
table.product td{
width:25%;
padding:5px;
text-align:center;
}
table.product th{
width:25%;
padding:5px;
  height: 50px;
text-align:center;
 background-color: #4CAF50;
    color: white;}

</style>
</head>
<body>
<%if(session.getAttribute("CartBean")!=null){
ArrayList<String> alid = new ArrayList<String>();
ArrayList<String> alcat = new ArrayList<String>();
ArrayList<String> alproname = new ArrayList<String>();
ArrayList<String> alproprice = new ArrayList<String>();
ArrayList<Integer> alquantity = new ArrayList<Integer>();
CartBean cb = (CartBean)session.getAttribute("CartBean");
alcat =cb.getProductCat();
alid =cb.getProductID();
alproname = cb.getProductName();
alproprice=cb.getProductPrice();
System.out.println(alcat.size()+"size of alcat");
	
%>	<table class=product>
	<tr><th>Product ID</th><th>ProductName</th><th>Qty</th><th>Price</th><th></th></tr>
	<%for(int i=0;i<alcat.size();i++){
		
	out.println("<tr><td><p class=name>"+alid.get(i)+alcat.get(i)+"</p></td>");
//	out.println("<td><p class=desc>"+alcat.get(i)+"</p></td>");
	out.println("<td><p class=desc>"+alproname.get(i)+"</p></td>");
		%>
		<td><input type=text name=qty value=<%=i %> id=<%=i %> /></td>
	<% 	System.out.println(i+"this  is i");
	%>
	<!-- out.println("<input type=text value="+i+"id="+i">");	-->
	<% 	out.println("<td><p class=desc>"+alproprice.get(i)+"</p></td>");%>
<td><input type="button" name="remove" id=<%=alcat.get(i)+alid.get(i)%> value="remove" onclick="fun(this.id)" ></td></tr>	

	<%		}%>
</table>

<% session.setAttribute("totalnoid",alcat.size());
%>
<input type="button" class="add" id=<%=alcat.size() %> name="top" value="Buyy" onclick="forbuy(this.id)" /><spna id='result'/>
<%
}
%>

</body>
</html>