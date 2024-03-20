package com.servlet_admin;

import java.io.IOException;
import java.sql.PreparedStatement;

import com.conn.DBConnect;
import com.dao.AdminDao;
import com.entity.Admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/admin_login")
public class AdminLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		
		AdminDao dao=new AdminDao(DBConnect.getConn());
		Admin admin=dao.adminlogin(name, pass);
		HttpSession session=req.getSession();
		RequestDispatcher rd;
		if (admin != null) {
       	 session.setAttribute("admin",admin.getAdname());
			resp.sendRedirect("adminhome.jsp");
		} else {
			req.setAttribute("status", "failed");
			rd=req.getRequestDispatcher("adminlogin.jsp");
			rd.forward(req, resp);
		}
		
	}

	
	
}
