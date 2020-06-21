<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"  import="com.GGK.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Register</title>
</head>

<script> 
          
            // Function to check Whether both passwords 
            // is same or not. 
            function checkPassword(form) { 
                password1 = form.password.value; 
                password2 = form.C_password.value; 
  
               
                      
                // If Not same return False.     
                 if (password1 != password2) { 
                    alert ("\nPassword did not match: Please try again...") 
                    return false; 
                } 
  
                // If same return True. 
                else{ 
                    return true; 
                } 
            } 
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
body{
   background-size: cover;
    background-attachment: fixed;
  background-image:url('back.jpg');
  background-repeat:no-repeat;
        color: #c71585 ;
}
input , select{
  width: 100%;
  padding: 10px 20px;
  margin: 8px 10px;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

input[type=submit],[type=reset]{
  width: 30%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 10px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type=reset]:hover {
color: black;
  background-color: #fffacd;
}
input[type=submit]:hover {
color: black;
  background-color: #fffacd;
}

#a{
color:black;
font-size:18px;
   background-color: #f2f2f2;
}

input:hover ,#a:hover{
color: black;
  background-color: #fffacd;
}

input[type=radio]{
  width: 15%;
  color: white;
  padding: 14px 20px;
  margin: 8px 10px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input:hover ,select:hover{
color: black;
  background-color: #fffacd;
}

.div {
  align:center;
  width:40%;
  border-radius: 5px;
}
center{padding-top:50px;}
</style>

<body>
<%
response.setHeader("Cache-Control","no-cache , no-store , must-revalidate"); 
String email = (String) session.getAttribute("email");
session.setAttribute("email", email);
if(email ==null || email =="") { response.sendRedirect("Account.jsp");}
%>


<center>
<div class="div"  >
<b><img src="logo.png" alt="smv" width="80" height="80"></b></br>

<h1><span><% out.println(email); %></span></h1>
<form action="<%=request.getContextPath() %>/RegistrationValidation.jsp"  id="myform" onSubmit = "return checkPassword(this)" >
<table><tr>
<td>Name:</td><td> <input type="text" name="Name" placeholder="Enter full Name" required 
    onkeypress="return (event.charCode > 64 && event.charCode < 91) || (event.charCode > 96 && event.charCode < 123) || (event.charCode = 32)"
 				   oninvalid="this.setCustomValidity('please update the highlighted mandatory fields')"
 				   oninput="this.setCustomValidity('')"></td></tr>

<tr><td>Date of Birth:</td> <td><input type="date" name="dob" required placeholder="yyyy-mm-dd"
                   oninvalid="this.setCustomValidity('please update the highlighted mandatory fields')"
                   oninput="this.setCustomValidity('')"></td></tr>
                   
<tr><td>Select Gender:</td><td><input type="radio" name="gender" id="male" value="male" ><label for="male">Male</label>
<input type="radio" name="gender" id="female" value="female" ><label for="female">Female</label></td></tr>
<tr><td>Phone number:</td><td> <input type="numeric" name="contactNo" size="10"  required pattern=[7,8,9]{1}[0-9]{9} placeholder="9123456789"
                   oninvalid="this.setCustomValidity('please update the highlighted mandatory fields')"
                   oninput="this.setCustomValidity('')"></td></tr>

<tr><td>Password:</td><td> <input type="password" name="password" size="10" required
                   oninvalid="this.setCustomValidity('please update the highlighted mandatory fields')"
                   oninput="this.setCustomValidity('')"></td></tr>
<tr><td>Confirm Password:</td><td> <input type="password" name="C_password"size="10" required
                   oninvalid="this.setCustomValidity('please update the highlighted mandatory fields')"
                   oninput="this.setCustomValidity('')"></td></tr>
<%
try{
			
			ResultSet rs=null;
			Connection con = ConnectionHandler.getConnection();
			Statement st=con.createStatement();
%>
<tr><td><label for="select">Choose Algorithm:</label></td><td> 
<select id="select" name="select" >
<!-- <option value="choose me">choose one</option> -->
<% rs = st.executeQuery("select * from AlgorithmTable;");
		    while(rs.next()){ %>
<option value="<%=rs.getString("Algorithm_Code")%>"required><%=rs.getString("Algorithm_Name")%></option>
<% } rs.close();%>
</select></td></tr>

</table>
<%}
catch(Exception e){ out.println(e);
} %>
</form>
<span style="font-size:40px;float:left;" class="fa" onclick="goBack()">&#xf060;</span>
<span style="font-size:40px;float: right;" class="fa" onclick="submitform()">&#xf061; </span>

</div>

</center>

</body>
</html>