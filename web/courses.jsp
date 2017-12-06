<%-- 
    Document   : homepage
    Created on : Nov 26, 2017, 10:32:00 AM
    Author     : Felipe Padua
--%>

<%@page import="DAO.userDAO"%>
<%@page import="model.User"%>
<%@page import="model.Course"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
            <div class="col-md-3"></div>
            <div class="col-md-6">
                
                    <% if(session.getAttribute("userType").equals("Admin")){ 
                    // https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_textarea_form
                    %>                    
                        <!-- Trigger the modal with a button -->
                        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Create New Course</button>
                        <hr>
                    <% } %>

                     <h2>Courses:</h2>
                     <div>
                         <% 
                             // https://stackoverflow.com/questions/7614239/passing-list-array-between-jsp-pages
                             // https://docs.oracle.com/javase/tutorial/collections/implementations/list.html
                             List<Course> courseList = new ArrayList<>();
                             courseList = (List<Course>)request.getAttribute("courses");
                             for (int i = 0; i < courseList.size(); i++) {
                                // int id = courseList.get(i).getId(); 
                        %>
                        <div><h4><strong><%= courseList.get(i).getName() %></strong></h4>  </div>
                            <div><span><strong>Semester: </strong></span> <%= courseList.get(i).getSemester() %> </div>
                            <div><span><strong>Description: </strong></span> <%= courseList.get(i).getDescription() %> </div>
                            <div> <a href="http://localhost:8080/LOL/viewAnnouncements?id=<%= courseList.get(i).getId() %>">View Announcements</a> </div>
                            <div> <a href="http://localhost:8080/LOL/viewSyllabus?id=<%= courseList.get(i).getId() %>">View Syllabus</a></div>
                            <br>
                            <% if(session.getAttribute("userType").equals("Admin")){ %>
                                    <div>                                         
                                        <a class="btn btn-outline-primary" role="button" href="http://localhost:8080/LOL/seeUsersEnrolled?id=<%= courseList.get(i).getId() %>">See Users Enrolled in this Course</a>
                                        <!-- Trigger the modal with a button -->
                                        <button type="button" class="assign btn btn-outline-primary" data-toggle="modal" data-target="#myModal2" data-id="<%= courseList.get(i).getId() %>">Assign User to this Course</button>
                                    
                                    </div>
                                    <br>
                                    <div>
                                        <a class="btn btn-outline-danger" role="button" href="http://localhost:8080/LOL/removeCourse?id=<%= courseList.get(i).getId() %>">Delete this Course</a>                                        
                                    </div>
                            <% } %>
                            
                            <% if(session.getAttribute("userType").equals("Instructor")){ %>
                                <div>
                                    <a class="btn btn-outline-primary" role="button" href="http://localhost:8080/LOL/seeUsersEnrolled?id=<%= courseList.get(i).getId() %>">See Users Enrolled in this Course</a>                                   
                                </div>
                            <% } %>
                            
                         <hr>
                         <% } %>
                     </div>
                
            </div>
            <div class="col-md-3"></div>            
        </div>      

    <!-- Modal 1: Create New Course (ADMIN only)-->
    <div class="modal fade" id="myModal" role="dialog">
      <div class="modal-dialog modal-lg">

        <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title text-center">New Course</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>
          <div class="modal-body">
            
              <form id="createCourseForm" name="createCourseForm" action="createCourse" method="POST">
                    <div class="form-group">
                      <label for="name">Name: </label>
                      <input type="text" class="form-control" id="name" name="name" value="" placeholder="Enter name" required>
                    </div>
                    <div class="form-group">
                      <label for="semester">Semester: </label>
                      <input type="text"  class="form-control" id="semester" name="semester" value="" placeholder="Enter semester" required>
                    </div>
                    <div class="form-group">
                      <label for="description">Description:</label>
                      <textarea class="form-control" rows="5" id="description" name="description" required></textarea>
                    </div>
                    <hr>
                    <button type="submit" name="submit" class="btn btn-default">Submit</button>
                </form>
              
          </div>
          <!--
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
          </div>
          -->
        </div>

      </div>
    </div>
    <!-- End of Modal 1 -->     
    
      <!-- Modal 2: Assign User to a Course (Admin only)-->
    <div class="modal fade" id="myModal2" role="dialog">
      <div class="modal-dialog modal-lg">

        <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title text-center">Assign User to this Course</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>
          <div class="modal-body">
            
              <form id="AssignForm" name="assignUserForm" action="assignUserCourse" method="POST">
                    <div class="form-group">
                      <label for="subject">Choose User: </label>
                      <select class="form-control" id="userId" name="userId" required>
                        <%                              
                             userDAO userDAO = new userDAO();
                             List<User> users = userDAO.getUsersFromCourse(1);
        
                             for (int i = 0; i < users.size(); i++) {
                        %>
                        <option name="userOptions" id="userOptions" value="<%= users.get(i).getId() %>"><%= users.get(i).getEmail() %></option>
                        <% } %>
                      </select>
                    </div>
                    <div class="form-group">
                      <label for="subject">Course: </label>
                      <select class="form-control" id="courseId" name="courseId" required>
                          <option name="courseOptions" id="courseOptions" value=""></option>
                      </select>
                    </div>
                    <hr>                    
                    <button type="submit" name="submit" class="btn btn-default">Submit</button>
                </form>
              
          </div>
        </div>

      </div>
    </div>
    <!-- End of Modal 2-->  
    
    <script>
            $('document').on('click', '.assign',function(){
                var option = $(this).data('id');
               $(".modal-body #courseOptions").val(option);
                //console.log($(this).attr('data-id'));
            });
    </script>
        
    
    </body>
</html>
