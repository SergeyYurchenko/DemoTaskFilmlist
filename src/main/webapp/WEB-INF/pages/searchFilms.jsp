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
<form method="GET">
    <input type="text" name="searchPart" id="searchPart">
    <input type="submit" value="Search film">
</form>
</body>
</html>