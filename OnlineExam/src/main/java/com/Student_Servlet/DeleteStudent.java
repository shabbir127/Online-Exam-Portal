package com.Student_Servlet;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/delete_student")
public class DeleteStudent extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    HttpSession session = req.getSession(); // Initialize session

	    String name = (String) session.getAttribute("admin");
	    if (name == null) {
	        resp.sendRedirect("adminLogin.jsp");
	    } else {
	        String sid = req.getParameter("id");
	        StudentDao dao = new StudentDao(DBConnect.getConn());
	        boolean f = dao.deleteStudent(sid);

	        if (f) {
	            session.setAttribute("succ", "Student deleted successfully.");
	            resp.sendRedirect("student_list.jsp");
	        } else {
	            session.setAttribute("error", "Failed to delete student.");
	            resp.sendRedirect("student_list.jsp");
	        }
	    }
	}

	

}
