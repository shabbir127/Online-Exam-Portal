<%@page import="com.entity.Result"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.ExamDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setDateHeader("Expires", 0); // Proxies

if(session.getAttribute("loginuser")==null)
{
	response.sendRedirect("Student_login.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quiz Result</title>
    <%@include file="component/all_css.jsp" %>
    
</head>
<body>
    <%@include file="component/navbar.jsp" %>
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <div class="card">
                    <div class="card-header"></div>
                    <div class="card-body">
                        <h1>Quiz Result</h1>
                        <p>Your score: <%= request.getAttribute("score") %>%</p>
                         <p>Obtain Mark: <%= request.getAttribute("obtainmark") %></p>
                        <p>Total questions: <%= request.getAttribute("totalQuestions") %></p>
                        
                        <div class="text-center mb-2">
                            <a href="Allresult.jsp" class="signup-image-link">Result</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
