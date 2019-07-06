<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 25.06.2019
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<c:url value="/search-film" var="var"/>
<form action="${var}" method="GET">
    <input type="search" name="searchPart" id="searchPart" required placeholder="Enter your film">
    <br>
    <button > <img src="https://www.flaticon.com/premium-icon/icons/svg/954/954591.svg" style="vertical-align:middle" align="center"></button>
</form>
</body>
</html>