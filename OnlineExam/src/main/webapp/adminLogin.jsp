<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@page import="java.util.Base64"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Files"%>
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
<%@ include file="component/nav.jsp" %>
<input type="hidden" id="status" value="<%=request.getAttribute("status")%>"> 
<body class="">

    <div class="container">
        <div class="row">
            <div class="col-md-4 ">
                <div >
                    <figure>
                        <% 
                   String imagePath = "C:/Users/HP/eclipse-workspace/OnlineExam/src/main/webapp/images/com.jpg";
                   byte[] imageData = Files.readAllBytes(Paths.get(imagePath));
                   String base64Image = Base64.getEncoder().encodeToString(imageData);

                  %>

 
                   <img src="data:image/jpeg;base64, <%= base64Image %>" alt="Image Description" height="400">
                    </figure>
                </div>
            </div>
            <br>
            <div class="col-md-8">
            <br>
                <div class="card">
                    <div class="card-header">
                        <p class="text-center fs-3">Admin Sign Up</p>
                        <c:if test="${not empty errorMsg}">
                            <p class="text-center text-success">${errorMsg}</p>
                            <c:remove var="errorMsg" />
                        </c:if>
                    </div>
                    <div class="card-body">
                        <form method="post" action="admin_login"  onsubmit="return validateForm()" name="loginForm" id="loginForm" class="register-form"
							id="login-form">
                            <div class="mb-2">
                                <label for="name"><i class="fa-solid fa-id-badge"></i> Name</label>
                                <input type="text" class="form-control" id="randomString" name="name">
                            </div>       
                            
                            <div class="mb-2">
                                <label for="pass"><i class="fa-solid fa-lock"></i></label> Password <input
                                    type="password" class="form-control" name="pass" id="pass" placeholder="Password" />
                            </div>
                           
                            
							 <div class="text-center mb-2">
                              
                            </div>
                            <div class="form-group form-button">
                                <button type="submit" class="btn btn-primary">Sign Up</button>
                            </div>
                        </form>
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
if(status == "failed")
	{
	swal("Sorry","Worng Admin ID  & Password","error");
	}
	
	
function validateForm() {
    var username = document.forms["loginForm"]["name"].value;
    var password = document.forms["loginForm"]["pass"].value;

    if (username === "" || password === "") {
        alert("Admin ID and Password must be filled out");
        return false;
    }
}
	
	</script>
</body>
</html>
