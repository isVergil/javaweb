package com.fileupload;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //uper.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String img = req.getParameter("img");
//        System.out.println(img);  null

//        resp.setContentType("text/html;charset=UTF-8");
//        //req.setCharacterEncoding("ASCII");
//        //字节流
//        InputStream inputStream = req.getInputStream();
//        //字符流
//        Reader reader = new InputStreamReader(inputStream,"UTF-8");
//        //缓冲流
//        BufferedReader bufferedReader = new BufferedReader(reader);
//        //输出流 输出到文件路径
//        //获取文件本地路径
//        String path=req.getServletContext().getRealPath("file/copy.txt");
//        OutputStream outputStream = new FileOutputStream(path);
//        Writer writer=new OutputStreamWriter(outputStream);
//        BufferedWriter bufferedWriter=new BufferedWriter(writer);
//        String str = "";
//        while ((str = bufferedReader.readLine()) != null) {
//            bufferedWriter.write(str);
//            System.out.println(str);
//        }
//        bufferedWriter.close();
//        writer.close();
//        outputStream.close();
//        bufferedReader.close();
//        reader.close();
//        inputStream.close();
        try {
            DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            List<FileItem> list = servletFileUpload.parseRequest(req);

            for (FileItem fileItem : list) {
//                System.out.println(fileItem.getName());
//                System.out.println(fileItem.getFieldName());
                //表示取到的和 type 相同
                if (fileItem.isFormField()) {
                    String name = fileItem.getFieldName();
                    String value = fileItem.getString("UTF-8");
                    System.out.println(name + ":" + value);
                } else {
                    String fileName = fileItem.getName();
                    long size = fileItem.getSize();
                    System.out.println(fileName + ":" + size + "Byte");
                    InputStream inputStream = fileItem.getInputStream();
                    String path = req.getServletContext().getRealPath("file/" + fileName);
                    OutputStream outputStream = new FileOutputStream(path);
                    int temp = 0;
                    while ((temp = inputStream.read()) != -1) {
                        outputStream.write(temp);
                    }
                    outputStream.close();
                    inputStream.close();
                    System.out.println("上传成功!");
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }


    }
}
