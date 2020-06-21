<%@page import="com.GGK.BDNA.*" %>
<%@page import="com.GGK.Algorithm.*" %>
<%@page import="java.sql.*" import="com.GGK.*"  import="java.lang.reflect.*" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Validation</title>
</head>
<body>
<%
		String name=request.getParameter("Name");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		String P_no=request.getParameter("contactNo");
		String password=request.getParameter("password");
		String Algorithm_Code=request.getParameter("select");		

		String email = (String) session.getAttribute("email");
		session.setAttribute("email", email);
		java.util.Date date = new java.util.Date();
	 try{
			 
			 Connection con=ConnectionHandler.getConnection();
			 Statement st=con.createStatement();
    		 
			 if(email ==null || email =="") { response.sendRedirect("Account.jsp");}
    		 else
    		 {
            	 String Enc_pswd="";
            	 String New_pswd="";
            	 session.setAttribute("email", email);
            	
            	 New_pswd = ClassNewPassword.GenerateNewPassword(Algorithm_Code, password);
            	 
            	 int ins=st.executeUpdate("insert into EmployeeTable values('"+name+"','"+gender+"','"+email+"','"+P_no+"','"+password+"','"+Algorithm_Code+"','1','"+date+"','1',null)");
                 
            	 String key = binarykey.binaryKey(date+"" , P_no);
            	 encodingTable.Table(email,key);
            	 Enc_pswd = encPass.encrypt(New_pswd,email);
            	 
            	 int upd=st.executeUpdate("update EmployeeTable set password='"+Enc_pswd+"' where email='"+email+"' ;");
                 
                 response.sendRedirect("Loggedin.jsp");
             
    		 }
    		 
             }catch(Exception exception){
            	 out.println("register jsp  "+exception);
            	 }
		%>

</body>
</html>