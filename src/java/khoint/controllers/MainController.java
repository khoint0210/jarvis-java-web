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

/**
 *
 * @author khoint0210
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";

    private static final String UPDATE_EQUIP = "UpdateEquipmentController";
    private static final String DELETE_EQUIP = "DeleteEquipmentController";
    private static final String SEARCH_EQUIP = "SearchEquipmentController";
    private static final String INSERT_EQUIP = "CreateNewEquipment";
    private static final String VIEW_EQUIP = "ViewEquipmentController";
    private static final String LIST_EQUIP = "ListAllEquipmentsController";

    private static final String SEARCH_AVENGER = "SearchAvengerController";
    private static final String VIEW_AVENGER = "ViewAvengerController";
    private static final String DEL_AVENGER = "DeleteAvengerController";
    private static final String INSERT_AVENGER = "InsertAvengerController";
    private static final String UPDATE_AVENGER = "UpdateAvengerController";

    private static final String LOGIN = "LoginController";
    private static final String AVATAR = "UploadController";
    private static final String LIST = "ListAvengersController";
    private static final String LOGOUT = "LogoutController";

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
            String action = request.getParameter("action");
            if (action.equals("Login")) {
                url = LOGIN;
            } else if (action.equals("Delete Equipment")) {
                url = DELETE_EQUIP;
            } else if (action.equals("Insert New Equipment") || action.equals("Insert Equipment")) {
                url = INSERT_EQUIP;
            } else if (action.equals("Update Equipment") || (action.equals("Edit Equipment"))) {
                url = UPDATE_EQUIP;
            } else if (action.equals("View Equipment") || action.equals("Back Equipment")) {
                url = VIEW_EQUIP;
            } else if (action.equals("Upload Avartar")) {
                url = AVATAR;
            } else if (action.equals("List All Avenger")) {
                url = LIST;
            } else if (action.equals("List All Equipments")) {
                url = LIST_EQUIP;
            } else if (action.equals("Log Out")) {
                url = LOGOUT;
            } else if (action.equals("Search Equipment")) {
                url = SEARCH_EQUIP;
            } else if (action.equals("Search Avenger")) {
                url = SEARCH_AVENGER;
            } else if (action.equals("View Avenger") || action.equals("Back Avenger")) {
                url = VIEW_AVENGER;
            } else if (action.equals("Delete Avenger")) {
                url = DEL_AVENGER;
            } else if (action.equals("Insert New Avenger") || action.equals("Insert Avenger")) {
                url = INSERT_AVENGER;
            } else if (action.equals("Update Avenger") || action.equals("Edit Avenger")) {
                url = UPDATE_AVENGER;
            } else {
                request.setAttribute("ERROR", "Action is not support");
            }
        } catch (Exception e) {
            log("ERROR at MainController: " + e.getMessage());
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
