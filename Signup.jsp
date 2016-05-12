<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>

function sign()
{
if(document.getElementById('signname').value.trim()== ""){

	alert("emptyfield");
	element.focus();
	return false;
}	else if(document.getElementById('email').value.trim()== "")
{	alert("emptyfield");
element.focus();
return false;
}
else if(document.getElementById('phone').value.trim()=="")
	{
	alert("emptyfield");
	element.focus();
	return false;
	}
else if(document.getElementById('pass').value.trim()=="")
{
alert("Password cannot be left empty");
element.focus();
return false;
}
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
	var roll = document.getElementById('signname').value;// in double inverted comma
	var email = document.getElementById('email').value;
var phone= document.getElementById('phone').value;
var pass = document.getElementById('pass').value;
	alert(email+roll+phone);
	
	xmlHttp.open("Post",'Redirect.jsp',true);//is it case sensitive
	xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xmlHttp.send("roll="+roll+"****"+email+"$$$$"+phone+"####"+pass); // in case of get if it was post then the variable which is need to be pass is passed here insted of url ex::send('roll')
	}
	function processResponse()
	{
		if(xmlHttp.readyState==4 && xmlHttp.status==200)
			{
			var sp = document.getElementById('result');
			sp.innerText = xmlHttp.responseText;
			alert(xmlHttp.responseText+"this is alert");
			if(xmlHttp.responseText==5){
				 window.location.href = 'Redirect2.jsp';
	
			}else{}
			}
	
	} // what is the diffrence betweem innerText and innerhtml

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
</head>
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
session.setAttribute("path","Login"); %>
<p class="big">Signup Form</p>
<table class="logsub">
<tr></tr>
<tr>
<form action="Servlet" method="post">
<table align="center">
<tr><td>Name:</td><td><input type="text" name="signname" id="signname"/><br></td></tr>
<tr><td>Password:</td><td><input type="password" name="Passord" id="pass"/><br></td></tr>
<tr><td>Email ID:</td><td><input type="text" name="email" id = "email"/><br></td></tr>
<tr><td>Phone:</td><td><input type="text" name="phone" id ="phone"/><br></td></tr>
</table>
</form>
<input type="button" class="logsubb" name="submit" value="submit" onclick="sign()"/><span id='result'></span>
</tr>
<!-- what is span id??? is it commonn for a whole document od it belong to any single individual element 
i think it sould be for whole ducument instead of for a particular element
-->
</table>

</body>
</html>