<%@page import="com.entity.Question"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.ExamDao"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%@ include file="component/all_css.jsp" %>
<style type="text/css">
.card-sh {
    box-shadow: 0 0 6px 0 rgba(0,0,0,0.3);
}
</style>
	
</head>
<%@ include file="component/navbar.jsp" %>

<body class="">
 
    <div class="container">
		<div class="row">
			<div class="col-md-9 offset-md-2">
				<div class="card">
					<div class="card-header">
						<p class="text-center fs-3">Exam</p>
						
					</div>
					<div class="card-body">
	                    <form action="result" method="post" id="examForm">
        <%
        List<Question> list1 = (List<Question>) session.getAttribute("coursedata"); 
       
        
        for(Question q1:list1 )
        {
           
        %>
        <div>
        
            <p><%=q1.getQuestion()%></p>
            <input type="radio" name="<%=q1.getQid()  %>" value="<%=q1.getOption1()%>"> <%=q1.getOption1()%> <br>
            <input type="radio" name="<%=q1.getQid()  %>" value="<%=q1.getOption2()%>"> <%=q1.getOption2() %><br>
            <input type="radio" name="<%=q1.getQid()  %>" value="<%=q1.getOption3()%>"> <%=q1.getOption3()%><br>
            <input type="radio" name="<%=q1.getQid() %>" value="<%=q1.getOption4() %>">  <%=q1.getOption4() %><br>
        </div>
        <hr>
        
        <%
            }
        %>
        <input type="submit" value="Submit" id="submitButton">
    </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<!-- JS -->
<script src="vendor/jquery/jquery.min.js"></script>

</body>
</html>
