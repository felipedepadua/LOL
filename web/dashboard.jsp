<%-- 
    Document   : homepage
    Created on : Nov 26, 2017, 10:32:00 AM
    Author     : Felipe Padua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Dashboard</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.6/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
        
        <!-- My CSS -->
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
         <%@ include file="/templates/menu.jsp" %>
         
         
        <div class="container-fluid">       
                       
          <div class="row">
            <div class="col-md-1"></div>
            <div class="col-md-4">
                <div class="card" style="width:400px">
                    <img class="card-img-top" src="images/Logo.png" alt="courses" height="220" style="width:100%">
                    <div class="card-body">
                      <h4 class="card-title">Courses</h4>
                      <p class="card-text">Check out all your courses</p>
                      <a href="http://localhost:8080/LOL/viewCourses" class="btn btn-primary">View All Courses</a>
                    </div>
                </div>
            </div>
            <div class="col-md-2"></div>
            <div class="col-md-4">
                <div class="card" style="width:400px">
                    <img class="card-img-top" src="images/Logo.png" alt="announcements" height="220" style="width:100%">
                    <div class="card-body">
                      <h4 class="card-title">Announcements</h4>
                      <p class="card-text">Check out all the announcements</p>
                      <a href="http://localhost:8080/LOL/viewAnnouncements?id=0" class="btn btn-primary">View All Announcements</a>
                    </div>
                </div>
            </div>            
            <div class="col-md-1"></div>
          </div>
         </div>
                   
    </body>
</html>
