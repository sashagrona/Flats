<%--
  Created by IntelliJ IDEA.
  User: olexandr
  Date: 03.03.19
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Optional</title>
</head>
<body>
<h2>You are on a page, where you can find flat, you're interested in, by special criterias:</h2>
<form action="/home" method="get">
    <p>Here you can find flat in a specific region.Just put the name of region</p>
    <input type="text" name="region">
    <input type="submit" value="Find">
</form>
<form action="/home" method="get">
    <p>Here you can find flat by address. Just put first chars of the street, if you are not sure in it's name</p>
    <input type="text" name="address">
    <input type="submit" value="Find">
</form>
<form action="/home" method="get">
    <p>Here you can find flat with a bigger square than you input.Just put the minimum square.</p>
    <input type="number" name="square">
    <input type="submit" value="Find">
</form>
<form action="/home" method="get">
    <p>Here you can find flat depends on the rooms quantity.Put minimum number of rooms.</p>
    <input type="number" name="rooms">
    <input type="submit" value="Find">
</form>
<form action="/home" method="get">
    <p>Here you can find flat depends on the cost.Put the maximum price of the flat.</p>
    <input type="number" name="price">
    <input type="submit" value="Find">
</form>

<p><a href="index.jsp"> Go to the main page </a></p>

</body>
</html>
