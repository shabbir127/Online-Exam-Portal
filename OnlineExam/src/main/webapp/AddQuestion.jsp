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
<%@include file="component/nav.jsp" %>
<body class="bg-light">

	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-header">
						<p class="text-center fs-3">Add Question</p>
						
						<c:if test="${not empty errorMsg}">
							<p class="text-center text-success">${errorMsg}</p>
							<c:remove var="errorMsg" />
						
						</c:if>
					</div>
					<div class="card-body">
						<form action="addQuestion" method="post">

							<div class="mb-2">
								<label class="form-label">Course Name</label> <input type="text"
									class="form-control" name="course">
							</div>

							<div class="mb-2">
								<label class="form-label">Question</label> <input type="text"
									class="form-control" name="question">
							</div>

							<div class="mb-2">
								<label class="form-label">Option 1</label> <input type="text"
									class="form-control" name="option_1">
							</div>

							<div class="mb-2">
								<label class="form-label">Option 2</label> <input
									type="text" class="form-control" name="option_2">
							</div>

							<div class="mb-2">
								<label class="form-label">Option 3</label> <input type="text"
									class="form-control" name="option_3">
							</div>

							<div class="mb-2">
								<label class="form-label">Option 4</label> <input type="text"
									class="form-control" name="option_4">
							</div>

							<div class="mb-2">
								<label class="form-label">Answer</label> <input type="text"
									class="form-control" name="answer">
							</div>


							<button type="submit" class="btn btn-primary ">Add
								Question</button>
						</form>



					</div>
				</div>
			</div>
		</div>

	</div>


</body>
</html>