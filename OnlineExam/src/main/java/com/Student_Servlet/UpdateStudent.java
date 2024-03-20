package com.Student_Servlet;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.StudentDao;
import com.entity.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/edit_student")
public class UpdateStudent extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sid=req.getParameter("sid");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String gender=req.getParameter("gender");
		String dob=req.getParameter("dob");
		String address=req.getParameter("address");
		String contact=req.getParameter("contact");
		Student student=new Student(sid, name, email, dob, gender, address, contact);
		StudentDao dao=new StudentDao(DBConnect.getConn());
		boolean f=dao.UpdateStudent(student);
		HttpSession session=req.getSession();
		if (f) {
			session.setAttribute("succ","Student details Updated Sucessfully...");
			resp.sendRedirect("student_list.jsp");
			
		}else {
			session.setAttribute("error","Student Not Updated , please try again");
			resp.sendRedirect("edit_student.jsp");
			
		}
		
	}
	
	

}
