/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import IndependentStudy.Professor;
import IndependentStudy.ProfessorService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ivatu
 */
@WebServlet(urlPatterns = {"/ProfInsertionController"})
public class ProfInsertionController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
//            firstName:
//            lastName
//            dob
//            exp
//            studyPlace
            
            String firstname = request.getParameter("firstName");
            String lastname = request.getParameter("lastName");
            String dtofbirth = request.getParameter("dob");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateOfBirth = null;
            if(dtofbirth != null){
                try{
                    dateOfBirth = sdf.parse(dtofbirth);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            String stdyPlace = request.getParameter("studyPlace");
            String experience = request.getParameter("exp");
                     
                    
            if((firstname == null || "".equals(firstname)) || (lastname == null || "".equals(lastname)) || (dtofbirth == null || "".equals(dtofbirth)) ||
                    (experience == null || "".equals(experience)) || (stdyPlace == null || "".equals(stdyPlace))){
                System.out.println("Please enter all the details.");
                RequestDispatcher rd = request.getRequestDispatcher("/ProfInsertion.jsp");
                rd.forward(request, response);
                
            } else {
                Professor pr = new Professor();
                pr.setFirstName(firstname);
                pr.setLastName(lastname);
                pr.setDob(dateOfBirth);
                if(experience != null && !"".equals(experience)){
                    
                    pr.setExperience(Integer.parseInt(experience));
                }
                pr.setStudyPlace(stdyPlace);
                
                System.out.println(pr);
                boolean psr = ProfessorService.insertProfessor(pr);

               if(psr == false){
                    request.setAttribute("errorMsg", "Please insert all the details.");
                    RequestDispatcher rd = request.getRequestDispatcher("/ProfInsertion.jsp");
                    //rd.forward(request, response);
                    System.out.println("Details did not got entered in Database.");

                }else{
                    System.out.println("Course details added to Database.");
                    HttpSession session = request.getSession();
                    synchronized(session){
                        session.setAttribute("Professor", psr);
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
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
