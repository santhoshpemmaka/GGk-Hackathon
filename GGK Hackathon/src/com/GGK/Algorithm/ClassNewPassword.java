package com.GGK.Algorithm;

import java.lang.reflect.Method;
import java.sql.*;

import com.GGK.ConnectionHandler;

public class ClassNewPassword {

	public static String GenerateNewPassword(String Algorithm_Code,String password) {
		String Char_New_pswd ="";
	
		try{
		 Connection con=ConnectionHandler.getConnection();
		 Statement st=con.createStatement();
		
		 ResultSet algo = st.executeQuery("select * from AlgorithmTable where Algorithm_Code ='"+Algorithm_Code+"';");
		 
		 if(algo.next())
		 {
			 
		   	 String Alg_Type = algo.getString("Algorithm_Type");
		   	 String Alg_Class = algo.getString("Algorithm_Class");
		   	 algo.close();
		   	 
		   	 Class cls = Class.forName(Alg_Class);
			 @SuppressWarnings("deprecation")
			 Object obj = cls.newInstance();
				
		   	 if(Alg_Type.equalsIgnoreCase("character"))
		   	 {
		   		 Method method = cls.getDeclaredMethod(Algorithm_Code, String.class);
		   		 Char_New_pswd = (String) method.invoke(obj, password);
		   	 }
		 }
		}catch(Exception exception){ System.out.println("register jsp  "+exception);}
		
	return Char_New_pswd ;
	 
		
}
}