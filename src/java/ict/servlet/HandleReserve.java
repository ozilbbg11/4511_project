/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.bean.CartBean;
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
@WebServlet(name = "HandleReserve", urlPatterns = {"/handleReserve"})
public class HandleReserve extends HttpServlet {

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
            rd = getServletContext().getRequestDispatcher("/listReserve.jsp");
            rd.forward(request, response);
        } else if ("delete".equalsIgnoreCase(action)) {
            String id = request.getParameter("id");
            if (id != null) {
                CartBean cart = (CartBean) request.getSession().getAttribute("cart");
                cart.removeCart(id);
                ArrayList<InventoryBean> inventory = db.queryCust();
                request.setAttribute("c", inventory);
                RequestDispatcher rd;
                rd = getServletContext().getRequestDispatcher("/ShowCart.jsp");
                rd.forward(request, response);
            }

        }
        else if ("getEditCustomer".equalsIgnoreCase(action)) {
            String id = request.getParameter("id");
            if (id != null) {
                CartBean cart = (CartBean) request.getSession().getAttribute("cart");
                cart.addCart(id);
                ArrayList<InventoryBean> inventory = db.queryCust();
                request.setAttribute("c", inventory);
                RequestDispatcher rd;
                rd = getServletContext().getRequestDispatcher("/ShowCart.jsp");
                rd.forward(request, response);
            }

        } else {
            PrintWriter out = response.getWriter();
            out.println("No such action!!!");
        }
    }

}
