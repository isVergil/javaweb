package com.servlet;

import com.el.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/UsersTest")
public class ServletUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = new ArrayList<>();
        userList.add(new User(13, "张三", 1));
        userList.add(new User(14, "李四", 2));
        userList.add(new User(15, "王五", 3));
        userList.add(new User(16, "成六", 4));
        req.setAttribute("users", userList);
        req.getRequestDispatcher("JSTL/test.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
