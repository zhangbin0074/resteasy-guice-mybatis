<%--
  Created by IntelliJ IDEA.
  User: hunk
  Date: 2015/8/20
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>register</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
</head>
<body>
<form action="rest/" method="post">
    <table align="center" border="1" cellpadding="3" cellspacing="0">
        <tr>
            <td>用户名</td>
            <td>
                <input type="text" id="userName" name="userName"/>
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input  type="password" id="password" name="password"/>
            </td>
        </tr>
        <tr>
            <td>确认密码</td>
            <td>
                <input  type="password" id="rePassword" name="rePassword"/>
            </td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>
                <input type="text" id="email" name="email"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
