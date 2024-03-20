<%@page import="com.entity.Result"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.ExamDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Redirect to login page if not logged in
    if (session.getAttribute("loginuser") == null) {
        response.sendRedirect("Student_login.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%@include file="component/all_css.jsp" %>
    <title>Quiz Result</title>
</head>
<body>


<body class="bg-light">
<%@include file="component/navbar.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header">
					
					</div>
					<div class="card-body">

						
				<p class="text-center fs-3">Result</p>
				       <table class="table">
  <thead>
    <tr>
      <th scope="col">Course</th>
      <th scope="col">Percentage</th>
      <th scope="col">Obtain</th>
      <th scope="col">Total</th>
      
    </tr><%
String name = (String)session.getAttribute("loginuser");
ExamDao dao = new ExamDao(DBConnect.getConn());
List<Result> list = dao.getResult();
 
for(Result rs : list) {
    if(rs.getName().equals(name)) {
    	session.setAttribute("course",rs.getCourse() );
%>
    <tr>
        <td><%= rs.getCourse() %></td>
        <td><%= rs.getScore() %>%</td>
        <td><%= rs.getObtainMark() %></td>
        <td><%= rs.getTotalQuestions() %></td>
    </tr>
<% 
    } 
} 
%>

		 </thead>
   </table>
					</div>
				</div>
			</div>
		</div>

	</div>

  
    
    
</body>
</html>
