<%@page import="com.entity.Question"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.ExamDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
  <%
if(session.getAttribute("admin")==null)
{
	response.sendRedirect("adminLogin.jsp");
}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

 <%@include file="component/all_css.jsp" %>
<style type="text/css">
.card-sh{
box.shadow:0 0 6px 0 rgba(0,0,0,0.3)}
</style>
</head>
<body class="bg-light">
<%@include file="component/nav.jsp" %>	
	<div class="container">
		<div class="row">
			<div class="col-md-10 offset-md-1">
				<div class="card">
					<div class="card-header">
						<p class="text-center fs-3">List Question</p>
						
						<c:if test="${not empty succMsg}">
							<p class="text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" />
						
						</c:if>
						<c:if test="${not empty errorMsg}">
							<p class="text-center text-success">${errorMsg}</p>
							<c:remove var="errorMsg" />
						
						</c:if>
					</div>
					<div class="card-body">
						<form action="searchCourse" method="post">
							<div class="mb-2">
							    <label class="form-label">Course Name</label> 
							     <select name="courses"> 
							<%
							ExamDao dao = new ExamDao(DBConnect.getConn());
							List<Question> list = dao.getAllCourses();
							for (Question q : list) 
							{
							%>
							    
									<option value="<%=q.getCourseName()%>"><%=q.getCourseName()%></option>
						    <%
							}
							%>
								</select>
							</div>
							
							<button type="submit" class="btn btn-primary">
								search</button>
						</form>


       <table class="table">
  <thead>
    <tr>
      <th scope="col">QuestionId</th>
      <th scope="col">Question</th>
      <th scope="col">Option 1</th>
      <th scope="col">Option 2</th>
      <th scope="col">Option 3</th>
      <th scope="col">Option 4</th>
      <th scope="col">Answer</th>
      <th scope="col"> Action</th>
    </tr>
  </thead>
  <tbody>
  <c:if test="${not empty course}">
							
  <% List<Question> list1 = (List<Question>) session.getAttribute("course"); 
       for(Question q1:list1 )
       { %>
								<tr>
									<td><%=q1.getQid()%></td>
									<td><%=q1.getQuestion()%></td>
									<td><%=q1.getOption1()%></td>
									<td><%=q1.getOption2()%></td>
									<td><%=q1.getOption3()%></td>
									<td><%=q1.getOption4()%></td>
									<td><%=q1.getCorrectAnwser()%></td>
									<td> <a href="editquestion.jsp?id=<%=q1.getQid() %>" class="btn btn-sm btn-primary">Edit</a></td>
                                    <td> <a href="delete?id=<%=q1.getQid() %>" class="btn btn-sm btn-danger ms-1">Delete</a></td>

								</tr>

								<%
								}
								%>  
  
							<c:remove var="course" />
						
						</c:if>
  
   </tbody>
</table>

					</div>
				</div>
			</div>
		</div>

	</div>


</body>
</html>