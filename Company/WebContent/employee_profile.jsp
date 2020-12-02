<%@ page import="java.sql.*" %>
<%@ include file="connect.jsp" %>
<html>
<body bgcolor="wheat" align="center">
<%
String sql="select * from employee where id=?";
int id=(Integer)session.getAttribute("id");
pst=con.prepareStatement(sql);
pst.setInt(1,id);
ResultSet set=pst.executeQuery();
while(set.next())
{
%>
<table border="2" align="center">
<tr>
<th>FirstName</th>
<th>LastName</th>
<th>Age</th>
<th>Gender</th>
<th>Salary</th>
<th>Designation</th>
<th>Mobile</th>
<th>Address</th>
<th>MailId</th>
</tr>
<tr>
<td><%=set.getString("firstname") %></td>
<td><%=set.getString("lastname") %></td>
<td><%=set.getInt("age") %></td>
<td><%=set.getString("gender") %></td>
<td><%=set.getLong("salary") %></td>
<td><%=set.getString("designation") %></td>
<td><%=set.getInt("mobile") %></td>
<td><%=set.getString("address") %></td>
<td><%=set.getString("mailid") %></td>
</tr>
</table>
<%} %>
<a href="employeelogin.html">Logout</a>
</body>
</html>