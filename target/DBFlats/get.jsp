<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: olexandr
  Date: 03.03.19
  Time: 19:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>GetList</title>
</head>
<body>
<h1>List of Flats</h1>
    <table border="1">
        <c:forEach items="${fullList}" var="o">
            <tr>
                <td><c:out value="${o.id}"/></td>
                <td><c:out value="${o.region}"/></td>
                <td><c:out value="${o.address}"/></td>
                <td><c:out value="${o.square}"/></td>
                <td><c:out value="${o.rooms}"/></td>
                <td><c:out value="${o.price}"/></td>
            </tr>
        </c:forEach>
    </table>
    <br><a href="index.jsp">Go to the main</a>


</body>
</html>
