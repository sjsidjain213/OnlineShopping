package xyz;

import java.util.HashMap;

public class ProductBean2
{
HashMap <Integer,String> hmname;
HashMap <Integer,String> hmdescription;
HashMap <Integer,String> hmprice;
HashMap <Integer,String> hmID;
public void setProductName(HashMap<Integer,String> ProductName)
{
	this.hmname= ProductName;
}
public HashMap<Integer,String> getProductName()
{
	return hmname;
}
public void setDescription(HashMap<Integer,String> Description)
{
	this.hmdescription=Description;
}
public HashMap<Integer,String> getDescription()
{
	return hmdescription;
	}
public void setProductID(HashMap<Integer,String> ID)
{
	hmID=ID;
	}
public HashMap<Integer,String> getProductID()
{return hmID;
	}
public void setProductPrice(HashMap<Integer,String> hmprice)
{this.hmprice=hmprice;
	}
public HashMap<Integer,String> getProductPrice()
{return hmprice;
	}
public void nameempty()
{
	hmprice.clear();
hmname.clear();
hmdescription.clear();
hmID.clear();
}
}
