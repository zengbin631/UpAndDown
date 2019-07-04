<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/4
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>上传信息</title>
  </head>
  <body>
      <form action="UploadServlet" method="post" enctype="multipart/form-data">
          学号：<input name="sno"><br/>
          姓名：<input name="sname"><br/>
          照片：<input type="file" name="spicture"><br/>
          <input type="submit" value="提交">
      </form>
  </body>
</html>
