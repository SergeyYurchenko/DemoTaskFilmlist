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
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
    <title>FILMS</title>
</head>
<body>
<meta charset = "utf-8">
<h2 align="center">Films</h2>
<table id="main-table" align="center">
    <tr>
        <th>id</th>
        <th>title</th>
        <th>year</th>
        <th>genre</th>
        <th>watched</th>
        <th>language</th>
        <th>action</th>
    </tr>
    <c:forEach var="film" items="${filmsList}">
        <tr>
            <td>${film.id}</td>
            <td>${film.title}</td>
            <td>${film.year}</td>
            <td>${film.genre}</td>
            <td>${film.watched}</td>
            <td>${film.language}</td>
            <td>

                <form action="/edit/${film.id}">
                    <button type="submit"> <img src="https://image.flaticon.com/icons/svg/149/149850.svg" style="vertical-align:middle"></button>
                </form>
                <form action="/delete/${film.id}">
                    <button type="submit"> <img src="https://image.flaticon.com/icons/svg/148/148962.svg" style="vertical-align:middle"></button>
                </form>
                <a href="/edit/${film.id}">edit</a>
                <a href="">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2 align="center">Add and Search</h2>
<c:url value="/add-page" var="add"/>
<a href="${add}" align=" center">Add new film</a>
<c:url value="/search-page" var="search"/>
<a href="${search}" align="center">Search Film</a>
</body>
</html>
