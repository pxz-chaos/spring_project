<%--
  Created by IntelliJ IDEA.
  User: 华硕
  Date: 2022/6/17
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>

    </title>
</head>
<body>
<%--enctype默认="application/x-www-form-urlencoded"
这里采用enctype="multipart/form-data"即多部分表单时，request.getParameter()将失效--%>
<form action="${pageContext.request.contextPath}/user/quick24" method="post"  enctype="multipart/form-data" >

    名称：<input type="text" name="username"><br/>
    文件1：<input type="file" placeholder="请上传文件" name="multipartFile"><br/>
    文件2：<input type="file" placeholder="请上传文件" name="multipartFile"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
