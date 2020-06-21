<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" import="com.GGK.*" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="svm_style.css">
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<style>
*,body{
	font-family: Optima,Segoe,Segoe UI,Candara,Calibri,Arial,sans-serif;
 
}
h1{
padding-top:200px;}
footer{
padding-top:400px;
}

</style>
<body>
   
 <div id="navbar">
  <span id="logo"><img  src="logo.png" height="120px" width="120px" ></span>
  <div id="navbar-right">
    <a class="active" href="Loggedin.jsp">Home</a>
    <a href="#">Details</a>
    <a href="Logout.jsp">Logout</a>
  </div>
</div>


    
<% response.setHeader("Cache-Control","no-cache , no-store , must-revalidate"); 
String email = (String) session.getAttribute("email"); 
if(email==null || email==""){response.sendRedirect("Account.jsp");}
try { 
	
	Connection con = ConnectionHandler.getConnection();
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery("select * from EmployeeTable where Email='" + email + "';");
	if(rs.next()) { %>
	<center><h1>Welcome <%=rs.getString("Name")  %></h1></center>
	<%	}
	
} catch (Exception e) {
	out.println("Loggedin.jsp " + e);

}
	%>

<div style="padding-top:470px;"></div>
<div id="footer"> <center><p><b><b>&middot;</b></b> SMV <b><b>&middot;</b></b> copyright &copy; <b><b>&middot;</b></b></p></center></div> 

</body>
</html>