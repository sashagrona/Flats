<%--
  Created by IntelliJ IDEA.
  User: olexandr
  Date: 03.03.19
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<h1>Fill all fields correctly to add flat</h1>
<body>
<form action="/home?add" method="post">
    Region  <input type="text" name="region"><br>
    Address <input type="text" name="address"><br>
    Square  <input type="number" name="square"><br>
    Rooms   <input type="number" name="rooms"><br>
    Price   <input type="number" name="price"><br>
    <input type="submit" value="Add flat">
</form><br>
<br><a href="index.jsp">Go to the main</a>

</body>
</html>
