package com.servlet_test;

import java.io.IOException;
import java.util.List;

import com.entity.Question;
import com.entity.Student;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the list of questions from the session
        List<Question> questions = (List<Question>) request.getSession().getAttribute("coursedata");

        // Initialize variables to calculate score
        int totalQuestions = questions.size();
        int correctAnswers = 0;
        String course=null;
        // Loop through each question
        for (Question question : questions) {
            // Get the selected answer from the request parameters
            String selectedAnswer = request.getParameter(String.valueOf(question.getQid()));
           

            // Check if the selected answer is correct
            if (selectedAnswer != null && selectedAnswer.equals(question.getCorrectAnwser())) {
                correctAnswers++;
            }
          course=question.getCourseName();
        }

        // Calculate the score
        double score = ((double) correctAnswers / totalQuestions) * 100;
        String name=(String)request.getSession().getAttribute("loginuser");
        // Set score and total questions as request attributes
        request.setAttribute("score", score);
        request.setAttribute("totalQuestions", totalQuestions);
        request.setAttribute("courseName", course);
        request.setAttribute("name", name);
        request.setAttribute("obtainmark", correctAnswers);
        
        // Forward the request to the result.jsp page
        request.getRequestDispatcher("saveResult").forward(request, response);
    }
}