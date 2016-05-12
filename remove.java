package xyz;
import java.io.IOException;
import java.io.PrintWriter;
 import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.Cookies;

import login.LoginBean;

@WebServlet("/remove")
public class remove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public remove() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("this is remove .java");
		String productr = request.getParameter("id");
		int i =Integer.parseInt((String)request.getSession().getAttribute("UserID"));
		System.out.println("this is remove.java"+productr+"product code:ID customer"+i);
		try{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver() ); // this will give error if path of sql is not set
			String url = "jdbc:mysql://localhost:3306/ajax?user=root&password=sidsql";
			Connection con = DriverManager.getConnection(url); 
			Statement stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery("SELECT CustomerSeq,ProductID,ProductName,CustomerID from cart");
		int sequence =1;
			rs.beforeFirst();
		otherout:while(rs.next()){if(i==rs.getInt("CustomerID")){break otherout;}sequence++;}
		rs.absolute(sequence);
		String fromdata = rs.getString(2);

		int index = fromdata.indexOf(productr);
		if(index==-1){System.out.println("data do not exsist");}else{
		
			Cookie arr[];
			arr = request.getCookies();
if(arr.length>0){
	for(int it=0;it<arr.length;it++){
System.out.println("this is cookie to be deleted outer"+productr);
		if(arr[it].getName().equals(productr))
		{
	System.out.println("this is cookie to be deleted"+arr[it].getName());
			arr[it].setValue(null);
arr[it].setMaxAge(0);
	response.addCookie(arr[it]);		
		}
	}
}
			String frmdata1 = fromdata.substring(0,index);
		String frmdata2 = fromdata.substring(index+5,fromdata.length());
		String towrite = frmdata1+frmdata2;
		rs.updateString(2,towrite);
		rs.updateRow();
		CartBean cb1 = (CartBean)request.getSession().getAttribute("CartBean");
		CartBean cb =	duplicateCheck(rs.getString(2),cb1);
		ArrayList<ArrayList> group = new ArrayList<ArrayList>();
		group = productnamefind(cb.getProductID(),cb.getProductCat());
		//cb.setProductName(productnamefind(cb.getProductID(),cb.getProductCat()));
		cb.setProductName(group.get(0));
		cb.setProductPrice(group.get(1));
		request.getSession().setAttribute("CartBean",cb);
		con.close();
		rs.close();
		
		}
		}
		catch(Exception e )
		{
			e.printStackTrace();
		}
		System.out.println("transfer to Cart.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/Cart.jsp");
		rd.forward(request, response);

	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

ArrayList <String> al1 = new ArrayList<String>();
ArrayList <String> alid = new ArrayList<String>();
ArrayList <String> alname = new ArrayList<String>();

// this is used for setting cart product
public CartBean duplicateCheck(String fromdatabase,CartBean cb)
{int q=0;
cb.resetal();
alid.clear();al1.clear();alname.clear();
String database= fromdatabase;
System.out.println(database.length()+"this is lenght of database string");
	int i = fromdatabase.length();
	int pass = i/5;
	System.out.println("no of pass:" +pass);
	for(int j=1;j<=pass;j++)
	{
		al1.add(database.substring(q, q+4));
		alid.add(database.substring(q+3,q+4));
		alname.add(database.substring(q, q+3));
		q=q+5;
	}
	System.out.println("size of alcat"+alname.size());
	cb.setProductID(alid);
	cb.setProductCat(alname);
return cb;	
}
ArrayList <String > productname = new ArrayList<String>();
ArrayList <String > categoryname = new ArrayList<String>();
ArrayList <String> productprice = new ArrayList<String>();

public ArrayList<ArrayList> productnamefind(ArrayList<String> alid,ArrayList<String> alcatname)
{   ArrayList <ArrayList> group = new ArrayList<ArrayList>();  
	productname.clear();categoryname.clear();productprice.clear();group.clear();
	for(int j=0;j<alcatname.size();j++)
	{
		if(alcatname.get(j).equals("bks"))
		{
			categoryname.add("books");
		}
		else if(alcatname.get(j).equals("prd"))
		{
			categoryname.add("product");
		}
		else if(alcatname.get(j).equals("mda"))
		{
			categoryname.add("media");
		}
		else if(alcatname.get(j).equals("spt"))
		{
			categoryname.add("sports");
		}
	}
	
	try{

		DriverManager.registerDriver(new com.mysql.jdbc.Driver() ); // this will give error if path of sql is not set
	String url = "jdbc:mysql://localhost:3306/ajax?user=root&password=sidsql";
	Connection con = DriverManager.getConnection(url); 
	Statement stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	
	for(int z=0;z<categoryname.size();z++){
	ResultSet rs = stmt.executeQuery("SELECT ProductID,ProductName,Description,Price from "+ categoryname.get(z));
System.out.println(alid.get(z)+"this is alid get z");
	rs.absolute(Integer.parseInt(alid.get(z)));
	productname.add(rs.getString(2));
	productprice.add(rs.getString(4));
	}
	
	}
	catch(Exception e)
	{e.printStackTrace();}
	group.add(productname);
	group.add(productprice);
	return group;
	}

}
