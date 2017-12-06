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

/**
 *
 * @author Felipe Padua
 */
@WebServlet(name = "assignUserCourse", urlPatterns = {"/assignUserCourse"})
public class assignUserCourse extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            int course_idCourse = Integer.parseInt(request.getParameter("courseOptions"));
            int user_idUser = Integer.parseInt(request.getParameter("userOptions"));

            //...

            response.sendRedirect("http://localhost:8080/LOL/viewCourses");
            //RequestDispatcher dispatcher = request.getRequestDispatcher("/viewCourses");
            //dispatcher.forward(request, response);    
    }

}
