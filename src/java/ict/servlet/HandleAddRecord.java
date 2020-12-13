/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.bean.CartBean;
import ict.bean.InventoryBean;
import ict.bean.StudentBean;
import ict.db.InventoryDB;
import ict.db.RecordDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raymo
 */
@WebServlet(name = "HandleAddRecord", urlPatterns = {"/handleAddRecord"})

public class HandleAddRecord extends HttpServlet {

    private RecordDB db;
    private InventoryDB db2;

    public void init() {

        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new RecordDB(dbUrl, dbUser, dbPassword);
        db2 = new InventoryDB(dbUrl, dbUser, dbPassword);
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
            CartBean cart = (CartBean) request.getSession().getAttribute("cart");
            StudentBean stu = (StudentBean) request.getSession().getAttribute("StudentBean");
            ArrayList<String> i_ids = cart.getContents();
            String sid = stu.getSid();
            for (int i = 0; i < i_ids.size(); i++) {
                Date date = new Date(new Date().getTime() + 14 * 86400000);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                // 4.1 call  the database operations  db.addRecord(id, name, tel, ag
                String due_date = formatter.format(date);
                Date dNow = new Date((new Date().getTime() + i*1000));
                formatter = new SimpleDateFormat("yyMMddhhmmssMs");
                String record_id = formatter.format(dNow);
                db.addRecord(record_id, sid, i_ids.get(i), due_date, "reserved");
                InventoryBean cb = new InventoryBean(i_ids.get(i),"reserved");
                db2.editRecord(cb); // redirect the result 
            }
            response.sendRedirect("handleReserve?action=list");
        } else {
            PrintWriter out = response.getWriter();
            out.println("No such action!!!");
        }
    }

}
