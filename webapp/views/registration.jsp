<%--
  Created by IntelliJ IDEA.
  User: krugo
  Date: 24.09.2019
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/views/style.css">
</head>
<body>
<a class="button_back button" href="${pageContext.servletContext.contextPath}/menu">Назад</a>
<div class="form">
    <form action="${pageContext.servletContext.contextPath}/register" method="POST">
        <label for="name">Name :</label>
        <input class="inputForm" pattern="[A-Za-zА-Яа-яЁё]{2,20}" type="text" id="name" name="name" placeholder="Name"
               autocomplete="off">

        <label for="secondName">Second name :</label>
        <input class="inputForm" pattern="[A-Za-zА-Яа-яЁё]{2,20}" type="text" id="secondName" name="secondName"
               placeholder="Second name" autocomplete="off">

        <label for="nameStreet">Name Street:</label>
        <input class="inputForm" type="text" id="nameStreet" name="nameStreet" placeholder="Name Street"
               pattern="[A-Za-zА-Яа-яЁё]{2,20}" autocomplete="off">

        <label for="numberApartment">Number apartment:</label>
        <input class="inputForm" type="number" min="0" max="1000" id="numberApartment" name="numberApartment"
               placeholder="Number apartment" autocomplete="off">

        <label for="phone">Phone:</label>
        <input class="inputForm" type="tel" id="phone" name="phone" placeholder="3801234567" pattern="[0-9]{10}"
               maxlength="10"
               title="3801234567" required autocomplete="off">

        <label for="birthday">BirthDay:</label>
        <input class="inputForm" type="date" id="birthday" name="birthday" placeholder="birthday" autocomplete="off">

        <label for="select">
            <p> Department </p>
            <select name="department" id="select">
                <c:forEach var="dep" items="${departments}">
                    <option value=${dep.key}>${dep.value}</option>
                </c:forEach>
            </select>
        </label>
        <p> Group </p>
        <label>
            <select name="group">
                <c:forEach items="${groups}" var="group">
                    <c:forEach items="${group.value}" var="item">
                        <option value="${item.getId()}">${item}</option>
                    </c:forEach>
                </c:forEach>
            </select>
        </label>
        <input class="button button_sub" type="submit" align="center" value="Submit"/>

    </form>
</div>


</body>
</html>
