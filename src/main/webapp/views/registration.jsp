<%--
  Created by IntelliJ IDEA.
  User: krugo
  Date: 24.09.2019
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ taglib uri="http://bootstrapjsp.org/" prefix="b" %>--%>
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="views/bootstrap-4.3.1-dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/views/css/stylyForRegestration.css">
    <meta charset="UTF-8">
</head>
<body>
<header class="flex  headerReg">
    <div class="btn-back flex ">
    <a class=" btn btn-primary " href="${pageContext.servletContext.contextPath}/menu">

        <fmt:message key="login.label.back"/> </a>
    </div>

    <form action="" class="select-reg">
        <select class="custom-select  select-size" id="language" name="language"
                onchange="submit()">
            <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
            <option value="de" ${language == 'de' ? 'selected' : ''}>German</option>
            <option value="fr" ${language == 'fr' ? 'selected' : ''}>France</option>
        </select>
    </form>
</header>
<div class="container">
    <div class=" row form justify-content-center ">
    <form action="${pageContext.servletContext.contextPath}/register" method="POST">
        <label for="name"> <fmt:message key="registation.label.name"/> :</label>
        <input class="inputForm" pattern=${REGEX_FOR_NAME} type="text" id="name" name="name" placeholder=
        <fmt:message key="registation.label.name"/>
                autocomplete="off" required>

        <label for="secondName"><fmt:message key="registation.label.secondName"/>:</label>
        <input class="inputForm" pattern=${REGEX_FOR_NAME} type="text" id="secondName" name="secondName"
               placeholder=
               <fmt:message key="registation.label.secondName"/> autocomplete="off" required>

        <label for="nameStreet"><fmt:message key="registation.label.nameStreet"/></label>
        <input class="inputForm" type="text" id="nameStreet" name="nameStreet"
               placeholder=
               <fmt:message key="registation.label.nameStreet"/>
                       pattern=${REGEX_FOR_NAME} autocomplete="off" required>

        <label for="numberApartment"><fmt:message key="registation.label.numAppartmant"/></label>
        <input class="inputForm" pattern=${REGEX_FOR_NUMBER} type="number" min="0" max=999" id="numberApartment"
               name="numberApartment"
               placeholder=
               <fmt:message key="registation.label.numAppartmant"/> autocomplete="off" required>

        <label for="phone"><fmt:message key="registation.label.phone"/></label>
        <input class="inputForm" type="tel" id="phone" name="phone" placeholder="3801234567"
               pattern=${REGEX_FOR_PHONE_NUMBER}
                       maxlength="10"
               title="3801234567" required autocomplete="off" required>

        <label for="birthday"><fmt:message key="registation.label.birthday"/></label>
        <input class="inputForm" type="date" id="birthday" name="birthday" placeholder="birthday" min="1900-01-01"
               max="2019-09-25" autocomplete="off" required>
        <p><fmt:message key="registation.label.group"/></p>
        <label>
            <select name="group">
                <c:forEach items="${groups}" var="group">
                    <option value="${group.value.getId()}">${group.value.getName()}</option>
                </c:forEach>
            </select>
        </label>
        <br>
        <input class="btn btn-success btn-reg" type="submit" align="center" value=<fmt:message
                key="registation.button.submit"/>>
    </form>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous">
</script>
<script src="views/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>

</html>
