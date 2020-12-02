<%@ page import="java.sql.*" %>
<% 
Connection con=null;
PreparedStatement pst=null;
Class.forName("com.mysql.cj.jdbc.Driver");
String url="jdbc:mysql://localhost:3306/company";
  String user="root";
  String pwd="root";
  con=DriverManager.getConnection(url,user,pwd);
%>