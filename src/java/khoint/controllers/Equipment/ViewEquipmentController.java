/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoint.controllers.Equipment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import khoint.beans.JavaBean;
import khoint.dtos.EquipmentsDTO;

/**
 *
 * @author khoint0210
 */
public class ViewEquipmentController extends HttpServlet {

    private static final String BACK = "ListAllEquipmentsController";
    private static final String BACK_SEARCH = "SearchEquipmentController";
    private static final String SUCCESS = "view-equipment.jsp";
    private static final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (action.equals("View Equipment")) {
                int id = Integer.parseInt(request.getParameter("id"));
                JavaBean beans = new JavaBean();
                beans.setID(id);
                EquipmentsDTO dto = beans.getEquipmentsByPrimaryKey();
                request.setAttribute("DTO", dto);
                url = SUCCESS;
            } else if (action.equals("Back Equipment")) {
                String searchEquipment = request.getParameter("txtSearchEquipment");
                if (searchEquipment == null) {
                    url = BACK;
                } else {
                    url = BACK_SEARCH;
                }
            }
        } catch (Exception e) {
            log("ERROR at ViewEquipmentController: " + e.getMessage());
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
