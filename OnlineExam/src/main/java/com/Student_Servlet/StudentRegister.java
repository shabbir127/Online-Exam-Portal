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
@WebServlet("/reg")
public class StudentRegister extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String sid=req.getParameter("sid");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String pass=req.getParameter("pass");
		String gender=req.getParameter("gender");
		String dob=req.getParameter("dob");
		String address=req.getParameter("address");
		String contact=req.getParameter("contact");
	   Student s =new Student(sid, name, email, pass, dob, gender, address, contact);
	   StudentDao dao=new StudentDao(DBConnect.getConn());
	   boolean f=dao.registerStudent(s);
	    RequestDispatcher rd=req.getRequestDispatcher("Student_registration.jsp");;
       HttpSession session=req.getSession();
       
	   if (f) {
		   session.setAttribute("succMsg","Your Student Id :-" + sid);
			
			req.setAttribute("status", "success");
			
			
		}else {
			req.setAttribute("status", "failed");	
			
		}
		rd.forward(req, resp);
	}
	
	
	}
	
	
	


