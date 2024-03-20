package com.Student_Servlet;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.StudentDao;
import com.entity.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/")
public class Student_login  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sid=req.getParameter("sid");
		String name=req.getParameter("name");
		String pass=req.getParameter("password");
		
		StudentDao dao=new StudentDao(DBConnect.getConn());
		Student student=dao.studentlogin(sid, name ,pass);
		HttpSession session=req.getSession();
		RequestDispatcher rd;
		if (student != null) {
       	 session.setAttribute("loginuser",student.getName());
       	rd=req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
		} else {
			req.setAttribute("status", "failed");
			rd=req.getRequestDispatcher("Student_login.jsp");
			rd.forward(req, resp);
		}
		
	}
	
	

}
