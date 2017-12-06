<%-- 
    Document   : courseAnnouncement
    Created on : Nov 26, 2017, 10:42:51 AM
    Author     : Felipe Padua
--%>

<%@page import="model.Announcement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Course Announcements</title>
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
                    
                    <% if(session.getAttribute("userType").equals("Instructor")){ %>
                        <!-- Trigger the modal with a button -->
                        <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Create Announcement</button>
                        <hr>
                    <% } %>
                    
                    <h2>Announcements:</h2>
                     <div>
                         <%                             
                             // https://stackoverflow.com/questions/7614239/passing-list-array-between-jsp-pages
                             // https://docs.oracle.com/javase/tutorial/collections/implementations/list.html
                             List<Announcement> announcementList = new ArrayList<>();
                             announcementList = (List<Announcement>)request.getAttribute("announcements");
                             for (int i = 0; i < announcementList.size(); i++) {
                                // int id = courseList.get(i).getId(); 
                        %>
                            <div><h4><strong>Subject: </strong></h4> <%= announcementList.get(i).getSubject() %> </div>
                            <div><span><strong>Date: </strong></span> <%= announcementList.get(i).getDate() %> </div>
                            <div><span><strong>Content: </strong></span> <%= announcementList.get(i).getContent() %> </div>
                            <br>                            
                         <hr>
                         <% } %>
                     </div>                    
            
                </div>
                <div class="col-md-3"></div>
            </div>
            
        </div>
        
        
    <!-- Modal 1: Create New Announcement (Instructor only)-->
    <div class="modal fade" id="myModal" role="dialog">
      <div class="modal-dialog modal-lg">

        <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title text-center">New Announcement</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>
          <div class="modal-body">
            
              <form id="createAnnounForm" name="createAnnounForm" action="createAnnouncement" method="POST">
                    <div class="form-group">
                      <label for="subject">Subject: </label>
                      <input type="text" class="form-control" id="subject" name="subject" value="" placeholder="Enter subject" required>
                    </div>
                    <div class="form-group">
                      <label for="content">Content: </label>
                      <textarea class="form-control" rows="5" id="content" name="content" required></textarea>
                    </div>
                    <div class="form-group">
                      <label for="subject">Wish to publish it? </label>
                      <select class="form-control" id="published" name="publishedStatus" required>
                        <option value="1">Yes</option>
                        <option value="0">No</option>
                      </select>
                    </div>
                    <div class="form-group">
                        <!-- Hidden Input to pass idCourse -->           
                        <input type="hidden" name="Course_idCourse" value="<%= announcementList.get(0).getCourse_idCourse()%>">
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
                     
        
    </body>
</html>
