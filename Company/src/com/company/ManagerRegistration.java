package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManagerRegistration
 */

public class ManagerRegistration extends HttpServlet {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer=response.getWriter();
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		long mobile=Integer.parseInt(request.getParameter("mobile"));
		String gender=request.getParameter("gender");
		long salary=Long.parseLong(request.getParameter("salary"));
		String address=request.getParameter("address");
		String emp_name=request.getParameter("employee");
		String password=request.getParameter("password");
		String mail=request.getParameter("mail");
		String sql="insert into manager(firstname,lastname,mobile,gender,salary,address,employeename,password,mailid) values(?,?,?,?,?,?,?,?,?)";
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, firstname);
			pst.setString(2,lastname);
			pst.setLong(3, mobile);
			pst.setString(4, gender);
			pst.setLong(5, salary);
			pst.setString(6, address);
			pst.setString(7, emp_name);
			pst.setString(8, password);
			pst.setString(9, mail);
			int x=pst.executeUpdate();
			if(x!=0)
				response.sendRedirect("managersuccess.html?msg=registered");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
