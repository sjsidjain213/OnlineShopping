package xyz;
import java.io.IOException;
import xyz.ProductBean2;
import java.io.PrintWriter;
import java.sql.*;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import login.LoginBean;
import product.ProductBean;
/**
 * Servlet implementation class ProductAssign
 */
@WebServlet("/ProductAssign")
public class ProductAssign extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductAssign() {
        super();
        // TODO Auto-generated constructor stub
    }
HashMap<Integer,String> hmname = new HashMap<Integer,String>();
HashMap<Integer,String> hmdescription = new HashMap<Integer,String>();
HashMap<Integer,String> hmID = new HashMap<Integer,String>();
HashMap<Integer,String> hmproductprice = new HashMap<Integer,String>();

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
hmname.clear();hmdescription.clear();hmID.clear();hmproductprice.clear();
	request.getSession().setAttribute("categ", request.getParameter("product"));
System.out.println(request.getParameter("product")+"this is where it ends");
try{
    DriverManager.registerDriver(new com.mysql.jdbc.Driver() ); // this will give error if path of sql is not set
	String url = "jdbc:mysql://localhost:3306/ajax?user=root&password=sidsql";
	Connection con = DriverManager.getConnection(url); 
	Statement   stmt = (Statement) con.createStatement();
	ResultSet rs = stmt.executeQuery("select * from "+ request.getParameter("product"));
	rs.beforeFirst();
	while(rs.next())
	{
	int ID  =Integer.parseInt(rs.getString("ProductID"));
	hmname.put(ID, rs.getString("ProductName"));
	hmdescription.put(ID, rs.getString("Description"));
	hmID.put(ID,rs.getString("ProductID"));
hmproductprice.put(ID, rs.getString("Price"));
	}
	System.out.println(hmproductprice.size()+"this is size of hashmap");
ProductBean2 pb = passinbean(hmname,hmdescription,hmID,hmproductprice);
request.getSession().setAttribute("refrencebean",pb);
request.getSession().setAttribute("path","ProductAssign");
RequestDispatcher rd = request.getRequestDispatcher("/HomePagelog.jsp");
rd.forward(request, response);
}
catch(Exception e)
{e.printStackTrace();}
	}
	
	private ProductBean2 passinbean(HashMap<Integer,String> Name,HashMap<Integer,String> Description,HashMap<Integer,String> ID,HashMap<Integer,String> price)
	{
		ProductBean2 pb = new ProductBean2();
		//pb.nameempty();
		pb.setProductName(Name);
		pb.setDescription(Description);
		pb.setProductID(ID);
		pb.setProductPrice(price);
	return pb;
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
