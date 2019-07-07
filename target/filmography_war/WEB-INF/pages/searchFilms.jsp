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
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Search</title>
</head>
<body class="w3-light-grey">
<h2 class="w3-container w3-blue-grey w3-opacity w3-center" >Search</h2>
<c:url value="/search-film" var="var"/>
<form action="${var}" method="GET">
    <div class="w3-container w3-center" font-size="50px">
        <input type="search" name="searchPart" id="searchPart" required placeholder="Enter your film" width="80%">
        <br>
        <button >Search</button>
        <button  align=" center" onclick="location.href='/filmography_war/'"> Main</button>
    </div>
</form>
</body>
</html>