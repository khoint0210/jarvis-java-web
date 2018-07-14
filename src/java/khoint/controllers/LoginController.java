/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoint.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khoint.beans.JavaBean;
import khoint.dtos.AvengersDTO;

/**
 *
 * @author khoint0210
 */
public class LoginController extends HttpServlet {

    private static final String ADMIN = "admin.jsp";
    private static final String USER = "user.jsp";
    private static final String ROOT = "root.jsp";
    private static final String ERROR_LOGIN = "index.jsp";
    private static final String ERROR = "error.jsp";

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
        String url = ERROR;
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            JavaBean bean = new JavaBean();
            bean.setUsername(username);
            bean.setPassword(password);
            AvengersDTO avenger = bean.login();
            if (avenger != null) {
                HttpSession session = request.getSession();
                session.setAttribute("NICKNAME", avenger.getMadeUpName());
                session.setAttribute("ROLE", avenger.getRole());
                session.setAttribute("ID", avenger.getID());
                request.setAttribute("AVENGER_INFO", avenger);
                if (avenger.getRole().equals("root")) {
                    request.setAttribute("GREETING", "HELLO JARVIS");
                    url = ROOT;
                } else if (avenger.getRole().equals("admin")) {
                    url = ADMIN;
                } else if (avenger.getRole().equals("user")) {
                    url = USER;
                }
            } else {
                request.setAttribute("ERROR", "WRONG USERNAME OR PASSWORD");
                url = ERROR_LOGIN;
            }
        } catch (Exception e) {
            log("Error at LoginController : " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
