/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoint.controllers.Missions;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class UpdateMissionControllers extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String UPDATE = "update-mission.jsp";
    private static final String SUCCESS = "ListAllMissionController";
    private static final String SUCCESS_SEARCH = "SearchMissionController";

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
        JavaBean bean = new JavaBean();
        try {
            String action = request.getParameter("action");
            int missionID = Integer.parseInt(request.getParameter("txtMissionID"));
            bean.setID(missionID);
            MissionsDTO dto = bean.getMissionByPrimarykey();
            List<AvengersDTO> result = bean.getAvengerNotOnThisMission();
            List<AvengersDTO> avengerList = bean.getAvengerInMission();
            if (action.equals("Update Mission")) {
                request.setAttribute("MISSION_INFO", dto);
                request.setAttribute("AVENGER_FREE_ON_MISSION", result);
                request.setAttribute("AVENGER_INFO", avengerList);
                url = UPDATE;
            } else if (action.equals("Edit Mission")) {

                LocalDateTime startDate = LocalDateTime.parse(request.getParameter("txtStartDate"));
                System.out.println(startDate);

                LocalDateTime endDate = LocalDateTime.parse(request.getParameter("txtEndDate"));
                System.out.println(endDate);
                boolean isError = false;

                LocalDateTime current = LocalDateTime.now();
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                if (endDate.isBefore(startDate)) {
                    request.setAttribute("ERROR_DATE", "HOW END DATE CAN BEFORE START DATE ??");
                    isError = true;
                }

                if (startDate.isBefore(current)) {
                    request.setAttribute("ERROR_DATE", "YOU TRAVEL BACK IN TIME TO DO MISSION ??");
                    isError = true;
                }

                if (isError) {
                    request.setAttribute("MISSION_INFO", dto);
                    request.setAttribute("AVENGER_FREE_ON_MISSION", result);
                    request.setAttribute("AVENGER_INFO", avengerList);
                    url = UPDATE;
                } else {
                    String txtSearchMission = request.getParameter("txtSearchMission");
                    int ID = Integer.parseInt(request.getParameter("txtMissionID"));
                    int avengerID = Integer.parseInt(request.getParameter("txtAvengerID"));
                    String name = request.getParameter("txtMissionName");
                    String startDateString = startDate.format(format);
                    String endDateString = endDate.format(format);
                    String location = request.getParameter("txtLocation");
                    MissionsDTO missionsDTO = new MissionsDTO(ID, name, startDateString, endDateString, location);
                    if (avengerID > 0) {
                        bean.setID(ID);
                        bean.setStatus(avengerID);
                        bean.setMissionsDTO(missionsDTO);
                        if (bean.updateMission() && bean.insertAvengerOnMission()) {
                            if (txtSearchMission == null) {
                                url = SUCCESS;
                            } else {
                                url = SUCCESS_SEARCH;
                            }
                        } else {
                            request.setAttribute("ERROR", "UNABLE TO UPDATE NEW EQUIPMENT");
                        }
                    } else {
                        bean.setMissionsDTO(missionsDTO);
                        if (bean.updateMission()) {
                            if (txtSearchMission == null) {
                                url = SUCCESS;
                            } else {
                                url = SUCCESS_SEARCH;
                            }
                        } else {
                            request.setAttribute("ERROR", "UNABLE TO UPDATE NEW EQUIPMENT");
                        }
                    }
                }
            }
        } catch (Exception e) {
            log("Error at UpdateMissionController : " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    public UpdateMissionControllers() {
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
