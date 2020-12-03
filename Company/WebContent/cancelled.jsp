<%@ include file="connect.jsp" %>
<!DOCTYPE html>
<html>


<body bgcolor="wheat" align="center">
<h1>Leaves Exceeding</h1>
<%
String sql="select * from employee where id=?";
int id=(Integer)session.getAttribute("id");
pst=con.prepareStatement(sql);
pst.setInt(1,id);
ResultSet set=pst.executeQuery();
while(set.next())
{%>
<h3>Remaining leaves: </h3>
<%=set.getInt("total_leaves")%>
<%} %>
<h1><a href="./employee_home.jsp">Home</a></h1>

</body>

</html>