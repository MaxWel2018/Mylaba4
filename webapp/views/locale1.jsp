<%--
  Created by IntelliJ IDEA.
  User: krugo
  Date: 26.09.2019
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Some</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/DemoLocale?language=en_US"> US</a>
<a href="${pageContext.request.contextPath}/DemoLocale?language=fr_FR"> FR</a>

<h3>Locale of ${country}</h3>
format Number: ${fnumber}
Format Currency: ${fcurrency}
/<br>

Format String : $string

</body>
</html>
