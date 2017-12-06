/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.syllabusCtrl;

import DAO.syllabusDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Syllabus;

/**
 *
 * @author Felipe Padua
 */
@WebServlet(name = "editSyllabus", urlPatterns = {"/editSyllabus"})
public class editSyllabus extends HttpServlet {

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
        
            String content = request.getParameter("content");            
            Date date = new Date();
            int publishedStatus = Integer.parseInt(request.getParameter("publishedStatus"));
            int course_idCourse = Integer.parseInt(request.getParameter("Course_idCourse"));
            int idSyllabus = Integer.parseInt(request.getParameter("idSyllabus"));

            Syllabus syllabus = new Syllabus();
            syllabus.setId(idSyllabus);
            syllabus.setContent(content);
            syllabus.setDate(date);
            syllabus.setPublishedStatus(publishedStatus);
            syllabus.setCourse_idCourse(course_idCourse);

            syllabusDAO syllabusDAO = new syllabusDAO();
            syllabusDAO.updateSyllabus(syllabus);
           
            String link = "http://localhost:8080/LOL/viewSyllabus?id="+course_idCourse;
            response.sendRedirect(link);
    }

}
