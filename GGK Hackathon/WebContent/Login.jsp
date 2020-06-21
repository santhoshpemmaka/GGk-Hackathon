<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.sql.*" import="com.GGK.*" import="java.lang.*" %>
<%@page import="com.GGK.BDNA.*"  import="java.lang.reflect.*" %>
<%@page import="com.GGK.Algorithm.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Login</title>
</head>
<script type="text/javascript">
function goBack(){
	window.history.back();
}
function submitform(){
	document.getElementById("myform").submit();
}
</script>
<style>
*,body{
	font-family: Optima,Segoe,Segoe UI,Candara,Calibri,Arial,sans-serif; 
}
</style>
<style>
body,a{
   background-size: cover;
    background-attachment: fixed;
  background-image:url('back.jpg');
  background-repeat:no-repeat;
        color: #c71585 ;
}
input {
  width: 80%;
  padding: 12px 20px;
  margin: 20px 10px;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
input[type=submit]{
  float: right;
  width: 30%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 10px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input:hover {
color: black;
  background-color: #fffacd;
}
.div {
  align:center;
  width:40%;
  border-radius: 5px;
}
center{
padding-top:100px;
}
</style>
<body>

<%
response.setHeader("Cache-Control","no-cache , no-store , must-revalidate");
String email = (String) session.getAttribute("email");
session.setAttribute("email", email);
if(email ==null || email=="") { response.sendRedirect("Account.jsp"); }
String status = "";
try { 
		Connection con = ConnectionHandler.getConnection();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from EmployeeTable where Email='" + email + "';");
		
		if(rs.next()) {
			if(Integer.parseInt(rs.getString("Session")) == 0 ){ status = ""; }
			else { status = "You Have "+rs.getString("Session")+" Active Sessions"; }
			
		 String Dec_pass  = decPass.decrypt(rs.getString("Password"),email);
		 rs.close();
		}
		} catch (Exception e) {
			System.out.println(" LoginCheck.jsp  " + e);

		} %>
<center >		 
<div class="div"  >
<b><img src="logo.png" alt="smv" width="80" height="80"></b></br></br></br>


<h2><%=email %></h2>
<div style="color:red;"><%=status %></div>

<form action="<%=request.getContextPath() %>/LoginCheck.jsp"  id="myform">
<label for="password" style="font-size:20px;float:left;padding-left:60px;"><b><a href="PasswordView.jsp" target="_blank"><span>Password</span></a></b></label>
<input type="password" name="password" required placeholder="Enter New Password"
oninvalid = "this.setCustomValidity('please update the highlighted mandatory fields')"
oninput = "this.setCustomValidity('')" ></br>
<span style="font-size:40px;float:left;" class="fa" onclick="goBack()">&#xf060;</span>
<span style="font-size:40px;float: right;" class="fa" onclick="submitform()">&#xf061; </span>
</form>
</div>
</center>
	
 


 
</body>
</html>