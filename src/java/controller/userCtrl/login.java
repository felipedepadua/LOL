/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.userCtrl;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import java.util.List;
import DAO.userDAO;
import DAO.announcementDAO;
import DAO.courseDAO;
import model.Announcement;
import model.Course;
import model.User;

/**
 *
 * @author Felipe Padua
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            // String URLrequester = request.getHeader("referer");
           String email = request.getParameter("email");
           String pass = request.getParameter("password");
           
           User user = new User();
           userDAO userDAO = new userDAO();        
           user = userDAO.login(email, pass);
           
           // Getting access to the session
           HttpSession session = request.getSession(false);
           //String logged =(String)session.getAttribute("logged");           
           
           int id = user.getId();           
           if(id != 0){                       
               //session.setAttribute("logged", "successful");               
               request.setAttribute("logged", "successful");  
               
               // Get the Courses
               //Course course = new Course();
               //courseDAO courseDAO = new courseDAO();
               //List<Course> courses = courseDAO.getCourses();
               //request.setAttribute("courses", courses);
               
               // Get Courses From Users
               Course course = new Course();
               courseDAO courseDAO = new courseDAO();
               
               if(user.getRole().equals("Admin")){
                   // It will show all
                   List<Course> courses = courseDAO.getCourses();
                   request.setAttribute("courses", courses);
               }else{                   
                   List<Course> courses = courseDAO.getCoursesFromUser(id);
                   request.setAttribute("courses", courses);
               }
               
               // Get the Announcements
               Announcement announcement = new Announcement();
               announcementDAO announcementDAO = new announcementDAO();
               List<Announcement> announcements = announcementDAO.getAnnouncements();
               request.setAttribute("announcements", announcements);
               
               
               // SET SESSION
               session.setAttribute("userType", user.getRole());
               session.setAttribute("id", user.getId());
               
              // response.sendRedirect("http://localhost:8080/LOL/dashboard.jsp");
              //String jsp = "/dashboard.jsp";
              RequestDispatcher dispatcher = request.getRequestDispatcher("/dashboard.jsp");
              dispatcher.forward(request, response);
           } else {
              request.setAttribute("logged", "failed");
              //response.sendRedirect("http://localhost:8080/LOL/index.jsp");
              RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
              dispatcher.forward(request, response);
           }        
    }

}
