/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khoint.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import khoint.beans.JavaBean;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 *
 * @author khoint0210
 */
public class UploadController extends HttpServlet {

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
        HttpSession session = request.getSession();
        int avengerID = (int) session.getAttribute("ID");
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List items = null;
        String action = null;
        try {
            items = upload.parseRequest(new ServletRequestContext(request));
            Iterator iter = items.iterator();
            String itemName = "";
            String filename = "";
            String uploadPath = "";
            String realpath = "";
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (!item.isFormField()) {
                    action = item.getFieldName();
                }
                JavaBean bean = new JavaBean();
                if (item.getName() != null) {
                    itemName = item.getName();
                    filename = itemName.substring(itemName.lastIndexOf("\\") + 1);
                    uploadPath = "/Users/khoint0210/NetBeansProjects/JARVIS_1.1/web/image/" + filename;
                    realpath = "/JARVIS_1.1/image/" + filename;
                }
                if (action.equals("Upload Avatar")) {
                    try {
                        if (filename.contains("jpg") || filename.contains("JPG") || filename.contains("png") || filename.contains("PNG")) {
                            File savedFile = new File(uploadPath);
                            item.write(savedFile);
                            bean.setID(avengerID);
                            bean.setAvatarPath(realpath);
                            if (!bean.updateAvatar()) {
                                request.setAttribute("ERROR", "UNABLE TO UPDATE");
                            }
                        } else {
                            request.setAttribute("ERROR", "UNABLE TO UPDATE");
                        }
                    } catch (Exception e) {
                        log("Error at UploadController : " + e.toString());
                    }
                } else if (action.equals("Upload Equipment Avatar")) {
                    try {
                        if (filename.contains("jpg") || filename.contains("JPG") || filename.contains("png") || filename.contains("PNG")) {
                            int equipmentID = 0;
                            if (item.isFormField()) {
                                equipmentID = Integer.parseInt(item.getFieldName());
                            }
                            if (!item.isFormField()) {
                                File savedFile = new File(uploadPath);
                                item.write(savedFile);
                            }
                            bean.setID(equipmentID);
                            bean.setAvatarPath(realpath);
                            if (!bean.updateEquipmentAvatar()) {
                                request.setAttribute("ERROR", "UNABLE TO UPDATE");
                            } else {
                                request.setAttribute("ERROR", "UPDATE AVATAR EQUIPMENT SUCCESS");
                            }
                        } else {
                            request.setAttribute("ERROR", "UNABLE TO UPDATE");
                        }

                    } catch (Exception e) {
                        log("Error at UploadController : " + e.toString());
                    }
                }
            }
        } catch (FileUploadException e) {
            log("Error at UploadController : " + e.toString());
        }
        request.getRequestDispatcher("CheckRoleAndAvengerInfo").forward(request, response);
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
