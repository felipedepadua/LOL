/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.courseCtrl;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Course;
import DAO.courseDAO;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Felipe Padua
 */
@WebServlet(name = "createCourse", urlPatterns = {"/createCourse"})
public class createCourse extends HttpServlet {

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
        
            String name = request.getParameter("name");
            String semester = request.getParameter("semester");
            String description = request.getParameter("description");

            Course course = new Course();
            course.setName(name);
            course.setSemester(semester);
            course.setDescription(description);

            courseDAO courseDAO = new courseDAO();
            courseDAO.createCourse(course);

            response.sendRedirect("http://localhost:8080/LOL/viewCourses");
            //RequestDispatcher dispatcher = request.getRequestDispatcher("/viewCourses");
            //dispatcher.forward(request, response);        
    }

}
