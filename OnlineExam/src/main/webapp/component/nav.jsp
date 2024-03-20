<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
    ul {
        list-style-type: none; /* Removes the default bullet points */
    }
</style>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-success">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><i class="fa-solid fa-book"></i> Exam Portal   </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
     aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
     
     <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
        
        
        
      
      </ul>
    
    <ul>
      <li class="nav-item">
          <!-- Centered Heading -->
          <h2 class="text-center fs-3" ><i class="fa-solid fa-computer"></i> Online Exam Portal</h2>
        </li>
        </ul>
        
      <ul class="navbar-nav ms-auto mb-2 mb-0">
        
        
        
        <c:if test="${not empty admin }">
          <!-- Admin Links -->
          
          <div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
   Question Section
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
    <li class="nav-item">
            <a class="nav-link" href="question_list.jsp"><i class="fa-solid fa-list-ul"></i> All Question</a>
    </li>
    <li class="nav-item">
            <a class="nav-link" href="AddQuestion.jsp"><i class="fa-solid fa-plus"></i> Add Question</a>
    </li>
  </ul>
</div>

       <li class="nav-item">
            <a class="nav-link" href="student_list.jsp"> All Student <i class="fa-solid fa-list-ul"></i></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="logoutadmin"> <i class="fa-solid fa-arrow-right-from-bracket"></i> logout</a>
          </li>
  
        </c:if>
      </ul>
    </div>
  </div>
</nav>







</body>
</html>