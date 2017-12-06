<%-- 
    Document   : courseSyllabus
    Created on : Nov 26, 2017, 10:42:12 AM
    Author     : Felipe Padua
--%>

<%@page import="model.Syllabus"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Course Syllabus</title>
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
                                    
                    
                    <% if(session.getAttribute("userType").equals("Instructor")){ %>
                                    <!-- Trigger the modal with a button -->
                                    <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal2">Update Syllabus</button>
                    <% } %>
                    
                     <hr>
                     <h2>Syllabus:</h2>
                     <div>
                         <% 
                             Syllabus syllabus = new Syllabus();
                             syllabus = (Syllabus)request.getAttribute("syllabus");
                             
                             int syllabusId = syllabus.getId();
                             
                             if(syllabusId != 0){
                                 
                                    String status = "unpublished";
                                    if(syllabus.getPublishedStatus() == 1){
                                        status = "published";
                                    }
                        %>
                        
                            <% if(session.getAttribute("userType").equals("Instructor")){ %>
                                 <div><span><strong>Status: </strong></span>
                                      <span class="badge badge-info"><%= status %></span>
                                 </div>   
                            <% } %>                           
                                                       
                            <div><span><strong>Date: </strong></span> <%= syllabus.getDate() %> </div>
                            <div><span><strong>Content: </strong></span> <%= syllabus.getContent() %> </div>
                            <br>                         
                            
                            
                        <% }
                            else {
                        %>
                                <div><span><strong>No syllabus available! </strong></span></div>
                                <% if(session.getAttribute("userType").equals("Instructor")){ %>
                                    <hr>
                                    <!-- Trigger the modal with a button -->
                                    <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Create Syllabus</button>
                                <% } %>
                        <%   }  %>                      
                        
                         <hr>

                     </div>
                    
                    
                </div>
                <div class="col-md-3"></div>
            </div>
            
        </div
        
        
        
    <!-- Modal 1: Create Syllabus (Instructor only)-->
    <div class="modal fade" id="myModal" role="dialog">
      <div class="modal-dialog modal-lg">

        <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title text-center">Create Syllabus</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>
          <div class="modal-body">
            
              <form id="createSyllabusForm" name="createSyllabusForm" action="createSyllabus" method="POST">                    
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
                        <input type="hidden" name="Course_idCourse" value="<%= syllabus.getCourse_idCourse()%>">
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
    
    
        <!-- Modal 2: Update Syllabus (Instructor only)-->
    <div class="modal fade" id="myModal2" role="dialog">
      <div class="modal-dialog modal-lg">

        <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title text-center">Update Syllabus</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>
          <div class="modal-body">
            
              <form id="createSyllabusForm" name="editSyllabusForm" action="editSyllabus" method="POST">                    
                    <div class="form-group">
                      <label for="content">Content: </label>
                      <textarea class="form-control" rows="5" id="content" name="content" required><%= syllabus.getContent()%></textarea>
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
                        <input type="hidden" name="Course_idCourse" value="<%= syllabus.getCourse_idCourse()%>">
                        <input type="hidden" name="idSyllabus" value="<%= syllabus.getId()%>">
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
    <!-- End of Modal 2 -->   


    
        
    </body>
</html>
