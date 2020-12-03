package com.company;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con=null;
	  PreparedStatement pst=null;
  public void init(ServletConfig config)
  {
	  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  String url="jdbc:mysql://localhost:3306/company";
	  String user="root";
	  String pwd="root";
	  try {
		con=DriverManager.getConnection(url,user,pwd);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		String mail=request.getParameter("mail");
		String password=request.getParameter("password");
		String sql="select * from employee where mailid=? and password=?";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, mail);
			pst.setString(2, password);
			ResultSet set=pst.executeQuery();
			if(set.next())
			{
				session.setAttribute("id", set.getInt("id"));
				session.setAttribute("leaves",set.getInt("total_leaves"));
				response.sendRedirect("employee_home.jsp");
			}
			else
			{
				response.sendRedirect("unsuccess.html");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
