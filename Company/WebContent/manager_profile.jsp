<%@ page import="java.sql.*" %>
<%@ include file="connect.jsp" %>
<html>
<body bgcolor="wheat" align="center">
<%
String sql="select * from manager where id=?";
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
<th>Gender</th>
<th>Salary</th>
<th>Mobile</th>
<th>Address</th>
<th>MailId</th>
<th>EmployeeName</th>
</tr>
<tr>
<td><%=set.getString("firstname") %></td>
<td><%=set.getString("lastname") %></td>
<td><%=set.getString("gender") %></td>
<td><%=set.getLong("salary") %></td>
<td><%=set.getInt("mobile") %></td>
<td><%=set.getString("address") %></td>
<td><%=set.getString("mailid") %></td>
<td><%=set.getString("employeename") %></td>
</tr>
</table>
<%} %>
<a href="managerlogin.html">Logout</a>
</body>
</html>