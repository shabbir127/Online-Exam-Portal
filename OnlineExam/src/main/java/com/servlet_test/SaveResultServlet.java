package com.servlet_test;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.ExamDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/saveResult")
public class SaveResultServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=(String) req.getAttribute("name");
		String course=(String) req.getAttribute("courseName");
		double score=(double) req.getAttribute("score");
		int ObtainMark=(int)req.getAttribute("obtainmark");
		int totalQuestions= (int) req.getAttribute("totalQuestions");
		ExamDao dao=new ExamDao(DBConnect.getConn());
		boolean b=dao.resultsave(name, course, score, totalQuestions,ObtainMark);
		HttpSession session=req.getSession();
		RequestDispatcher rd;
		if (b) {
			session.setAttribute("succMsg","Student details Updated Sucessfully...");
			rd=req.getRequestDispatcher("result.jsp");
			rd.forward(req, resp);
			
		}else {
			session.setAttribute("errorMsg","Student Not Updated , please try again");
			resp.sendRedirect("home.jsp");
			
		}
		
		
		
	}
	
	

}
