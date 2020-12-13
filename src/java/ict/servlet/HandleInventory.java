/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.bean.EquipmentBean;
import ict.bean.InventoryBean;
import ict.db.EquipmentDB;
import ict.db.InventoryDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raymo
 */
@WebServlet(name = "HandleInventory", urlPatterns = {"/handleInventory"})
public class HandleInventory extends HttpServlet {

    private InventoryDB db;
    private EquipmentDB db2;

    public void init() {

        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new InventoryDB(dbUrl, dbUser, dbPassword);
        db2 = new EquipmentDB(dbUrl, dbUser, dbPassword);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("list".equalsIgnoreCase(action)) {
            // call the query db to get retrieve for all customer 
            ArrayList<InventoryBean> inventory = db.queryCust();
            // set the result into the attribute	 
            request.setAttribute("inventory", inventory);
            // redirect the result to the listCustomers.jsp
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/listInventory.jsp");
            rd.forward(request, response);
        } else if ("delete".equalsIgnoreCase(action)) {
            String id = request.getParameter("id");
            // get parameter, id, from the request
            if (id != null) {
                // call delete record method in the database
                db.delRecord(id);
                // redirect the result to list action 
                response.sendRedirect("handleInventory?action=list");
            }
        } else if ("getEditCustomer".equalsIgnoreCase(action)) {

            // call  query db to get retrieve for a customer with the given id
            ArrayList<EquipmentBean> customer = db2.queryCust();
            // set the customer as attribute in request scope
            request.setAttribute("c", customer);
            // forward the result to the editCustomer.jsp
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/editInventory.jsp");
            rd.forward(request, response);

        } else {
            PrintWriter out = response.getWriter();
            out.println("No such action!!!");
        }
    }
}
