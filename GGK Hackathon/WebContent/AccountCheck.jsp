<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"  import="com.GGK.ConnectionHandler" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String email=request.getParameter("email");
session.setAttribute("email", email);
if(email ==null || email =="") { response.sendRedirect("Account.jsp");}
try{
			ResultSet rs=null;
			Connection con = ConnectionHandler.getConnection();
			Statement st=con.createStatement();
 			rs = st.executeQuery("select * from EmployeeTable where Email='"+email+"';");
 			if(rs.next()) 
 			{
 				rs.close();
 				response.sendRedirect("Login.jsp");
 			}
 			else
 			{
 				rs.close();
				response.sendRedirect("Register.jsp");
 			}
 			
}catch(Exception e){ out.println(e);
} %>

</body>
</html>