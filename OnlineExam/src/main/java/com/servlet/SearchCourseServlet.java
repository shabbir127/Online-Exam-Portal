package com.servlet;

import java.io.IOException;
import java.util.List;

import com.conn.DBConnect;
import com.dao.ExamDao;
import com.entity.Question;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/searchCourse")
public class SearchCourseServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String courseName=req.getParameter("courses");
		ExamDao dao=new ExamDao(DBConnect.getConn());
		List<Question> search=dao.findbyCourse(courseName);
		HttpSession session=req.getSession();
		if (search != null) {
			
			session.setAttribute("course",search);
			session.setAttribute("succMsg","Here's the result "+courseName);
			resp.sendRedirect("question_list.jsp");
		}else {
		
			session.setAttribute("errorMsg","No DATA Found");
			resp.sendRedirect("question_list.jsp");
		}
	}
	
	
	

}
