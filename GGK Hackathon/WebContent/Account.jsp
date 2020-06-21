<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Account</title>
</head>
<style>
*,body{
	font-family: Optima,Segoe,Segoe UI,Candara,Calibri,Arial,sans-serif; 
}
</style>
<script>
function goBack(){
	window.history.back();
}
function submitform(){
document.getElementById("myform").submit();
}
</script> 

<style>
body{
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
input[type=submit],button{
float:right;
  width: 25%;
  color: #c71585;
  padding: 14px 20px;
  margin-right:50px;
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
    max-width: 40%;
    margin: auto;
}
center{
padding-top:150px;
}
</style>
<body>
<center >
<div class="div" >
<b><img src="logo.png" alt="smv" width="80" height="80"></b></br></br></br>

<strong style="font-size:24px;padding-top:20px;">Enter Account Details</strong> 
<form action="<%=request.getContextPath() %>/AccountCheck.jsp" onSubmit = 'return validate();' id="myform">
<!-- <label for="email"><b>Email:-</b></label> -->
<input type="email" name="email" placeholder="Enter E-mail Id" required 
oninvalid="this.setCustomValidity('please Enter the Mail')"
oninput="this.setCustomValidity('')"></br>
</form>
<span style="font-size:40px;float:left;" class="fa" onclick="goBack()">&#xf060;</span>
<span style="font-size:40px;float: right;" class="fa" onclick="submitform()">&#xf061; </span>

</div>
</center>
</body>
</html>