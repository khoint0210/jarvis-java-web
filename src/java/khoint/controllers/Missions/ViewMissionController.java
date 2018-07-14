/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoint.controllers.Missions;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import khoint.beans.JavaBean;
import khoint.dtos.AvengersDTO;
import khoint.dtos.MissionsDTO;

/**
 *
 * @author khoint0210
 */
public class ViewMissionController extends HttpServlet {

    private static final String BACK = "ListAllMissionController";
    private static final String BACK_SEARCH = "SearchMissionController";
    private static final String BACK_USER = "GetMissionInfoByAvengerID";
    private static final String SUCCESS = "view-mission.jsp";
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
            String action = request.getParameter("action");
            if (action.equals("View Mission") || action.equals("Update Status Mission")) {
                int missionID = Integer.parseInt(request.getParameter("txtMissionID"));
                JavaBean bean = new JavaBean();
                bean.setID(missionID);
                MissionsDTO mission = bean.getMissionByPrimarykey();
                List<AvengersDTO> avengerList = bean.getAvengerInMission();
                request.setAttribute("MISSION_INFO", mission);
                request.setAttribute("AVENGER_INFO", avengerList);
                url = SUCCESS;
            } else if (action.equals("Back Mission")) {
                String searchMission = request.getParameter("txtSearchMission");
                if (searchMission == null) {
                    url = BACK;
                } else {
                    url = BACK_SEARCH;
                }
            } else if (action.equals("Back Mission User")) {
                url = BACK_USER;
            }
        } catch (Exception e) {
            log("Error at ViewAvengerController : " + e.toString());
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
