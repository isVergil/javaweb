package com.fileupload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        String fileName = "";
        switch (type) {
            case "png":
                fileName = "1.png";
                break;
            case "txt":
                fileName = "test.txt";
                break;
        }

        //设置响应方式 down方式 让客户端下载 否则直接响应了
        resp.setContentType("application/x-msdownload");
        //设置下载之后的文件名
        resp.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        //获取输出流
        OutputStream outputStream = resp.getOutputStream();
        String path = req.getServletContext().getRealPath("files/" + fileName);
        InputStream inputStream = new FileInputStream(path);
        int temp = 0;
        while ((temp = inputStream.read()) != -1)
            outputStream.write(temp);
        inputStream.close();
        outputStream.close();
    }
}
