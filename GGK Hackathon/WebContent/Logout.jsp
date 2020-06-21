<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.GGK.BDNA.*"  import="java.lang.reflect.*" %>
<%@page import="com.GGK.Algorithm.*" %>
    <%@ page import="java.sql.*" import="com.GGK.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>logout</title>
</head>
<body>
<% 
String email = (String) session.getAttribute("email");
java.util.Date date = new java.util.Date();
try { 
	
	Connection con = ConnectionHandler.getConnection();
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("select * from EmployeeTable where Email='" + email + "';");
	
	if(rs.next()) {
		
		int Session = Integer.parseInt(rs.getString("Session"))-1;
		rs.close();
		
		int upd=st.executeUpdate("update EmployeeTable set Session="+Session+" , Last_Logout_Time='"+date+"' where email='"+email+"' ;");
		
		if(upd!=0){	
			session.removeAttribute("email");
			session.setAttribute("email",email);
			session.invalidate();
			response.sendRedirect("Home_main.html"); 
		}
		else
		{response.sendRedirect("Loggedin.jsp");}
	}
	
} catch (Exception e) {
	out.println(" LoginCheck.jsp  " + e);
}

%>


</body>
</html>