<%--
  Created by IntelliJ IDEA.
  User: krugo
  Date: 25.09.2019
  Time: 2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="messages"/>
<html lang="${param.lang}">
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/style.css">
</head>
<body>

<div class = flex   style="display: flex;justify-content:space-between ">
<div class="buttons">
    <a class="button button_reg" href="${pageContext.servletContext.contextPath}/register">
    <fmt:message key="login.label.registration"/>
</a>
    <a class="button button_reg" href="${pageContext.servletContext.contextPath}/filter">
        <fmt:message key="login.label.filter"/>
    </a>
</div>


<form >
    <select id="language" name="language" onchange="submit()" style="margin-top: 0;">
        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        <option value="de" ${language == 'de' ? 'selected' : ''}>German</option>
        <option value="fr" ${language == 'fr' ? 'selected' : ''}>France</option>
    </select>
</form>
</div>

</body>
</html>
