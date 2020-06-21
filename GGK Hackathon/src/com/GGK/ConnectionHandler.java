package com.GGK;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionHandler {
	
	public static Connection getConnection(){
		Connection con = null;
		try{
			Class.forName(ReadProperties.getProperties("className"));
			con = DriverManager.getConnection(ReadProperties.getProperties("dbUrl"),ReadProperties.getProperties("dbUser"),ReadProperties.getProperties("dbPassword"));
		}
		catch(Exception e){
			
		}
		return con;
	}

}
