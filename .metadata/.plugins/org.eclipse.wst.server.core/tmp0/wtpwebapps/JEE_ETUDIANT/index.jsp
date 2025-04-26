<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*"%>
    <% 
    String login="";
    if (session.getAttribute("login")!=null){
    	login=session.getAttribute("login").toString();
    }else{
    	response.sendRedirect("auth.jsp");
    }
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
 <div align="right">
 Bonjur <%=login %><br>
 <a href="Logout">Logout</a>
 
 </div>
 <h1>Liste des etudiants</h1>
 <table border="1" width="100%">
  <tr>
   <th>ID</th>
   <th>Name</th>
   <th>Date Inscription</th>
   <th>Sexe</th>
  </tr>
  <%
  String url = "jdbc:mysql://localhost:3306/JEE_APP";
  String username = "root";
  String password = "";
  
  try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con = DriverManager.getConnection(url, username, password);
      PreparedStatement pst = con.prepareStatement("SELECT * FROM etudiant");
      ResultSet rs = pst.executeQuery();
      
      while(rs.next()){
    	  %>
			   <tr>
				   <td><%=rs.getString(1)%></td>
				   <td><%=rs.getString(2)%></td>
				   <td><%=rs.getString(3)%></td>
				   <td><%=rs.getString(4)%></td>
			   </tr>
    	  <% 
    	  
      }
      
      rs.close();
      pst.close();
      con.close();
      
  } catch (Exception e) {
      System.out.print(e);
  }
  %>
  
 </table>
</body>
</html>