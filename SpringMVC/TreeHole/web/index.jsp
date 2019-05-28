<%--
  Created by IntelliJ IDEA.
  User: hubt11585
  Date: 2019-05-20
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>

<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>我们是一个树洞</title>
  </head>
  <body>
  <a  href="http://localhost:8080/TreeHole/mvc/hello.do">点我</a>
  <a  href="http://localhost:8080/TreeHole/mvc/test.do">点我</a>
  </body>
</html>
