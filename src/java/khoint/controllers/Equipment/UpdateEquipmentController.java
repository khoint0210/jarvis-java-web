/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoint.controllers.Equipment;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import khoint.beans.JavaBean;
import khoint.dtos.AvengersDTO;
import khoint.dtos.EquipmentsDTO;

/**
 *
 * @author khoint0210
 */
public class UpdateEquipmentController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String UPDATE = "update-equipment.jsp";
    private static final String SUCCESS = "ListAllEquipmentsController";
    private static final String INVALID = "update.jsp";

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
            if (action.equals("Update Equipment")) {
                int id = Integer.parseInt(request.getParameter("id"));
                int avenger_id = Integer.parseInt(request.getParameter("avenger_id"));
                bean.setID(id);
                EquipmentsDTO dto = bean.getEquipmentsByPrimaryKey();
                request.setAttribute("EQUIPMENT_INFO", dto);
                bean.setID(avenger_id);
                List<AvengersDTO> result = bean.selectedAvengersOnTop();
                request.setAttribute("AVENGER_LIST", result);
                url = UPDATE;
            } else if (action.equals("Edit Equipment")) {
                int equipmentID = Integer.parseInt(request.getParameter("txtEquipmentID"));
                int avengerID = Integer.parseInt(request.getParameter("txtAvengerID"));
                String name = request.getParameter("txtEquipmentName");
                String description = request.getParameter("txtDescription");
                EquipmentsDTO equipmentsDTO = new EquipmentsDTO(equipmentID, avengerID, name, description);
                bean.setEquipment(equipmentsDTO);
                if (bean.updateEquipment()) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "UNABLE TO UPDATE NEW EQUIPMENT");
                }
            }
        } catch (Exception e) {
            log("Error at UpdateEquipmentController : " + e.toString());
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
