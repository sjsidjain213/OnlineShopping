package xyz;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import login.LoginBean;
import xyz.CartBean;
/**
 * Servlet implementation class LastMid
 */
@WebServlet("/LastMid")
public class LastMid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LastMid() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		RequestDispatcher rd = request.getRequestDispatcher("/Cart.jsp");
		rd.forward(request, response);
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}
ArrayList <String> al = new ArrayList<String>();
ArrayList <String> alid = new ArrayList<String>();

ArrayList <String> alname = new ArrayList<String>();
public CartBean duplicateCheck(String fromdatabase)
{int q=0;
CartBean cb = new CartBean();
String database= fromdatabase;
System.out.println(database.length()+"this is lenght of database string");
	int i = fromdatabase.length();
	int pass = i/5;
	System.out.println("no of pass:" +pass);
	for(int j=1;j<=pass;j++)
	{
		al.add(database.substring(q, q+4));
		alid.add(database.substring(q+3,q+4));
		alname.add(database.substring(q, q+3));
		q=q+5;
	}
	System.out.println("size of alcat"+alname.size());
	cb.setProductID(alid);
	cb.setProductCat(alname);
return cb;	
}

}
