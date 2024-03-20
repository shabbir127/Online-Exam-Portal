package com.servlet_test;

import java.io.IOException;
import java.util.List;

import com.conn.DBConnect;
import com.dao.ExamDao;
import com.entity.Question;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/start")
public class TestServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String course=req.getParameter("course");
		String name=req.getParameter("username");
		ExamDao dao=new ExamDao(DBConnect.getConn());
		boolean b=dao.examdone(name, course);
		HttpSession session=req.getSession();
		RequestDispatcher rd;
       
		if (b) {

			req.setAttribute("status", "success");
			rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
			
		} else {
			
			List<Question> courseList = dao.findbyCourse(course);

			if (courseList != null) {

				session.setAttribute("coursedata", courseList);

				rd = req.getRequestDispatcher("testpage.jsp");
				rd.forward(req, resp);
			}
		}

	}

}
