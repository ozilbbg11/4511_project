/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.servlet;

import ict.bean.TechnicianBean;
import ict.db.TechnicianDB;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author raymo
 */
@WebServlet(name = "SeniorLogin", urlPatterns = {"/seniorLogin"})
public class SeniorLogin extends HttpServlet{
    private TechnicianDB db;
    
    public void init() {
        String dbUser = this.getServletContext().getInitParameter("dbUser");
        String dbPassword = this.getServletContext().getInitParameter("dbPassword");
        String dbUrl = this.getServletContext().getInitParameter("dbUrl");
        db = new TechnicianDB(dbUrl, dbUser, dbPassword);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (!isAuthenticated(request)
                && !("authenticate".equals(action))) {
            doLogin(request, response);
            return;
        }
        if ("authenticate".equals(action)) {
            doAuthenticate(request, response);
        } else if ("logout".equals(action)) {
            doLogout(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_IMPLEMENTED);
        }

    }
    
    private void doAuthenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String targetURL;
        TechnicianBean bean = db.isValidUser(id, pwd,"senior");
        if (bean.getName() != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("TechnicianBean", bean);
            targetURL = "/admin.jsp";
            
        } else {
            targetURL = "/loginError.jsp?format=senior";
        }
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/" + targetURL);
        rd.forward(request, response);
    }
    
    private boolean isAuthenticated(HttpServletRequest request) {
        boolean result = false;
        HttpSession session = request.getSession();
        if (session.getAttribute("TechnicianBean") != null) {
            result = true;
        }
        return result;
    }
    private void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String targetURL = "sen_login.jsp";
        RequestDispatcher rd;
        rd = getServletContext().getRequestDispatcher("/" + targetURL);
        rd.forward(request, response);
    }

    private void doLogout(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("TechnicianBean");
            session.invalidate();
        }
        doLogin(request, response);
    }
}
