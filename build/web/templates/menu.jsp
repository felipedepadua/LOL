<nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top">
    <a class="navbar-brand" href="#">
        <img src="images/LogoLOL.png" alt="Logo LOL" style="width:40px;">
    </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="http://localhost:8080/LOL/dashboard.jsp">Dashboard</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="http://localhost:8080/LOL/viewCourses">All Courses</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="http://localhost:8080/LOL/viewAnnouncements?id=0">All Announcements</a>
      </li>
    </ul>
    <span class="nav-item">
        <a class="nav-link" href="http://localhost:8080/LOL/logout">Logout</a>
    </span>
  </div>  
</nav>
<br>

<div>
    <strong class="text-primary">Account Type: </strong>
    <span class="badge badge-info"><%= session.getAttribute("userType") %></span>

</div>
<hr><br>


