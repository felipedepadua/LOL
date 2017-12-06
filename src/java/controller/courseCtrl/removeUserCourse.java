/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.courseCtrl;

import DAO.courseDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Course;

/**
 *
 * @author Felipe Padua
 */
@WebServlet(name = "removeUserCourse", urlPatterns = {"/removeUserCourse"})
public class removeUserCourse extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           int id = Integer.parseInt(request.getParameter("id"));           
           
           courseDAO courseDAO = new courseDAO();        
           courseDAO.deleteUserFromCourse(id);
           
           // Getting access to the session
           HttpSession session = request.getSession(false);           
           
           RequestDispatcher dispatcher = request.getRequestDispatcher("/viewCourses");
           dispatcher.forward(request, response); 
        
    }

}
