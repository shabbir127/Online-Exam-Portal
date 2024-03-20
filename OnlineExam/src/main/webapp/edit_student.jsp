<%@page import="com.entity.Student"%>
<%@page import="com.dao.StudentDao"%>
<%@page import="com.entity.Question"%>
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
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header">
						<p class="text-center fs-3">Edit Student Details</p>
						
						<%
						String sid=request.getParameter("id");
						StudentDao dao=new StudentDao(DBConnect.getConn());
						Student s=dao.getStudentBySid(sid);
						
						%>
						
						<c:if test="${not empty errorMsg}">
							<p class="text-center text-success">${errorMsg}</p>
							<c:remove var="errorMsg" />
						
						</c:if>
					</div>
					<div class="card-body">
						<form action="edit_student" method="post">
							
							<div class="mb-3">
								<label class="form-label">Sid</label> <input type="text"
									class="form-control" name="sid" value="<%=s.getSid()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									class="form-control" name="name" value="<%=s.getName()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Email</label> <input type="email"
									class="form-control" name="email" value="<%=s.getEmail()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Gender</label> <input type="text"
									class="form-control" name="gender" value="<%=s.getGender()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">DOB</label> <input type="date"
									class="form-control" name="dob" value="<%=s.getDob()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Address</label> <input type="text"
									class="form-control" name="address"
									value="<%=s.getAddress()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Contact</label> <input type="text"
									class="form-control" name="contact" value="<%=s.getContact()%>">
							</div>

							<input type="hidden" name="id" value="<%=s.getSid()%>">

							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>


</body>
</html>