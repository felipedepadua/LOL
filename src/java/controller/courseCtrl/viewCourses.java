/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.courseCtrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import model.Course;
import DAO.courseDAO;

/**
 *
 * @author Felipe Padua
 */
@WebServlet(name = "viewCourses", urlPatterns = {"/viewCourses"})
public class viewCourses extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        Course course = new Course();
        courseDAO courseDAO = new courseDAO();

        if(session.getAttribute("userType").equals("Admin")){
            // It will show all
            List<Course> courses = courseDAO.getCourses();
            request.setAttribute("courses", courses);
        }else{
            int id = (int) session.getAttribute("id");
            List<Course> courses = courseDAO.getCoursesFromUser(id);
            request.setAttribute("courses", courses);
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/courses.jsp");
        dispatcher.forward(request, response);
        
    }

}
