package xyz;
import java.io.IOException;
import java.io.PrintWriter;
 import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import login.LoginBean;
import xyz.ProductBean2;
/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
HashMap <Integer,String> hmdata = new HashMap<Integer,String>();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if(request.getParameter("product").equals("null"))
{ 
	System.out.println("product is null");
try
{
int i =Integer.parseInt((String)request.getSession().getAttribute("UserID"));
DriverManager.registerDriver(new com.mysql.jdbc.Driver() ); // this will give error if path of sql is not set
String url = "jdbc:mysql://localhost:3306/ajax?user=root&password=sidsql";
Connection con = DriverManager.getConnection(url); 
Statement stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
ResultSet rs = stmt.executeQuery("SELECT CustomerSeq,ProductID,ProductName,CustomerID from cart");

int userpres=2;
//check if exsist if no then add it
rs.beforeFirst();
outer:while(rs.next()){
	if(i==rs.getInt("CustomerID")){
		userpres=1;
		break outer;
		}else{userpres=0;}
System.out.println("broken");
}

if(userpres==0){
	rs.moveToInsertRow();
	rs.updateInt("CustomerID", i);
rs.insertRow();
}
int sequence=1;
rs.beforeFirst();
otherout:while(rs.next()){if(i==rs.getInt("CustomerID")){break otherout;}sequence++;}
System.out.println(sequence+"97997");
rs.beforeFirst();
Cookie arr[];
arr = request.getCookies();
System.out.println(arr.length+"this is arrylenght");
rs.absolute(sequence);
//String prr = rs.getString(2);
String proid="";
for(int l=1;l<arr.length;l++)
{
	String prr = rs.getString(2);
proid = arr[l].getName();
System.out.println("789789798798this is proid"+proid);
proid = duplicateCheck(prr,proid);
System.out.println("78798798798798this is proid"+proid+"***");
rs.absolute(sequence);
rs.updateString("ProductID",proid);
rs.updateInt("CustomerID", i);	
rs.updateRow();
}

CartBean cb =	duplicateCheck(rs.getString(2));
ArrayList<ArrayList> group = new ArrayList<ArrayList>();
group = productnamefind(cb.getProductID(),cb.getProductCat());
cb.setProductName(group.get(0));
cb.setProductPrice(group.get(1));
request.getSession().setAttribute("CartBean",cb);
RequestDispatcher rd = request.getRequestDispatcher("/LastMidCart.jsp");
rd.forward(request, response);
con.close();
rs.close();
}

catch(Exception e)
{e.printStackTrace();}
}
else{ 
	try{
	int i =Integer.parseInt((String)request.getSession().getAttribute("UserID"));
	String s = request.getParameter("product");
    String scat= (String)request.getSession().getAttribute("categ");
    System.out.println("user ID:"+i+"Category:"+scat+"ProductID:"+s);
    String proid =	shortcat(scat,s);
    int id = Integer.parseInt(request.getParameter("product"));

    ProductBean2 pb = (ProductBean2)request.getSession().getAttribute("refrencebean");
//String name =getfromhm(pb.getProductName(),id);	
//System.out.println(name+"****");

DriverManager.registerDriver(new com.mysql.jdbc.Driver() ); // this will give error if path of sql is not set
String url = "jdbc:mysql://localhost:3306/ajax?user=root&password=sidsql";
Connection con = DriverManager.getConnection(url); 
//Statement stmt = (Statement) con.createStatement();
//String query = "UPDATE cart SET CustomerID = ? where ProductID = ?";
//PreparedStatement ps = con.prepareStatement(query);
Statement stmt = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
ResultSet rs = stmt.executeQuery("SELECT CustomerSeq,ProductID,ProductName,CustomerID from cart");
int userpres=2;
//check if exsist if no then add it
rs.beforeFirst();
outer:while(rs.next()){
	if(i==rs.getInt("CustomerID")){
		userpres=1;
		break outer;
		}else{userpres=0;}
System.out.println("broken");
}

if(userpres==0){
	rs.moveToInsertRow();
	rs.updateInt("CustomerID", i);
rs.insertRow();
}
//finding correct sequence number
int sequence=1;
rs.beforeFirst();
otherout:while(rs.next()){if(i==rs.getInt("CustomerID")){break otherout;}sequence++;}
rs.absolute(sequence);
//making string for productname of database 
// this is used for setting cart data when product is added to cart by clicking on add cart
// it also check if selected product already exsist in database
proid =duplicateCheck(rs.getString(2),proid);
rs.updateString("ProductID",proid);
rs.updateInt("CustomerID",i);
//rs.updateString("ProductName",name+":");
rs.updateRow();
// to add data in cart which is coming from cookies
Cookie arr[];
arr = request.getCookies();
System.out.println(arr.length+"this is arrylenght");
for(int l=1;l<arr.length;l++)
{
proid = arr[l].getName();
System.out.println("this is proid"+proid);
proid = duplicateCheck(rs.getString(2),proid);
rs.absolute(sequence);
rs.updateString("ProductID",proid);
rs.updateInt("CustomerID", i);	
rs.updateRow();
}
// to get data from cart about product id

CartBean cb =	duplicateCheck(rs.getString(2));
ArrayList<ArrayList> group = new ArrayList<ArrayList>();
group = productnamefind(cb.getProductID(),cb.getProductCat());
//cb.setProductName(productnamefind(cb.getProductID(),cb.getProductCat()));
cb.setProductName(group.get(0));
cb.setProductPrice(group.get(1));
request.getSession().setAttribute("CartBean",cb);
RequestDispatcher rd = request.getRequestDispatcher("/LastMidCart.jsp");
rd.forward(request, response);
con.close();
rs.close();
}
catch(Exception e)
{
	e.printStackTrace();
}}
	}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
public String getfromhm(HashMap<Integer,String> hm,int i)
{String data = hm.get(i) ;
return	data;
}
public String shortcat(String s1,String s2)
{String s;
	if(s1.equals("product"))
{s1="prd";
	}
else if(s1.equals("books"))
{s1="bks";
	}
else if(s1.equals("media"))
{s1="mda";}
else if(s1.equals("sports"))
{s1="spt";
	}
return s=s1+s2;
	}
ArrayList <String> al = new ArrayList<String>();
public String duplicateCheck(String fromdatabase,String g2)
{int q=0;
String database= fromdatabase;
	int i = fromdatabase.length();
	int pass = i/5;
	System.out.println("no of pass:" +pass);
	for(int j=1;j<=pass;j++)
	{
		al.add(database.substring(q, q+4));
		q=q+5;
	}
	timeup:for(int k=0;k<al.size();k++)
	{if(g2.equals(al.get(k))){
		al.clear();
		return fromdatabase;   }else{ }
	}
	
String productline=fromdatabase+g2+":";
al.clear();

return productline;
	}

ArrayList <String> al1 = new ArrayList<String>();
ArrayList <String> alid = new ArrayList<String>();
ArrayList <String> alname = new ArrayList<String>();

// this is used for setting cart product
public CartBean duplicateCheck(String fromdatabase)
{int q=0;
CartBean cb = new CartBean();
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
