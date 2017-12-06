/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.syllabusCtrl;

import DAO.syllabusDAO;
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
import model.Syllabus;

/**
 *
 * @author Felipe Padua
 */
@WebServlet(name = "viewSyllabus", urlPatterns = {"/viewSyllabus"})
public class viewSyllabus extends HttpServlet {

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
        Syllabus syllabus = new Syllabus();
        syllabusDAO syllabusDAO = new syllabusDAO();

        int idCourse = Integer.parseInt(request.getParameter("id"));
        String Course_idCourse = request.getParameter("id");
        
        syllabus = syllabusDAO.getSyllabusByCourseId(idCourse);
        request.setAttribute("syllabus", syllabus);
        
        request.setAttribute("Course_idCourse", Course_idCourse);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/courseSyllabus.jsp");
        dispatcher.forward(request, response);
        
    }

}
