package com.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


@WebServlet("/demo1")
public class MyServlet implements Servlet {

    public MyServlet() {
        System.out.println("创建了Servlet对象");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println(servletConfig.getServletContext());
        System.out.println("对Servlet完成初始化操作");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//        String id = servletRequest.getParameter("id");
//        System.out.println("我是servlet，已经接收到信息了,参数是" + id);
//        servletResponse.setContentType("text/html;charset=utf-8");
//        servletResponse.getWriter().write("Hello客户");
        System.out.println("执行了Servlet业务方法");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("释放了Servlet对象");
    }
}
