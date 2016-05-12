package xyz;

import java.util.ArrayList;

public class CartBean
{
private int customerid;
private String productid,customername,productname;
ArrayList <String> alname = new ArrayList<String>();
ArrayList <String> alid = new ArrayList<String>();
ArrayList <String> alproductname = new ArrayList<String>();
ArrayList <String> alproductprice = new ArrayList<String>();

public void setProductCat(ArrayList<String> alname)
{this.alname=alname;
	}
public ArrayList<String> getProductCat()
{return alname;
	}

	public void setProductID(ArrayList<String> alid)
	{
this.alid=alid;
	}
	public ArrayList<String> getProductID()
	{
		return alid;
	}
	public void setCustomerID(String prod)
	{
		productid = prod;
	}
	public String getCustomerID()
	{
		return productid;
	}
	public void setCustomerName(String name)
	{
		customername = name;
	}
	public String getCustomerName()
	{
		return customername;
	}
	public void setProductName(ArrayList<String> pnm)
	{
		alproductname = pnm;
	}
	public ArrayList<String> getProductName()
	{
		return alproductname;
	}
	public void setProductPrice(ArrayList<String> spp)
	{
		alproductprice=spp;
	}
	public ArrayList<String> getProductPrice()
	{
		return alproductprice;
	}
	
	public void resetal()
	{
		alname.clear();
		alproductname.clear();
		alid.clear();
		alproductprice.clear();
	}

}