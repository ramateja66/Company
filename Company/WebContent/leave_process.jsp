<%@ include file="connect.jsp" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.temporal.ChronoUnit" %>
<%
int leaves=(Integer)session.getAttribute("leaves");
int id=(Integer)session.getAttribute("id");
String startDate=request.getParameter("start_date");
String endDate=request.getParameter("end_date");
LocalDate date1=LocalDate.parse(startDate);
LocalDate date2=LocalDate.parse(endDate);
long days=ChronoUnit.DAYS.between(date1, date2);
 if(days<=leaves)
 {
	String sql1="update employee set total_leaves=total_leaves-? where id=?";
	pst=con.prepareStatement(sql1);
	pst.setLong(1,days);
	pst.setInt(2,id);
	int i=pst.executeUpdate();
	if(i!=0)
	response.sendRedirect("./granted.jsp");
}
else
{
	response.sendRedirect("./cancelled.jsp");
}
%>
