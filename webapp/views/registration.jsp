<%--
  Created by IntelliJ IDEA.
  User: krugo
  Date: 24.09.2019
  Time: 14:50
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
    <link rel="stylesheet" href="/views/style.css">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
    <meta charset="UTF-8">
</head>
<body>
<a class="button_back button" href="${pageContext.servletContext.contextPath}/menu">
    <fmt:message key="login.label.back"/>
</a>
<div class="form">
    <form action="${pageContext.servletContext.contextPath}/register" method="POST">
        <label for="name"> <fmt:message key="registation.label.name"/> :</label>
        <input class="inputForm" pattern="[A-Za-z]{2,20}" type="text" id="name" name="name" placeholder=
        <fmt:message key="registation.label.name"/>
                autocomplete="off" required>

        <label for="secondName"><fmt:message key="registation.label.secondName"/>:</label>
        <input class="inputForm" pattern="[A-Za-z]{2,20}" type="text" id="secondName" name="secondName"
               placeholder=<fmt:message key="registation.label.secondName"/> autocomplete="off" required>

        <label for="nameStreet"><fmt:message key="registation.label.nameStreet"/></label>
        <input class="inputForm" type="text" id="nameStreet" name="nameStreet"
               placeholder=<fmt:message key="registation.label.nameStreet"/>
               pattern="[A-Za-z]{2,20}" autocomplete="off" required>

        <label for="numberApartment"><fmt:message key="registation.label.numAppartmant"/></label>
        <input class="inputForm" type="number" min="0" max=999" id="numberApartment" name="numberApartment"
               placeholder=<fmt:message key="registation.label.numAppartmant"/> autocomplete="off" required>

        <label for="phone"><fmt:message key="registation.label.phone"/></label>
        <input class="inputForm" type="tel" id="phone" name="phone" placeholder="3801234567" pattern="[0-9]{10}"
               maxlength="10"
               title="3801234567" required autocomplete="off" required>

        <label for="birthday"><fmt:message key="registation.label.birthday"/></label>
        <input class="inputForm" type="date" id="birthday" name="birthday" placeholder="birthday" min="1900-01-01"
               max="2019-09-25" autocomplete="off" required>
        <label for="select">
            <p> <fmt:message key="registation.label.department"/></p>
            <select name="department" id="select" required>
                <c:forEach var="dep" items="${departments}">
                    <option value=${dep.key}>${dep.value}</option>
                </c:forEach>
            </select>
        </label>
        <p> <fmt:message key="registation.label.group"/> </p>
        <label>
            <select name="group">
                <c:forEach items="${groups}" var="group">
                    <option value="${group.value.getId()}">${group.value.getName()}</option>
                </c:forEach>
            </select>
        </label>
        <input class="button button_sub" type="submit" align="center" value=<fmt:message key="registation.button.submit"/>>
    </form>
</div>


<form>
    <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        <option value="de" ${language == 'de' ? 'selected' : ''}>German</option>
        <option value="fr" ${language == 'fr' ? 'selected' : ''}>France</option>
    </select>
</form>

</body>
</html>
