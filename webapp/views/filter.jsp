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
    <link rel="stylesheet" href="/views/style.css">
    <link rel="stylesheet" href="/views/tableStyle.css">
</head>
<body>

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


<a class="button button_reg" href="${pageContext.servletContext.contextPath}/menu"> <fmt:message key="registation.button.submit"/></a>
<form>
    <select id="language" name="language" onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        <option value="de" ${language == 'de' ? 'selected' : ''}>German</option>
        <option value="fr" ${language == 'fr' ? 'selected' : ''}>France</option>
    </select>
</form>

</body>
</html>
