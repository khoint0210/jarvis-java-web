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
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author khoint0210
 */
public class MainController extends HttpServlet {
    
    private static final String ERROR = "error.jsp";
    private static final String UPLOAD = "UploadController";
    
    private static final String UPDATE_EQUIP = "UpdateEquipmentController";
    private static final String DELETE_EQUIP = "DeleteEquipmentController";
    private static final String SEARCH_EQUIP = "SearchEquipmentController";
    private static final String INSERT_EQUIP = "CreateNewEquipment";
    private static final String VIEW_EQUIP = "ViewEquipmentController";
    private static final String LIST_EQUIP = "ListAllEquipmentsController";
    
    private static final String SEARCH_EQUIP_BY_AVENGER = "ListEquipByAvengerController";
    private static final String UPDATE_ADMIN_EQUIPMENT = "UpdateAdminEquipment";
    
    private static final String SEARCH_AVENGER = "SearchAvengerController";
    private static final String VIEW_AVENGER = "ViewAvengerController";
    private static final String DEL_AVENGER = "DeleteAvengerController";
    private static final String INSERT_AVENGER = "InsertAvengerController";
    private static final String UPDATE_AVENGER = "UpdateAvengerController";
    private static final String STATUS_AVENGER = "CheckAvengerStatus";
    private static final String CHECK_INFO = "CheckRoleAndAvengerInfo";
    
    private static final String LIST_MISSION = "ListAllMissionController";
    private static final String DEL_MISSION = "DeleteMissionController";
    private static final String SEARCH_MISSION = "SearchMissionController";
    private static final String VIEW_MISSION = "ViewMissionController";
    private static final String VIEW_MISSION_AVENGERID = "GetMissionInfoByAvengerID";
    private static final String UPDATE_MISSION_STATUS = "UpdateMissionStatusController";
    private static final String INSERT_MISSION = "InsertMissionController";
    private static final String UPDATE_MISSION = "UpdateMissionControllers";
    
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
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        String url = ERROR;
        HttpSession session = request.getSession();
        String roleSession = (String)session.getAttribute("ROLE");
        try {
            if (isMultipart) {
                url = UPLOAD;
            } else {
                String action = request.getParameter("action");
                System.out.println(action);
                if (action.equals("Login")) {
                    url = LOGIN;
                } else if (action.equals("Delete Equipment") && roleSession.equals("root")) {
                    url = DELETE_EQUIP;
                } else if (action.equals("Insert New Equipment") || action.equals("Insert Equipment") && roleSession.equals("root")) {
                    url = INSERT_EQUIP;
                } else if (action.equals("Update Equipment") || (action.equals("Edit Equipment")) && roleSession.equals("root")) {
                    url = UPDATE_EQUIP;
                } else if (action.equals("View Equipment") || action.equals("Back Equipment") && roleSession.equals("root")) {
                    url = VIEW_EQUIP;
                } else if (action.equals("Upload Avartar")) {
                    url = AVATAR;
                } else if (action.equals("List All Avenger") && roleSession.equals("root")) {
                    url = LIST;
                } else if (action.equals("List All Equipments") && roleSession.equals("root")) {
                    url = LIST_EQUIP;
                } else if (action.equals("Log Out")) {
                    url = LOGOUT;
                } else if (action.equals("Search Equipment") && roleSession.equals("root")) {
                    url = SEARCH_EQUIP;
                } else if (action.equals("Search Avenger") && roleSession.equals("root")) {
                    url = SEARCH_AVENGER;
                } else if (action.equals("View Avenger") || action.equals("Back Avenger") && roleSession.equals("root")) {
                    url = VIEW_AVENGER;
                } else if (action.equals("Delete Avenger") && roleSession.equals("root")) {
                    url = DEL_AVENGER;
                } else if (action.equals("Insert New Avenger") || action.equals("Insert Avenger") && roleSession.equals("root")) {
                    url = INSERT_AVENGER;
                } else if (action.equals("Update Avenger") || action.equals("Edit Avenger") && roleSession.equals("root")) {
                    url = UPDATE_AVENGER;
                } else if (action.equals("List Your Equipment") && roleSession.equals("admin")) {
                    url = SEARCH_EQUIP_BY_AVENGER;
                } else if (action.equals("Update Select Mark")  && roleSession.equals("admin")) {
                    url = UPDATE_ADMIN_EQUIPMENT;
                } else if (action.equals("List All Missions")) {
                    url = LIST_MISSION;
                } else if (action.equals("Delete Mission") && roleSession.equals("root")) {
                    url = DEL_MISSION;
                } else if (action.equals("Search Mission") && roleSession.equals("root")) {
                    url = SEARCH_MISSION;
                } else if (action.equals("View Mission") || action.equals("Back Mission") || action.equals("Back Mission User")) {
                    url = VIEW_MISSION;
                } else if (action.equals("Mission Notification")) {
                    url = STATUS_AVENGER;
                } else if (action.equals("View Your Mission")) {
                    url = VIEW_MISSION_AVENGERID;
                } else if (action.equals("Update Status Mission")) {
                    url = UPDATE_MISSION_STATUS;
                } else if (action.equals("Insert New Mission") || action.equals("Insert Mission") && roleSession.equals("root")) {
                    url = INSERT_MISSION;
                } else if (action.equals("Update Mission") || action.equals("Edit Mission") && roleSession.equals("root")) {
                    url = UPDATE_MISSION;
                } else if (action.equals("Check Avenger Info")) {
                    url = CHECK_INFO;
                } else {
                    request.setAttribute("ERROR", "Action is not support");
                }
            }
        } catch (Exception e) {
            log("ERROR at MainController: " + e.toString());
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
