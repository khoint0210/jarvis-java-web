/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoint.controllers.Missions;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import khoint.beans.JavaBean;
import khoint.dtos.MissionsDTO;

/**
 *
 * @author khoint0210
 */
public class InsertMissionController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String INSERT = "insert-mission.jsp";
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
            if (action.equals("Insert New Mission")) {
                url = INSERT;
            } else if (action.equals("Insert Mission")) {
                LocalDateTime startDate = LocalDateTime.parse(request.getParameter("txtStartDate"));
                LocalDateTime endDate = LocalDateTime.parse(request.getParameter("txtEndDate"));
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
                    url = INSERT;
                } else {
                    String name = request.getParameter("txtMissionName");
                    String location = request.getParameter("txtLocation");
                    String startDateString = startDate.format(format);
                    String endDateString = endDate.format(format);
                    System.out.println(startDateString);
                    MissionsDTO missionsDTO = new MissionsDTO(name, startDateString, endDateString, location);
                    bean.setMissionsDTO(missionsDTO);
                    if (bean.insertNewMission()) {
                        url = SUCCESS;
                    } else {
                        request.setAttribute("ERROR", "UNABLE TO INSERT NEW EQUIPMENT");
                    }
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
