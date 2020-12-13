/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.bean.EquipmentBean;
import ict.db.EquipmentDB;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raymo
 */
@WebServlet(name = "HandleEditEquipment", urlPatterns = {"/handleEditEquipment"})
public class HandleEditEquipment extends HttpServlet{
    
    private EquipmentDB db;
    
    public void init() {

        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new EquipmentDB(dbUrl, dbUser, dbPassword);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 3.  get the parameter, action, from users
        String action = request.getParameter("action");
        // 4. if action equals to “add”  
        if ("add".equalsIgnoreCase(action)) {
            // 4.1 call  the database operations  db.addRecord(id, name, tel, ag	
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            int usage = 0;
            db.addRecord(id, name, description, usage);
            // redirect the result 
            response.sendRedirect("handleEquipment?action=list");
        } else if ("edit".equalsIgnoreCase(action)) {

            // obtain the parameters from request
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            int usage = 0;
            EquipmentBean cb = new EquipmentBean(id, name, description, usage);
            db.editRecord(cb);
            // call  editCustomer to update the database record
                    // redirect the result to “list” action again
            response.sendRedirect("handleEquipment?action=list");
        } else {
            PrintWriter out = response.getWriter();
            out.println("No such action!!!");
        }
    }
    
}
