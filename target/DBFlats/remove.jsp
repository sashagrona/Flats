<%--
  Created by IntelliJ IDEA.
  User: olexandr
  Date: 03.03.19
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove</title>
</head>
<body>
<form action="/home?remove" method="post">
    Select id of the flat you want to be removed: <input type="number" name="id"><br>
    <input type="submit" value="Remove flat">
</form><br>
<br><a href="index.jsp">Go to the main</a>

</body>
</html>
