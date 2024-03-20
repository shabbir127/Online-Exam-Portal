package com.servlet;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.ExamDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteQuestionServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		int id=Integer.parseInt(req.getParameter("id"));
		ExamDao dao=new ExamDao(DBConnect.getConn());
		boolean f=dao.deleteQuestion(id);
		HttpSession session=req.getSession();
		if (f) {
			session.setAttribute("succMsg","Question Delete  Sucessfully...");
			resp.sendRedirect("question_list.jsp");
			
		}else {
			session.setAttribute("errorMsg","Delete Fail Sucessfully...");
			resp.sendRedirect("question_list.jsp");
			
		}
	
	}
	
	

}
