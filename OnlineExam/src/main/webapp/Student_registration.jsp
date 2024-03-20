<%@page import="java.util.Base64"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Files"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
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
<input type="hidden" id="status" value="<%=request.getAttribute("status")%>"> 
<body class="">

    <div class="container">
        <div class="row">
            <div class="col-md-4 ">
                <div >
                   <% 
                   String imagePath = "C:/Users/HP/eclipse-workspace/OnlineExam/src/main/webapp/images/signin-image.jpg";
                   byte[] imageData = Files.readAllBytes(Paths.get(imagePath));
                   String base64Image = Base64.getEncoder().encodeToString(imageData);

                  %>

 
                   <img src="data:image/jpeg;base64, <%= base64Image %>" alt="Image Description" height="600">
                    
                </div>
            </div>
            
            <div class="col-md-8">
            <br>
                <div class="card">
                    <div class="card-header">
                        <p class="text-center fs-3">Sign In</p>
                        <c:if test="${not empty succMsg}">
                            <p class="text-center text-success"> <i class="fa-solid fa-id-badge"></i> ${succMsg}</p>
                            <c:remove var="succMsg" />
                        </c:if>
                    </div>
                    <div class="card-body">
                        <form method="post" action="reg" onsubmit="return validateForm()" class="register-form" name="registerform" id="registerform">
                            <div class="mb-2">
                                
                                <input type="hidden" class="form-control" id="randomString" name="sid" value="${randomString}" readonly>
                            </div>       
                            <div class="mb-2">
                                <label for="name"><i class="fa-solid fa-user"></i></label> Name <input
                                    type="text" class="form-control" name="name" id="name" placeholder="Your Name" />
                            </div>
                            <div class="mb-2">
                                <label for="email"><i class="fa-solid fa-envelope"></i></label> Email <input
                                    type="email" class="form-control" name="email" id="email" placeholder="Your Email" />
                            </div>
                            <!-- Continue with your other input fields -->
                            <div class="mb-2">
                                <label for="pass"><i class="fa-solid fa-lock"></i></label> Password <input
                                    type="password" class="form-control" name="pass" id="pass" placeholder="Password" />
                            </div>
                           
                             
                             <div class="form-group">
								<label for="DOB"><i class="fa-solid fa-cake-candles"></i>Birthday</label>
								<input type="date" class="form-control" name="dob" id="DOB"
									placeholder="Birthday" />
							</div>
							

                            <div class="mb-2">
                                <label for="Gender"><i class="fa-solid fa-venus-mars"></i> Gender</label>
                                <input type="text" class="form-control" name="gender" id="Gender"
                                    placeholder=" Gender" />
                            </div>
                           
							<div class="mb-2">
								<label for="Address"><i class="fa-solid fa-location-dot"></i> Address </label>
								<input type="text" class="form-control" name="address" id="Address"
									placeholder="Address" />
							</div>
							
							<div class="mb-2">
								<label for="contact"><i class="fa-solid fa-phone"></i> Contact</label>
								<input type="text" class="form-control" name="contact" id="contact"
									placeholder="Contact no" />
							</div>
						
						
                            
                            <div class="text-center mb-2">
                             <a href="Student_login.jsp" class="signup-image-link">I am already
							member</a>
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
if(status == "success")
	{
	swal("congrats","Account is created Successfully" ${randomString},"success");
	}
	
	
	

function validateForm() {
    var username = document.forms["registerform"]["name"].value;
    var pass = document.forms["registerform"]["pass"].value;
    var email = document.forms["registerform"]["email"].value;
    var DOB = document.forms["registerform"]["DOB"].value;
    var Gender = document.forms["registerform"]["Gender"].value;
    var Address = document.forms["registerform"]["Address"].value;
    var contact = document.forms["registerform"]["contact"].value;
   

    if (username === "" || pass === "" || email === "" || DOB === "" || Gender === "" || Address === "" || contact === "" ) {
        alert("Every Detail  must be filled out");
        return false;
    }
}
</script>
</body>
</html>
