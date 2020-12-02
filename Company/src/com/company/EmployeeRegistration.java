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


public class EmployeeRegistration extends HttpServlet {
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
		int age=Integer.parseInt(request.getParameter("age"));
		String gender=request.getParameter("gender");
		long salary=Long.parseLong(request.getParameter("salary"));
		String designation=request.getParameter("designation");
		long mobile=Long.parseLong(request.getParameter("mobile"));
		String address=request.getParameter("address");
		String password=request.getParameter("password");
		String mail=request.getParameter("mail");
		String sql="insert into employee(firstname,lastname,age,gender,salary,designation,mobile,address,password,mailid) values(?,?,?,?,?,?,?,?,?,?)";
		try {
			pst=con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			pst.setString(1, firstname);
		pst.setString(2, lastname);
		pst.setInt(3, age);
		pst.setString(4, gender);
		pst.setLong(5, salary);
		pst.setString(6,designation);
		pst.setLong(7,mobile);
		pst.setString(8, address);
		pst.setString(9, password);
		pst.setString(10, mail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			int x=pst.executeUpdate();
		if(x!=0)
			response.sendRedirect("success.html?msg=registered");
		else
			writer.println("Unsuccessful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
