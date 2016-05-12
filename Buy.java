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
@WebServlet("/Buy")
public class Buy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Buy() {
        super();
    }

    ArrayList <String > al = new ArrayList<String>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

CartBean cb = (CartBean)request.getSession().getAttribute("CartBean");
 al = cb.getProductPrice();
String id  = request.getParameter("id"); 
double amount=0;
double qty=0;
for(int i=0;i<al.size();i++)
{
	
qty =	Double.parseDouble(id.substring(i));
	String s = al.get(i);
s = s.substring(1,s.length());
System.out.println(s+"tthis is amount"+qty+"this is quantity");
amount = amount + qty*Double.parseDouble(s);

}
System.out.println(amount+"this is amoussssssssssnt");

request.getSession().setAttribute("amount",amount);

	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}

}
