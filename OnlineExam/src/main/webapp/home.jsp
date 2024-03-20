<%@page import="com.entity.Question"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.ExamDao"%>
<%@page import="java.util.Base64"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Files"%>
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
<%@include file="component/all_css.jsp" %>
<style type="text/css">
.card-sh{
box.shadow:0 0 6px 0 rgba(0,0,0,0.3)}
</style>

</head>
<body class="bg-light">
<%@include file="component/navbar.jsp" %>	
<input type="hidden" id="status" value="<%=request.getAttribute("status")%>"> 
	<div class="container">
    <div class="row">
        <div class="col-md-9 offset-md-1">
            <div class="card">
                <div class="card-header">
                    <p class="text-center fs-3">MCQ Exam</p>
                    
                </div>
                <div class="card-body">
                    <div class="row">
                        <% 
                            ExamDao dao = new ExamDao(DBConnect.getConn());
                            List<Question> list = dao.getAllCourses();
                            for (Question q : list) {
                            	
                        %>
                        <div class="col-sm-6">
                            <div class="card mb-3">
                                <div class="card-body">
                                    <form action="start" method="post">
                                        <figure>
                                            <% 
                   String imagePath = "C:/Users/HP/eclipse-workspace/OnlineExam/src/main/webapp/images/971.jpg";
                   byte[] imageData = Files.readAllBytes(Paths.get(imagePath));
                   String base64Image = Base64.getEncoder().encodeToString(imageData);
                  
                		   
                  %>
   
 
                   <img src="data:image/jpeg;base64, <%= base64Image %>" alt="Image Description" height="auto" width='100%'>
                                        </figure>
                                        <h5 class="card-title"><%=q.getCourseName()%></h5>
                                        <input type="hidden" id="course" name="course" value="<%=q.getCourseName()%>">
                                        <input type="hidden" id="username" name="username" value="<%=session.getAttribute("loginuser")%>">
                                        
                                        <button id="submit" type="submit" class="btn btn-primary">Start</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <% } %>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">

<script type="text/javascript">
var status =document.getElementById("status").value;
if(status == "success")
	{
	swal("congrats","Exam Is Completed.","success");
	}
</script>
</body>
</html>