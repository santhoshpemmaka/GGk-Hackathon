<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.GGK.BDNA.*"  import="java.lang.reflect.*" %>
<%@page import="com.GGK.Algorithm.*" %>
    <%@ page import="java.sql.*" import="com.GGK.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginCheck</title>
</head>
<body>

<%
response.setHeader("Cache-Control","no-cache , no-store , must-revalidate"); 
String email = (String) session.getAttribute("email");
session.setAttribute("email", email);
String password = request.getParameter("password");

java.util.Date date = new java.util.Date();

		if(email == null || email == ""){ response.sendRedirect("Account.jsp"); }

try { 
	
	Connection con = ConnectionHandler.getConnection();
	Statement st = con.createStatement();
	
	ResultSet rs = st.executeQuery("select * from EmployeeTable where Email='" + email + "';");
	
	if(rs.next()) {
		
	 String Dec_pass = decPass.decrypt(rs.getString("Password"),email);
	 System.out.println(Dec_pass+"end"+password);
			if (password.equals(Dec_pass))
			{
				String Enc_pswd="";
	           	String New_pswd="";
	           	int loginNumber = Integer.parseInt(rs.getString("Login_Number"))+1;
	           	int Session = Integer.parseInt(rs.getString("Session"))+1;
	           	New_pswd = ClassNewPassword.GenerateNewPassword(rs.getString("Algorithm_Code"), password);
	           	Enc_pswd = encPass.encrypt(New_pswd,email);
	           	rs.close();
	           	
	           	int upd=st.executeUpdate("update EmployeeTable set password='"+Enc_pswd+"', Session="+Session+", Login_Number="+loginNumber+", Last_Login_Time='"+date+"'where email='"+email+"' ;");
	           	
				response.sendRedirect("Loggedin.jsp");
			}
			else 
			{
				response.sendRedirect("Login.jsp");
			}
		
	}
	else {
		response.sendRedirect("Account.jsp");
	}

} catch (Exception e) {
	out.println(" LoginCheck.jsp  " + e);
}


 %>
</body>
</html>