package com.GGK.BDNA;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.GGK.ConnectionHandler;
import com.GGK.Algorithm.algorithm;
import com.GGK.Algorithm.binarykey;

public class encodingTable {  
	//static String[] Table_data = new String[2];
	
	public static  void main(String[] args) throws IOException, ServletException
	{
		/*
		 * ArrayList<Integer> str1 = new ArrayList<Integer>(); for(int i=32;i<127;i++)
		 * str1.add(i);
		 * 
		 * Collections.shuffle(str1);
		 * 
		 * // FileWriter fw=new FileWriter("table1.txt"); // String s="";
		 * 
		 * 
		 * int i=0; for (Integer ch : str1) { char c = (char)str1.get(i++).intValue();
		 * if(c=='\'' || c=='\\') { char d='\\'; Table1=Table1+d; } Table1+=c;
		 * 
		 * // s+=ch+" ";
		 * 
		 * }
		 * 
		 * // System.out.println(s); //System.out.println("Table1 :->"+Table1); //
		 * fw.write(s); // fw.close();
		 * 
		 * 
		 * List<Character> str2 = Arrays.asList('F', 'O', 'c', '.', 'g', 't', 'W', 'N',
		 * 'Z', 'X', 'y', 'd', 'v', 'I', '3', '6', 'R', 'r', 'V', 'G', '8', 'l', '7',
		 * '0', 'B', 'C', 'J', 'u', '4', 'j', '1', 'z', 'x', 'S', 'a', 'P', 'U', 'b',
		 * 'i', 'k', '2', 'L', 'M', '5', ',', 'w', 's', 'T', 'H', 'Q', 'Y', 'e', 'p',
		 * 'o', 'h', 'q', 'E', 'A', 'D', 'K', 'f', 'm', 'n', '9');
		 * 
		 * 
		 * 
		 * Collections.shuffle(str2);
		 * 
		 * // FileWriter fw1=new FileWriter("table2.txt"); // convert in string
		 * 
		 * for (Character ch : str2) {
		 * 
		 * Table2+=ch; //fw1.write(ch); }
		 * 
		 * // System.out.println("Table2 :->"+Table2); //fw1.close();
		 * //Table_data[0]=Table1; //Table_data[1]=Table2; // return Table_data;
		 * 
		 * 
		 */
		
		
		 Table("sutrayesomesh21@gmail.com", "somesh");
		 
	}
	


public static void Table(String in, String key) throws IOException, ServletException
{
			String Table1="";
			String Table2="";
			
			ArrayList<Integer> str1 = new ArrayList<Integer>(); 
			for(int i=32;i<127;i++)
				str1.add(i);
			
			Collections.shuffle(str1);
			int i=0;
	        for ( Integer ch : str1) 
	        { 
	        	char c = (char)str1.get(i++).intValue();
	        	if(c=='\'' || c=='\\') 
	        	{
	        		char d='\\';
	        		Table1=Table1+d;
	        	}
	        	Table1+=c;
	        } 
			
			
			
	        List<Character> str2 =  
	                Arrays.asList('F', 'O', 'c', '.', 'g', 't', 'W', 'N', 'Z', 'X', 'y', 'd', 'v', 'I', '3', '6', 'R', 'r', 'V', 'G', '8', 'l', '7', '0',
	                		      'B', 'C', 'J', 'u', '4', 'j', '1', 'z', 'x', 'S', 'a', 'P', 'U', 'b', 'i', 'k', '2', 'L', 'M', '5', ',', 'w', 's', 'T',
	                		      'H', 'Q', 'Y', 'e', 'p', 'o', 'h', 'q', 'E', 'A', 'D', 'K', 'f', 'm', 'n', '9'); 
	        
	       Collections.shuffle(str2);
	       for (Character ch : str2)
	       { 
	    	   Table2+=ch;
	       }
			
	       String email = in;
	       try { 
	    		
	    		Connection con = ConnectionHandler.getConnection();
	    		Statement st = con.createStatement();
	    		int k=st.executeUpdate("insert into bdnatABLE values(roll,'"+email+"','"+Table1+"','"+Table2+"','"+key+"')");
	    		if(k==0)
	    		{System.out.println("EncodingTable Not updated");}
	    		
	       } catch (Exception e) {
	    		System.out.println(" EncodingTable:->  " + e);

	    	}
		
		}
	}
	

