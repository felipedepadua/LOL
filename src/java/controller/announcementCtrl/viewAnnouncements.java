/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.announcementCtrl;

import DAO.announcementDAO;
import DAO.courseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Announcement;
import model.Course;

/**
 *
 * @author Felipe Padua
 */
@WebServlet(name = "viewAnnouncements", urlPatterns = {"/viewAnnouncements"})
public class viewAnnouncements extends HttpServlet {

     /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get Session
        HttpSession session = request.getSession(false);        
        // Get Courses From Users
        Announcement announcement = new Announcement();
        announcementDAO announcementDAO = new announcementDAO();


        int idCourse = Integer.parseInt(request.getParameter("id"));
        String Course_idCourse = request.getParameter("id");
        
        if(idCourse != 0){
            // If true, it will show only the announcement for that  id
             List<Announcement> announcements = announcementDAO.getAnnouncementsFromCourse(idCourse);
             request.setAttribute("announcements", announcements);
        } else {
            //otherwise It will show announcements from all courses from user
            
            if(session.getAttribute("userType").equals("Admin")){
                // It will show all
                List<Announcement> announcements = announcementDAO.getAnnouncements();
                request.setAttribute("announcements", announcements);
            }else{
                int id = (int) session.getAttribute("id");
                List<Announcement> announcements = announcementDAO.getAnnouncementsFromUser(id);
                request.setAttribute("announcements", announcements);
            }
            
        }
        
                
        request.setAttribute("Course_idCourse", Course_idCourse);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/courseAnnouncements.jsp");
        dispatcher.forward(request, response);
        
    }

}
