<%@page import="java.sql.*" %>
<%
System.out.println("thushgys");
response.setDateHeader("Expires", -1);
try{
	DriverManager.registerDriver(new com.mysql.jdbc.Driver() ); 
	String url = "jdbc:mysql://localhost:3306/ajax?user=root&password=sidsql";
    Connection con = DriverManager.getConnection(url); 
 Statement   stmt = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
   ResultSet rs = stmt.executeQuery("select * from product");
   String result="Not Found";
if(rs.next())
	result = rs.getString("ProductName")+"**"+rs.getString("Description");
System.out.println(result +"this is result");
out.println(result);
}catch(Exception e){e.printStackTrace();}
%>