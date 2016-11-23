package com.AlgoFocus.MyApplication.Model;



public class DAOFactory
{
private  static String dbInteractionType="jdbc";
	
	public static AppDAO getDAOInstance()
	{
	AppDAO ref=null;
	if(dbInteractionType.equals("jdbc"))
	{
		ref=new JDBCImplementation();
	}
	return ref;
	
	}
}
