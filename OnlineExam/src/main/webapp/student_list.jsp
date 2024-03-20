<%@page import="com.entity.Student"%>
<%@page import="com.dao.StudentDao"%>
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
			<div class="col-md-9 offset-md-2">
				<div class="card">
					<div class="card-header">
						<p class="text-center fs-3">List Student</p>
						
						<c:if test="${not empty succ}">
							<p class="text-center text-success">${succ}</p>
							<c:remove var="errorMsg" />
						
						</c:if>
						<c:if test="${not empty error}">
							<p class="text-center text-success">${error}</p>
							<c:remove var="errorMsg" />
						
						</c:if>
					</div>
					<div class="card-body">
						

       <table class="table">
  <thead>
    <tr>
      <th scope="col">Sid</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">DOB</th>
      <th scope="col">Gender</th>
      <th scope="col">Address </th>
      <th scope="col">Contact</th>
      <th scope="col">Action</th>
    </tr>
    <%
    StudentDao dao=new StudentDao(DBConnect.getConn());
    List<Student>list=dao.AllStudent();
    for(Student s:list)
    {
    %>
    
  </thead>
  <tbody>
  
  <tr>
  
  <td><%=s.getSid() %></td>
  <td><%=s.getName() %></td>
  <td><%=s.getEmail() %></td>
  <td><%=s.getDob() %></td>
  <td><%=s.getGender() %></td>
  <td><%=s.getAddress() %></td>
  <td><%=s.getContact() %></td>
  <td> <a href="edit_student.jsp?id=<%=s.getSid()%>" class="btn btn-sm btn-primary">Edit</a></td>
       <td> <a href="delete_student?id=<%=s.getSid()%>" class="btn btn-sm btn-danger ms-1">Delete</a></td>
    
  <tr>
		
  <%} %>
   </tbody>
</table>

					</div>
				</div>
			</div>
		</div>

	</div>


</body>
</html>