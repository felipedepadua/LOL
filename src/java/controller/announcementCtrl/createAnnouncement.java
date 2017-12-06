/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.announcementCtrl;

import DAO.announcementDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Announcement;

/**
 *
 * @author Felipe Padua
 */
@WebServlet(name = "createAnnouncement", urlPatterns = {"/createAnnouncement"})
public class createAnnouncement extends HttpServlet {

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
        
            String subject = request.getParameter("subject");
            String content = request.getParameter("content");
            // Date: https://www.tutorialspoint.com/java/java_date_time.htm
            // https://docs.oracle.com/javase/7/docs/api/java/util/Date.html
            Date date = new Date() ; // This constructor initializes the object with the current date and time.
            int publishedStatus = Integer.parseInt(request.getParameter("publishedStatus"));
            int course_idCourse = Integer.parseInt(request.getParameter("Course_idCourse"));

            Announcement announcement = new Announcement();
            announcement.setSubject(subject);
            announcement.setContent(content);
            announcement.setDate(date);
            announcement.setPublishedStatus(publishedStatus);
            announcement.setCourse_idCourse(course_idCourse);

            announcementDAO announcementDAO = new announcementDAO();
            announcementDAO.createAnnouncement(announcement);
            
            String link = "http://localhost:8080/LOL/viewAnnouncements?id="+course_idCourse;

            response.sendRedirect(link);
            //RequestDispatcher dispatcher = request.getRequestDispatcher("/viewCourses");
            //dispatcher.forward(request, response); 
        
    }

}
