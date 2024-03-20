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
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
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
        
      <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
        <!-- Conditional Links for Logged in and Logged out users -->
        <c:if test="${not empty loginuser }">
          <!-- Displayed when user is logged in -->
          <li class="nav-item">
            <a class="nav-link" href="#"><i class="fa-regular fa-user"></i> ${loginuser} </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="Allresult.jsp"><i class="fa-solid fa-star"></i> Result </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="logout"> <i class="fa-solid fa-arrow-right-from-bracket"></i> logout</a>
          </li>
        </c:if>
        
        <c:if test="${empty loginuser }">
        
          <!-- Displayed when user is logged out -->
          <li class="nav-item">
            <a class="nav-link" href="login.jsp"><i class="fa-solid fa-right-to-bracket"></i> login</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="register.jsp"><i class="fa-solid fa-user-plus"></i> Register</a>
          </li>
          
        </c:if> 
      </ul>
    </div>
  </div>
</nav>







</body>
</html>