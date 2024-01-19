/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;



/**
 *
 * @author Admin
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {
    
    private final String INSERT_ERROR = "createNewAccount.jsp";
    private final String LOGIN_PAGE = "login.html";

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
//        RegistrationInsertErr errors = new RegistrationInsertErr();
//        String username = request.getParameter("txtUsername");
//        String password = request.getParameter("txtPassword");
//        String confirm = request.getParameter("txtConfirm");
//        String fullname = request.getParameter("txtFullname");
//        String url = INSERT_ERROR;
//        try {
//            boolean error = false;
//            if (username.trim().length() < 6 || username.trim().length()>20) {
//                error = true;
//                errors.setUsernameLengthErr("Username's length must be from 6 to 20 characters");
//            }
//            if (password.trim().length() < 6 || password.trim().length()>30) {
//                error = true;
//                errors.setPasswordLengthErr("Password's length must be from 6 to 30 characters");
//            } else if (!confirm.trim().equals(password.trim())) {
//                error = true;
//                errors.setConfirmNotMatch("Not match");
//            }
//            if (fullname.trim().length() < 2 || fullname.trim().length()>50) {
//                error = true;
//                errors.setFullnameLengthErr("Fullname's length must be from 6 to 50 characters");
//            }
//            if (error) {
//                request.setAttribute("insertErr", errors);
//            }
//            else {
//                RegistrationDAO dao = new RegistrationDAO();
//                boolean result = dao.insertAccount(username, password, fullname, false);
//                if (result) {
//                    url = LOGIN_PAGE;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            ex.printStackTrace();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            errors.setUsernameIsExist(username+" has already exist!");
//            request.setAttribute("insertErr", errors);
//        } finally {
//            RequestDispatcher rd = request.getRequestDispatcher(url);
//            rd.forward(request, response);
//        }

        RegistrationInsertErr errors = new RegistrationInsertErr();
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String fullname = request.getParameter("txtFullname");
        String url = INSERT_ERROR;
        
        try {
            boolean error = false;
            if(username.trim().length() < 6 || username.trim().length() > 30){
                error = true;
                errors.setUsernameLengthErr("");
            }
            if(password.trim().length() < 6 || password.trim().length() > 30){
                error = true;
                errors.setPasswordLengthErr("");
            }else if (!confirm.trim().equals(password.trim())){
                error = true;
                errors.setConfirmNotMatch("Not Match");
            }
            if(fullname.trim().length() < 6 || fullname.trim().length() > 50){
                error = true;
                errors.setFullnameLengthErr("");
            }
            else {
                RegistrationDAO dao = new RegistrationDAO();
                boolean result = dao.insertAccount(username, password, fullname, false);
                if  (result){
                    url = LOGIN_PAGE;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
            errors.setUsernameIsExist(username + " is existed!!!");
            request.setAttribute("insertErr", errors);
        }finally{
            RequestDispatcher rd = request.getRequestDispatcher(url);
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
