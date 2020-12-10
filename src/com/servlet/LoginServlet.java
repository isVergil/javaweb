package com.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private String username;
    private String psw;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        username = req.getParameter("username");
        psw = req.getParameter("psw");
        //req.setAttribute("username","admin");
        //req.setAttribute("psw","123");
        //解决request生命周期太短的问题
        session.setAttribute("username", "admin");
        session.setAttribute("psw", "123");
        if (("admin").equals(username) && ("123").equals(psw)) {
            //req.getRequestDispatcher("/LoginTest2/welcome.jsp").forward(req, resp);
            resp.sendRedirect("/LoginTest2/welcome.jsp");
        }
    }
}
