<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: krugo
  Date: 25.09.2019
  Time: 2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html">>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/views/style.css">
</head>
<body>



<a class="button button_reg" href="${pageContext.servletContext.contextPath}/register">
    <fmt:message key="register"/>
</a>
<a class="button button_reg" href="${pageContext.servletContext.contextPath}/filter">
    <fmt:message key="filter"/>
</a>

</body>
</html>
