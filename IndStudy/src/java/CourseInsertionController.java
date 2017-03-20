/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import IndependentStudy.Course;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import IndependentStudy.CourseService;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author ivatu
 */
@WebServlet(urlPatterns = {"/CourseInsertionController"})
public class CourseInsertionController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
//            semester:fall
//            course:hci
//            credits:3
            
            String sem = request.getParameter("semester");
            String crseName = request.getParameter("course");
            String credts = request.getParameter("credits");
            
            if((credts == null || "".equals(credts)) || (crseName == null || "".equals(crseName)) || (sem == null || "".equals(sem))){
                System.out.println("Please enter all the details.");
                RequestDispatcher rd = request.getRequestDispatcher("/courseInsertion.jsp");
                rd.forward(request, response);
                
            } else {
                Course cr = new Course();
                cr.setCourseName(crseName);
                cr.setSemester(sem);
                if(credts != null && !"".equals(credts)){
                    cr.setCredits(Integer.parseInt(credts));
                }
                System.out.println(cr);
                boolean crse = CourseService.insertCourse(cr);

               if(crse == false){
                    request.setAttribute("errorMsg", "Please insert all the details.");
                    RequestDispatcher rd = request.getRequestDispatcher("/courseInsertion.jsp");
                    //rd.forward(request, response);
                    System.out.println("Details did not got entered in Database.");

                }else{
                    System.out.println("Course details added to Database.");
                    HttpSession session = request.getSession();
                    synchronized(session){
                        session.setAttribute("Course", crse);
                    RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/HomePage.jsp");
                    rd.forward(request, response);
                    }
                }
            }
            
            
            
        }
    }

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
        processRequest(request, response);
    }

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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
}
