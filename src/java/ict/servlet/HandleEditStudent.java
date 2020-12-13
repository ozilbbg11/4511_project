/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;
import ict.bean.StudentBean;
import ict.db.StudentDB;
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
@WebServlet(name = "HandleEditStudent", urlPatterns = {"/handleEditStudent"})
public class HandleEditStudent extends HttpServlet{
    
    private StudentDB db;
     
    public void init() {

        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new StudentDB(dbUrl, dbUser, dbPassword);
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
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            db.addRecord(id, pwd, name, email);
            // redirect the result 
            response.sendRedirect("handleStudent?action=list");
        } else if ("edit".equalsIgnoreCase(action)) {

            // obtain the parameters from request
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            StudentBean cb = new StudentBean(id, pwd, name, email);
            db.editRecord(cb);
            // call  editCustomer to update the database record
                    // redirect the result to “list” action again
            response.sendRedirect("handleStudent?action=list");
        } else {
            PrintWriter out = response.getWriter();
            out.println("No such action!!!");
        }
    }
    
    
}
