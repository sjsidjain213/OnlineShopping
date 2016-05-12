package xyz;
import java.io.IOException;
import java.io.PrintWriter;
 import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import login.LoginBean;
/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("this is  do get servlet");
		request.getSession().setAttribute("path","Register");
			RequestDispatcher rd =  request.getRequestDispatcher("/LogIn.jsp");
		rd.forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
String roll = request.getParameter("roll");
System.out.println(roll+"97979");
int i = roll.indexOf("****");
int j = roll.indexOf("$$$$");
int k = roll.indexOf("####");
String email = roll.substring(i+4, j);
String phone = roll.substring(j+4,k);
String pass = roll.substring(k+4,roll.length());
roll=roll.substring(0,i);
System.out.println(email+"email"+phone+"phone"+roll+"roll");
if(email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"))
{
	}else{
		response.getWriter().println("Invalid data");
		return;
		
	}
if(phone.matches("^[0-9]*$"))
{
	}else{
		response.getWriter().println("Invalid data");
		return;
		
	}
		String present="NO";		
try{
DriverManager.registerDriver(new com.mysql.jdbc.Driver()); // this will give error if path of sql is not set
String url = "jdbc:mysql://localhost:3306/ajax?user=root&password=sidsql";
Connection con = DriverManager.getConnection(url); 
Statement stmt = (Statement) con.createStatement();
ResultSet rs = stmt.executeQuery("select * from login");
rs.beforeFirst();
while(rs.next())
{       System.out.println(rs.getString("Name"));
	if(rs.getString("Name").equals(roll))
{System.out.println("inside compare");
	present="YES";
	}else{
	}
	}
stmt.close();
rs.close();
System.out.println(present+"this is status");
if(present.equals("NO")){
System.out.println("no record is present");
	String query = " insert into login (Name, Password)"
        + " values (?, ?)";
 
      // create the mysql insert preparedstatement
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString (1, roll);
      ps.setString (2, pass);

      // execute the preparedstatement
      ps.execute();
  	response.getWriter().println("5");
}
else{
	response.getWriter().println("Invalid User");
System.out.println("response is generated");
}
}
catch(Exception e)
{e.printStackTrace();}
}
}
