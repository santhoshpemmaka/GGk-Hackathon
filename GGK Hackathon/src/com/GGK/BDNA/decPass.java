package com.GGK.BDNA;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.GGK.ConnectionHandler;

public class decPass {


	public static String enc_pass="";
	//public static String dec_pass="";
	public static  int n;
	public static String key="",key_n="";
	public static int int_key,i1;
	public static String str_Table1="";
	public static String str_Table2="";
	public static String Table[]= {"",""};

	static String leftrotate (String str, int d)
	  {
	    String ans = str.substring (d) + str.substring (0, d);
	      return ans;
	  }

	  // function that rotates s towards right by d  
	  static String rightrotate (String str, int d)
	  {
	    return leftrotate (str, str.length () - d);
	  }
	  
		

	
	public static int extractKey() {
		String extracted_key = "";

	    //Extracting 7-bit key input based on 1st bit. If 1st bit is 1 extract odd bits else even bits.
		//System.out.println(key);
	    if (key.charAt (0) == '0')
	      {
	    		for (int i = 0; i < 14; i = i + 2)
	    		{
	    				extracted_key = extracted_key + key.charAt (i);
	    		}
	      }
	    else if(key.charAt (0) == '1')
	      {
	    		for (int i = 1; i < 14; i = i + 2)
	    		{
	    				extracted_key = extracted_key + key.charAt (i);
	    		}
	      }
	    else System.out.println("Key should be in binary format"); 
	    																				//System.out.println("key_n:"+key+" "+n);
																						//System.out.println("extracted_key :"+extracted_key);
	    return  (Integer.parseInt (extracted_key, 2));
	}
	
	
	
	/*
	 * public static void keyfile()throws IOException { FileInputStream
	 * inputStream=null; Scanner sc=null; try { inputStream=new
	 * FileInputStream("key.txt"); sc=new Scanner(inputStream,"UTF-8");
	 * while(sc.hasNextLine()) { String s=sc.nextLine(); key=s.substring(0,14);
	 * n=Integer.parseInt(s.substring(14,s.length()));
	 * 
	 * } if(sc.ioException()!=null) throw sc.ioException();
	 * 
	 * } finally { if(inputStream!=null) inputStream.close(); if(sc!=null)
	 * sc.close(); } }
	 */
	
	public static String decrypt(String enc_pswd, String email)throws Exception
	{
		long startTime = System.nanoTime();
		

		String sp1="",sp2="",msg1="";
		String dec_pass="";
		try { 
    		
    		Connection con = ConnectionHandler.getConnection();
    		Statement st = con.createStatement();
    		ResultSet rs =st.executeQuery("select * from bdnatABLE where email='"+email+"' ;");
    		if(rs.next())
    		{
    			str_Table1 = rs.getString("Table1_data");
    			str_Table2 = rs.getString("Table2_data");
    			key_n = rs.getString("key_N");
    		}
    		rs.close();
			} catch (Exception e) {
    		System.out.println(" Decryption:->  " + e);
			}
		
		 key=key_n.substring(0,14);
		 n=Integer.parseInt(key_n.substring(14,key_n.length()));
		
		enc_pass= enc_pswd;
		//keyfile();
		str_Table1 = rightrotate (str_Table1, n); 
		int_key=extractKey();
		for(int i=0;i<enc_pass.length();i++)
		{
			char cha=enc_pass.charAt(i);
			int index=str_Table2.indexOf(cha);
			String t=Integer.toBinaryString (index);
			
			msg1+="0".repeat(6-t.length())+t;

		} 
		
		
		int xtra=msg1.length()%7;
		int len=msg1.length()-xtra;
		sp1=msg1.substring(0,len/2);
		    sp1=leftrotate(sp1,1);
		sp2=msg1.substring(len/2,len);
		    sp2=rightrotate(sp2,1);
		msg1=sp2+sp1;
		//System.out.println(msg1);
		for(int i=0;i<len;i=i+7)
		{
			String sub1=msg1.substring(i,i+7);
		       // System.out.println(sub1);
		        int i2=Integer.parseInt(sub1,2);
			i2=i2^int_key;
			//System.out.println(i2);
			//System.out.print(str_Table1.charAt(i2));
			
			dec_pass = dec_pass +str_Table1.charAt(i2);
		}
		
		
		
		long endTime = System.nanoTime();
		 
	    long durationInNano = (endTime - startTime); 						    //Total execution time in nano seconds
	    long durationInMillis = TimeUnit.NANOSECONDS.toMillis(durationInNano);  //Total execution time in milli seconds
	    float sec = (durationInMillis) / 1000F; 								//Total execution time in seconds
	    
		
		/*
		 * System.out.println(durationInNano+ " ns");
		 * System.out.println(durationInMillis+ " ms");
		 * System.out.println(sec +" seconds");
		 */
		return dec_pass;
	}
	


	/*
	 * public static void main (String[] args) throws Exception {
	 * 
	 * System.out.println(decrypt("",""));
	 * 
	 * }
	 */
	 
	
}
 