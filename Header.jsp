<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function fun()
{
	try{
		xmlHttp = new XMLHttpRequest();
	}
	catch(e1)
{e1.printStackTrace();
		}

	xmlHttp.onreadystatechange = processResponse;
	
	var roll = document.getElementById('product');// in double inverted comma
	xmlHttp.open("GET",'getResult.jsp',true);//is it case sensitive
	xmlHttp.send(null); // in case of get if it was post then the variable which is need to be pass is passed here insted of url ex::send('roll')
	
	}
	
	function processResponse()
	{
		if(xmlHttp.readyState==4 && xmlHttp.status==200)
		{
		var sp = document.getElementById('result');
		document.write(sp);
		document.write(xmlHttp.responseText);
		sp.innerText = xmlHttp.responseText; 
		}


	}
	function proassi(clicked_id)
	{
		var c = clicked_id;
		location.href ="MidCart4pro.jsp?product="+c;

	}
</script>
<style>
.cat {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 15px 50px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    cursor: pointer;
    float: left;
   
}
table.cat{
    width: 92.6%;
}

table.cat td{
width:33%
}

.cat:hover {
    background-color: #3e8e41;
}
</style>
</head>
<body>
<form action="ProductAssign" method="get">
<table class="cat">
<tr>
<td><input type="button" class="cat" name="product" id="product" value="product" onclick="proassi(this.id)"/></td>
<!-- here product id is transferred to productassign.java via midcart4pro no use of name of button
can we transfer to java class from location.href? (YES) what should be url
--> 
<td><input type="button" class="cat" name="product" id="books" value="Books" onclick="proassi(this.id)"/></td>
<td><input type="button" class="cat" name="product" id="media" value="Media" onclick="proassi(this.id)"/></td>
<td><input type="button" class="cat" name="product" id="sports" value="Sports" onclick="proassi(this.id)"/></td>
</tr>
</table>
</form>
</body>
</html>