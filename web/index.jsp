<%-- 
    Document   : login
    Created on : Nov 26, 2017, 10:32:09 AM
    Author     : Felipe Padua
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LOL - Login</title>
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
                       
          <div class="row" style="margin-top: 100px;">
            <div class="col-md-3"></div>
            <div class="col-md-6">
                
                <img src="images/WelcomeBanner.jpg" class="img-fluid" alt="LOL logo"> 
                
                <h2 class="text-center">Login</h2>
                <form name="loginForm" action="login" method="POST">
                  <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" class="form-control" id="email" name="email" value="" placeholder="Enter email" required>
                  </div>
                  <div class="form-group">
                    <label for="pwd">Password:</label>
                    <input type="password"  class="form-control" id="password" name="password" value="" placeholder="Enter password" required>
                  </div>
                  <div class="form-check">
                    <label class="form-check-label">
                      <input class="form-check-input" type="checkbox"> Remember me
                    </label>
                  </div>
                  <button type="submit" class="btn btn-primary">Submit</button>
                </form>
                
                <% 
                  //session.setAttribute("logged", "notlogged");
                  //request.setAttribute("signin", "no");

                  String logged =(String)request.getAttribute("logged"); 
                  if ( (logged != null) && logged.equals("failed") ) {
                %>
                <br>
                <div class="alert alert-danger">
                    <strong>Sorry!</strong> Invalid password!
                </div>
                <% } %>

                <br>
                <div class="text-center"><a onclick="alert('email our support at: support@fakesupport.umd.edu')" href="#"> Forgot your Credentials?</a></div>
                
            </div>
            <div class="col-md-3"></div>
        </div>
        
    </div>
                   
    </body>
</html>
