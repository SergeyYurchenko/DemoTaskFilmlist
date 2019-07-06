<%--
  Created by IntelliJ IDEA.
  User: Пользователь
  Date: 25.06.2019
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <c:if test="${empty film.title}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty film.title}">
        <title>Edit</title>
    </c:if>

</head>
<body>
<c:if test="${empty film.title}">
    <c:url value="/add-operation" var="var"/>
</c:if>
<c:if test="${!empty film.title}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty film.title}">
        <input type="hidden" name="id" value="${film.id}">
    </c:if>
    <label for="title">Title</label>
    <input type="text" name="title" id="title" required>
    <label for="year">Year</label>
    <input type="text" name="year" id="year" required pattern="[1,2]{1}[0-9]{3}" placeholder="Enter only number">
    <label for="genre">Genre</label>
    <input type="text" name="genre" id="genre" required>
    <label for="language">Language</label>
    <select type="text" name="language" id="language" size="1" >
        <option selected value="UA">UA</option>
        <option value="EN">EN</option>
        <option value="RU">RU</option>
    </select>
    <label for="watched">Watched</label>
    <select type="text" name="watched" id="watched" size="1">
        <option selected value="true">True</option>
        <option value="false">False</option>
    </select>
    <c:if test="${empty film.title}">
        <input type="submit" value="Add new film" >
    </c:if>
    <c:if test="${!empty film.title}">
        <input type="submit" value="Edit film">
    </c:if>
</form>
</body>
</html>
