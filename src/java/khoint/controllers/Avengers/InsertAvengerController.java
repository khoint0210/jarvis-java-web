/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoint.controllers.Avengers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import khoint.beans.JavaBean;
import khoint.dtos.AvengersDTO;

/**
 *
 * @author khoint0210
 */
public class InsertAvengerController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String INSERT = "insert-avenger.jsp";
    private static final String SUCCESS = "root.jsp";

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
            JavaBean bean = new JavaBean();
            String action = request.getParameter("action");
            if (action.equals("Insert New Avenger")) {
                url = INSERT;
            } else if (action.equals("Insert Avenger")) {
                String username = request.getParameter("txtUsername");
                String password = request.getParameter("txtPassword");
                String fullname = request.getParameter("txtFullname");
                String madeUpName = request.getParameter("txtMadeUpName");
                String role = request.getParameter("txtRole");
                int status = 0;
                int age = Integer.parseInt(request.getParameter("txtAge"));
                String avatar = request.getParameter("txtAvatar");
                String Drawback = request.getParameter("txtDrawBack");
                AvengersDTO avengerDTO = new AvengersDTO(username, password, fullname, madeUpName, role, avatar, Drawback, status, age);
                bean.setAvengersDTO(avengerDTO);
                if (bean.insertAvenger()) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "UNABLE TO INSERT NEW EQUIPMENT");
                }
            }
        } catch (Exception e) {
            log("Error at CreateNewEquipment : " + e.toString());
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
