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

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private List<User> list = new ArrayList<>();

    //    static {
//        list.add(new User(13, "张三", 1));
//        list.add(new User(14, "李四", 2));
//        list.add(new User(15, "王五", 3));
//        list.add(new User(16, "成六", 4));
//    }
    public UserServlet() {
        list.add(new User(13, "张三", 1));
        list.add(new User(14, "李四", 2));
        list.add(new User(15, "王五", 3));
        list.add(new User(16, "成六", 4));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null)
            method = "findall";
        switch (method) {
            case "delete":
                String name = req.getParameter("name");
//                Integer age = Integer.parseInt(req.getParameter("age"));
//                Integer number = Integer.parseInt(req.getParameter("number"));
                for (User item : list) {
                    if (item.getName().equals(name)) {
                        list.remove(item);
                        break;
                    }
                }
                resp.sendRedirect("/users");
                break;
            case "change":
                String name1 = req.getParameter("name");
                Integer age1 = Integer.parseInt(req.getParameter("age"));
                Integer number1 = Integer.parseInt(req.getParameter("number"));
                User user = new User(age1, name1, number1);
                req.setAttribute("changeuser", user);
                req.getRequestDispatcher("JSTL/changeuser.jsp").forward(req, resp);
                break;
            case "findall":
                req.setAttribute("users", list);
                req.getRequestDispatcher("JSTL/user.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String method=req.getParameter("method");
        String name = req.getParameter("name");
        Integer number = Integer.parseInt(req.getParameter("number"));
        Integer age = Integer.parseInt(req.getParameter("age"));
        switch (method){
            case    "add":
                User user = new User(age, name, number);
                list.add(user);
                resp.sendRedirect("/users");
                break;
            case    "update":
                for (User item : list) {
                    if (item.getName().equals(name)) {
                        list.remove(item);
                        break;
                    }
                }
                resp.sendRedirect("/users");
                break;
        }
    }
}
