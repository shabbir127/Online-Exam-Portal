<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="java.util.Base64"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Files"%>  
    <%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setDateHeader("Expires", 0); // Proxies
if(session.getAttribute("admin")==null)
{
	response.sendRedirect("adminLogin.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="component/all_css.jsp" %>
</head>
<body>

<%@include file="component/nav.jsp" %>	
  <% 
                   String imagePath = "C:/Users/HP/eclipse-workspace/OnlineExam/src/main/webapp/images/adminbg3.jpg";
                   byte[] imageData = Files.readAllBytes(Paths.get(imagePath));
                   String base64Image = Base64.getEncoder().encodeToString(imageData);

                  %>

 
                   <img src="data:image/jpeg;base64, <%= base64Image %>" alt="Image Description" height="auto" width='100%'>

</body>
</html>