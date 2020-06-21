<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.sql.*" import="com.GGK.*" import="java.lang.*" %>
<%@page import="com.GGK.BDNA.*"  import="java.lang.reflect.*" %>
<%@page import="com.GGK.Algorithm.*" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Password</title>
        <base target="_blank" rel="noopener noreferrer">
    </head>
    <style>
*,body{
	font-family: Optima,Segoe,Segoe UI,Candara,Calibri,Arial,sans-serif; 
}
</style>
<style>
body, html {
  background-size: cover;
  background-attachment: fixed;
  background-repeat:no-repeat;
  background-image: url('fr3.jpg');
}

.bgimg {

  height: 100%;
  color: white;
  font-family: "Courier New", Courier, monospace;
  font-size: 22px;
}
.middle {
  position: absolute;
  padding-top: 200px;
  padding-left: 200px;
  text-align: center;
}

hr {
  margin: auto;
  width: 40%;
}
</style>
<body>
<%
response.setHeader("Cache-Control","no-cache , no-store , must-revalidate");
String email = (String) session.getAttribute("email");
session.setAttribute("email", email);
if(email ==null || email=="") { response.sendRedirect("Account.jsp"); }
String Dec_pass = "";
String status = "";
try { 
		Connection con = ConnectionHandler.getConnection();
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from EmployeeTable where Email='" + email + "';");
		
		if(rs.next()) {
			/* if(Integer.parseInt(rs.getString("Session")) == 0 ){ status = ""; }
			else { status = "You Have "+rs.getString("Session")+" Active Sessions"; }
			 */
		 	Dec_pass  = decPass.decrypt(rs.getString("Password"),email);
		 	rs.close();
		
		}
	} catch (Exception e) {
		System.out.println(" LoginCheck.jsp  " + e);

	} %>
<div class="bgimg" id="vi">
  <div class="middle">
    <h3>Your Floating Password:</h3>
    <p>Password is in between ~</p>
    <h3 >~<i><%= Dec_pass%></i>~</h3>
    <hr>
    <h5>Time Left:-</h5>
    <p id="demo" style="font-size:30px"></p>
  </div>
</div>
</body>

	
<script>
// Set the date we're counting down to
var countDownDate = new Date();
countDownDate.setSeconds(countDownDate.getSeconds() + 25);

// Update the count down every 1 second
var countdownfunction = setInterval(function() {

  // Get todays date and time
  var now = new Date().getTime();
  
  // Find the distance between now an the count down date
  var distance = countDownDate - now;
  var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
  var seconds = Math.floor((distance % (1000 * 60)) / 1000);
  
  // Output the result in an element with id="demo"
  document.getElementById("demo").innerHTML = minutes + "m " + seconds + "s ";
  
  // If the count down is over, write some text 
  if (distance < 0) {
    clearInterval(countdownfunction);
    document.getElementById("demo").innerHTML = "EXPIRED";
    document.getElementById("vi").innerHTML = "";
  }
}, 1000);
</script>


</html>
