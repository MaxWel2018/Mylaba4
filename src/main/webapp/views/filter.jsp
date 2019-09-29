<%--
  Created by IntelliJ IDEA.
  User: krugo
  Date: 25.09.2019
  Time: 11:28
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="views/bootstrap-4.3.1-dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/views/css/styleForFilter.css">
    <link rel="stylesheet" href="/views/css/tableStyle.css">
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


<section class="my-section">

    <table>
        <tr class="red">
            <td>
                <fmt:message key="registation.label.name"/>
            </td>
            <td>
                <fmt:message key="registation.label.secondName"/>
            </td>
            <td>
                <fmt:message key="registation.label.group"/>
            </td>
            <td>
                <fmt:message key="registation.label.department"/>
            </td>
            <td>
                <fmt:message key="registation.label.phone"/>
            </td>
            <td>
                <fmt:message key="registation.label.nameStreet"/>
            </td>
            <td>
                <fmt:message key="registation.label.numAppartmant"/>
            </td>
            <td>
                <fmt:message key="registation.label.birthday"/>
            </td>
        </tr>
        <c:forEach items="${filterGroup}" var="sort">
            <tr>
                <td>
                        ${sort.getName()}
                </td>
                <td>
                        ${sort.getSurname()}
                </td>
                <td>
                        ${sort.getGroup()}
                </td>
                <td>
                        ${sort.getDepartment()}
                </td>
                <td>
                        ${sort.getPhoneNumber()}
                </td>
                <td>
                        ${(sort.getAddress()).getNameStreet()}
                </td>
                <td>
                        ${(sort.getAddress()).getApartmentNumber()}
                </td>
                <td>
                        ${sort.getBirthday()}
                </td>
            </tr>
        </c:forEach>
</table>
</section>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous">
</script>
<script src="views/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>
</html>
