<%--
  Created by IntelliJ IDEA.
  User: krugo
  Date: 25.09.2019
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/views/tableStyle.css">
</head>
<body>

<table>

    <tr class="red">
        <td>
           Name
        </td>
        <td>
           SurName
        </td>
        <td>
           Group
        </td>
        <td>
          Department
        </td>
        <td>
           Phone Number
        </td>
        <td>
           Street
        </td>
        <td>
        Apartment Number
        </td>
        <td>
           BirthDay
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

</body>
</html>
