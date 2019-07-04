package org.test.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        boolean multipartContent = ServletFileUpload.isMultipartContent(req);
        if(multipartContent){//判断前台的form是否有哦multipart属性
            FileItemFactory fileItemFactory=new DiskFileItemFactory();
            ServletFileUpload upload=new ServletFileUpload(fileItemFactory);
            List<FileItem> fileItems = null;
            try {
                fileItems = upload.parseRequest(req);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            Iterator<FileItem> iterator = fileItems.iterator();
            while (iterator.hasNext()){
                FileItem next = iterator.next();
                if(next.isFormField()){
                    if(next.getFieldName().equals("sno")){
                        int sno=Integer.parseInt(next.getString());
                        System.out.println(sno);
                    }else if(next.getFieldName().equals("sname")){
                        String sname=next.getString();
                        System.out.println(sname);
                    }
                }
                else{
                    String filename=next.getName();
                    File file=new File("D:\\upload",filename);
                    try {
                        next.write(file);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
