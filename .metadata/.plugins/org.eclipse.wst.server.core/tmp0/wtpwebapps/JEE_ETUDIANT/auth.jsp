<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<form method="post" action="Login">
 <table style="border:solid 4px;">
  <tr>
   <td>UserName<td>
   <td><input type="text"name="login" required><td>
  </tr>
  
  <tr>
   <td>Password<td>
   <td> <input type="text" name="pwd" required> </td>
  </tr>
  
  <tr>
    <td clospan="2"><input type="submit" value="Se connecter"></td>
  </tr>
 </table>
</form>
</body>
</html>