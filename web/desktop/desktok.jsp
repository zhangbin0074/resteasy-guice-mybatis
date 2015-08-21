<%--
  Created by IntelliJ IDEA.
  User: hunk
  Date: 2015/8/20
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%--<base href="<%=basePath%>">--%>
    <title>欢迎来到爱物色</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
</head>
<body>
<c:if test="${not empty sessionScope.user.userName}">
    <div align="right" style="width: auto">欢迎回来，<a href="user/userCenter.jsp">${user.userName}</a> &nbsp;[<a href="user/userCenter.jsp">用户中心</a>] &nbsp; [<a href="#">退出</a> ] </div>
</c:if>
<c:if test="${empty sessionScope.user.userName}">
    <div align="right">
        [<a href="login.jsp">登录</a>] &nbsp;[<a href="register.jsp">注册</a> ]
    </div>
</c:if>
<hr/>
<h1 align="left">欢迎来到爱物色</h1>
</body>
</html>
