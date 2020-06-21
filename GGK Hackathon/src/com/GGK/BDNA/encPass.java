package com.GGK.BDNA;

import java.util.*;
import java.util.concurrent.TimeUnit;

import com.GGK.ConnectionHandler;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class encPass {
	public static String str_Table1 = "";
	public static String str_Table2 = "";
	public static String pass = "";
	public static String key = "", key_n = "";
	public static int n;
	public static int int_key, i1;
	
	/*
	 * public static void main (String[] args) throws Exception {
	 * 
	 * System.out.println((encrypt("Somesh","")));
	 * 
	 * }
	 */
	 

	public static String encrypt(String pswd, String email) throws IOException {

		  long startTime = System.nanoTime();
		
		  try {
		  
		  Connection con = ConnectionHandler.getConnection(); Statement st =
		  con.createStatement(); ResultSet rs
		  =st.executeQuery("select * from bdnatABLE where email ='"+email+"';");
		  if(rs.next()) {
		  
		  str_Table1 = rs.getString("Table1_data"); 
		  str_Table2 =rs.getString("Table2_data"); 
		  key_n = rs.getString("key_N");
		  
		  } rs.close(); 
		  } catch (Exception e) { System.out.println(" Encryption:->  " + e); }
		 
		/*
		 * str_Table1
		 * ="/#R|s?vgA2\"Zd+('5<z1SDU^h$tGw>K*k{9r0~N&mTQ8]cHl_Joyx`7.@a=VubpB\\L;4Cj)n6X!fe[W3,}-:%YMIPqOEF i"
		 * ; str_Table2
		 * ="OiVNWqkZB8og60rSfYxabsCcAJRy,I5e71QKUpXvFmn9hl.E3LGdTDH2uPtMzwj4"; key_n =
		 * "1111100001010095";
		 */
		
		key = key_n.substring(0, 14);
		n = Integer.parseInt(key_n.substring(14, key_n.length()));

		String Enc_pswd = "";

		pass = pswd;

		// readFile();
		// GenerateKeys.main(null);
		// keyEncryption.main(null);

		// keyfile();
		int_key = extractKey();
		str_Table1 = rightrotate(str_Table1, n); // Shuffling Table1 n times

		int len = pass.length();
		if (len % 2 == 1) {
			pass += " ";
			len++;
		}
		// System.out.println("len "+len);
		String s1 = "", s2 = "";
		s1 = convert(0, len - 1);
		int len_s1;

		len_s1 = s1.length();
		// System.out.println("s1 : "+s1+" length s1: "+len_s1);
		String sp1 = s1.substring(0, len_s1 / 2);
		// System.out.println("sp1 :"+sp1);
		sp1 = leftrotate(sp1, 1);
		// System.out.println("sp1 after leftrotate:"+sp1);
		String sp2 = s1.substring(len_s1 / 2, len_s1);
		// System.out.println("sp2 :"+sp2);
		sp2 = rightrotate(sp2, 1);
		// System.out.println("sp2 after right rotate :"+sp2);
		s2 = sp2 + sp1;
		// System.out.println("s2 :"+s2+" s2 Length :"+s2.length());

		if (len_s1 % 6 != 0) {
			s2 = s2 + "0".repeat(6 - len_s1 % 6);
		}

		// System.out.println("s2 length after padding: "+s2.length());

		for (int i = 0; i < s2.length(); i = i + 6) {
			String sub1 = s2.substring(i, i + 6);
			// System.out.println(sub1);
			int i2 = Integer.parseInt(sub1, 2);
			// System.out.println(i2);
			Enc_pswd = Enc_pswd + str_Table2.charAt(i2);
		}

		long endTime = System.nanoTime();

		long durationInNano = (endTime - startTime); // Total execution time in nano seconds
		long durationInMillis = TimeUnit.NANOSECONDS.toMillis(durationInNano); // Total execution time in milli seconds
		float sec = (durationInMillis) / 1000F; // Total execution time in seconds

		/*
		 * System.out.println(durationInNano+ " ns");
		 * System.out.println(durationInMillis+ " ms"); System.out.println(sec
		 * +" seconds");
		 */

		// System.out.println(Enc_pswd);
		return Enc_pswd;

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

	public static int extractKey() {
		String extracted_key = "";

		// Extracting 7-bit key input based on 1st bit. If 1st bit is 1 extract odd bits
		// else even bits.
		// System.out.println(key);

		if (key.charAt(0) == '0') {
			for (int i = 0; i < 14; i = i + 2) {
				extracted_key = extracted_key + key.charAt(i);
			}
		} else if (key.charAt(0) == '1') {
			for (int i = 1; i < 14; i = i + 2) {
				extracted_key = extracted_key + key.charAt(i);
			}
		} else
			System.out.println("Key should be in binary format");

		// System.out.println("extracted_key :"+extracted_key);
		return (Integer.parseInt(extracted_key, 2));
	}

	static String leftrotate(String str, int d) {
		String ans = str.substring(d) + str.substring(0, d);
		// System.out.println("rotate :"+ans);
		return ans;
	}

	// function that rotates s towards right by d

	static String rightrotate(String str, int d) {
		return leftrotate(str, str.length() - d);
	}

	public static String convert(int start, int end) {
		if (start == end) {
			char c = pass.charAt(start);
			// System.out.println(c);
			i1 = str_Table1.indexOf(c);
			i1 = i1 ^ int_key;
			String t = Integer.toBinaryString(i1);
			t = "0".repeat(7 - t.length()) + t;
			return t;

		}
		return (convert(start, (start + end) / 2) + convert(((start + end) / 2) + 1, end));
	}

}
