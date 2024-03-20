package com.servlet;

import java.io.IOException;

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
@WebServlet("/editQuestion")
public class EditQuestionServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String question=req.getParameter("question");
		String option1=req.getParameter("option_1");
		String option2=req.getParameter("option_2");
		String option3=req.getParameter("option_3");
		String option4=req.getParameter("option_4");
		String correctAnwser=req.getParameter("answer");
		String courseName=req.getParameter("course");
		int id=Integer.parseInt(req.getParameter("qid"));
		
		Question question2=new Question(id, question, option1, option2, option3, option4, correctAnwser, courseName);
		ExamDao dao=new ExamDao(DBConnect.getConn());
		boolean b=dao.UpdateQuestion(question2);
		HttpSession session=req.getSession();
		if (b) {
			session.setAttribute("succMsg","Question Updated Sucessfully...");
			resp.sendRedirect("question_list.jsp");
			
		}else {
			session.setAttribute("errorMsg","Question Not Updated...");
			resp.sendRedirect("editquestion.jsp");
			
		}
	}
	
	

}
