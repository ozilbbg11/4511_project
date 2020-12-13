/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.bean.EquipmentBean;
import ict.bean.RecordBean;
import ict.bean.StudentBean;
import ict.db.RecordDB;
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
@WebServlet(name = "HandleOrder", urlPatterns = {"/handleOrder"})
public class HandleOrder extends HttpServlet{
    private RecordDB db;
    public void init() {

        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new RecordDB(dbUrl, dbUser, dbPassword);
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
        StudentBean stu = (StudentBean) request.getSession().getAttribute("StudentBean");
        if ("list".equalsIgnoreCase(action)) {
            // call the query db to get retrieve for all customer 
            
            
            ArrayList<RecordBean> record = db.queryCustByID(stu.getSid());
            // set the result into the attribute	 
            request.setAttribute("record", record);
            // redirect the result to the listCustomers.jsp
            RequestDispatcher rd;
            rd = getServletContext().getRequestDispatcher("/profile.jsp");
            rd.forward(request, response);
        } else if ("delete".equalsIgnoreCase(action)) {
            String id = request.getParameter("id");
            String iid = request.getParameter("iid");
            // get parameter, id, from the request
            if (id != null&&iid != null) {
                // call delete record method in the database
                db.delRecord(id, iid);
                // redirect the result to list action 
                response.sendRedirect("handleOrder?action=list");
            }
        }else {
            PrintWriter out = response.getWriter();
            out.println("No such action!!!");
        }
    }
    
}
