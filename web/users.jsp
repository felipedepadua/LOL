<%-- 
    Document   : users
    Created on : Dec 5, 2017, 9:14:53 PM
    Author     : Felipe Padua
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>List of Course Participants</title>
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
        
        <div class="container-fluid">   
            
            <%@ include file="/templates/menu.jsp" %> 
                       
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">                   
                                      
                    <h2>Course Participants:</h2>
                     <div>
                         <%                             
                             List<User> userList = new ArrayList<>();
                             userList = (List<User>)request.getAttribute("users");
                             for (int i = 0; i < userList.size(); i++) {
                                // int id = courseList.get(i).getId(); 
                        %>
                            <div>
                                <h5><strong>Email: </strong><%= userList.get(i).getEmail()%></h5>  
                                <span><strong>Role: </strong></span>
                                <span class="badge badge-info"><%= userList.get(i).getRole()%></span><br>  
                                <% if(session.getAttribute("userType").equals("Admin")){ %>
                                    <a class="btn btn-outline-danger btn-sm" role="button" href="http://localhost:8080/LOL/removeUserCourse?id=<%= userList.get(i).getId() %>">Remove Users from this Course</a>
                                <% } %>
                            </div>
                            <br>                            
                         <hr>
                         <% } %>
                     </div>                    
            
                </div>
                <div class="col-md-3"></div>
            </div>
            
        </div>                       
                     
        
    </body>
</html>
