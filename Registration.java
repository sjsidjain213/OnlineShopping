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
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Last PATH::"+request.getSession().getAttribute("path"));
		request.getSession().setAttribute("path","Register");
	System.out.println("PATH::"+request.getSession().getAttribute("path"));
	RequestDispatcher rd = request.getRequestDispatcher("/HomePagelog.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//System.out.println("lastPATH(Post)::"+request.getSession().getAttribute("path"));
request.getSession().setAttribute("path","Register");
//System.out.println("PATH(post)::"+request.getSession().getAttribute("path"));
HttpSession session = request.getSession();
	//for path
ServletContext context = getServletContext();

// making connection with database
if(session.getAttribute("UserName")!=null)
{
RequestDispatcher rd = request.getRequestDispatcher("/HomePage.jsp");
rd.forward(request, response);
return;
}
else{}
String name =request.getParameter("Name");
String password = request.getParameter("Password");
try{
DriverManager.registerDriver(new com.mysql.jdbc.Driver() ); // this will give error if path of sql is not set
String url = "jdbc:mysql://localhost:3306/ajax?user=root&password=sidsql";
Connection con = DriverManager.getConnection(url); 
Statement   stmt = (Statement) con.createStatement();
ResultSet rs = stmt.executeQuery("select * from login");
rs.beforeFirst();
int i=0;
outer:while(rs.next())
{
	if(name.equals(rs.getString("Name"))&&password.equals(rs.getString("Password")))//&&password.equals(rs.getString("Password"))
{   
		// creating attribute and forwarding page 
         session.setAttribute("UserName", name);
         session.setAttribute("UserID",rs.getString("idLogin"));
         System.out.println(rs.getString("idLogin")+"6598415149851351849");
i=1;
break outer;
}
	}
if(i==1)
{         RequestDispatcher rd = request.getRequestDispatcher("/LoginRedirect.jsp");
rd.forward(request, response);

	}
else{
System.out.println("this is case of not mathcing");
	RequestDispatcher rd = request.getRequestDispatcher("/LogIn.jsp");
    rd.forward(request, response);

}
}
catch(Exception e)
{
	e.printStackTrace();
}
	}

}
