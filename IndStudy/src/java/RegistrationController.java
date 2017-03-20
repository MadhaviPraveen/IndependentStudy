/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import IndependentStudy.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import IndependentStudy.UserService;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author ivatu
 */
@WebServlet(urlPatterns = {"/RegistrationController"})
public class RegistrationController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     *
     * @throws IOException if an I/O error occurs
     */
    public static boolean checkEmpty(String value) {
        if (!(value == null)) {
            return value.isEmpty();
        }
        return false;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //u_id, cwid, f_name, l_name, user_name, pass_word, street_name, house_num, city, zip_code, sex, dob

            String cwidStr = request.getParameter("cwid");
            int cwid = 0;
            if (cwidStr != null && !cwidStr.trim().equals("")) {
                try{
                    cwid = Integer.parseInt(cwidStr);
                }catch(Exception e){
                    request.setAttribute("errorMsg", " Please enter cwid in integer format");
                    RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
                    rd.forward(request, response);
                    System.out.println("User not available");
                    return;
                }
            }

            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String userName = request.getParameter("userName");
            String password = request.getParameter("passWord");
            String streetName = request.getParameter("streetName");

            String hseNmbr = request.getParameter("houseNumber");
            int houseNumber = 0;
            if (hseNmbr != null && !hseNmbr.trim().equals("")) {
                try {
                    houseNumber = Integer.parseInt(hseNmbr);
                } catch (Exception e) {
                    request.setAttribute("errorMsg", " Please enter house number in integer format");
                    RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
                    rd.forward(request, response);
                    System.out.println("User not available");
                    return;
                }
            }
            
            String city = request.getParameter("city");

            String zpcde = request.getParameter("zipcode");
            int zipcode = 0;
            if (zpcde != null && !zpcde.trim().equals("")) {
                try {
                    zipcode = Integer.parseInt(zpcde);
                } catch (Exception e) {
                    request.setAttribute("errorMsg", " Please enter zipcode in integer format");
                    RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
                    rd.forward(request, response);
                    System.out.println("User not available");
                    return;
                }
            }

            String sex = request.getParameter("sex");
            
            String dob = request.getParameter("dob");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateOfBirth = null;
            if (dob != null) {
                try {
                    dateOfBirth = sdf.parse(dob);
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("errorMsg", " Please enter date of birth in yyyy-MM-dd format");
                    RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
                    rd.forward(request, response);
                    System.out.println("User not available");
                    return;
                }
            }
            if (checkEmpty(cwidStr) || checkEmpty(firstName) || checkEmpty(lastName) || checkEmpty(userName) || checkEmpty(password)
                    || checkEmpty(streetName) || checkEmpty(hseNmbr) || checkEmpty(city) || checkEmpty(zpcde) || checkEmpty(sex) || checkEmpty(dob)) {
                request.setAttribute("errorMsg", " Please enter all the fields");
                RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
                rd.forward(request, response);
                System.out.println("User not available");
            }
            
            //cwid, f_name, l_name, user_name, pass_word, street_name, house_num, city, zip_code, sex, dob
            User user = new User(cwid, firstName, lastName, userName, password, streetName, houseNumber, city, zipcode, sex, dateOfBirth);
            UserService.insertUser(user);
            RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
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
