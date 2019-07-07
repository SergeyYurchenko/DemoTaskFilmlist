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
    <title>FILMS</title>
</head>
<body class="w3-light-grey">
<meta charset = "utf-8">
<h2 class="w3-container w3-blue-grey w3-opacity w3-center" >Films</h2>
<table id="main-table" align="center" width="70%">
    <tr>
        <th width="5%">id</th>
        <th width="=30%">title</th>
        <th width="10%">year</th>
        <th width="20%">genre</th>
        <th width="10%">watched</th>
        <th width="5%">language</th>
        <th width="15%">action</th>
    </tr>
    <c:forEach var="film" items="${filmsList}">
        <tr align="center">
            <td width="5%" >${film.id}</td>
            <td width="=30%">${film.title}</td>
            <td width="10%">${film.year}</td>
            <td width="20%">${film.genre}</td>
            <td width="10%">${film.watched}</td>
            <td width="5%">${film.language}</td>
            <td width="20%" align="center ">

                <img src="https://image.flaticon.com/icons/svg/148/148926.svg" onclick="location.href='edit/${film.id}'" width="10%" class="w3-cell-middle" >
                <img src="https://image.flaticon.com/icons/svg/148/148962.svg" onclick="location.href='delete/${film.id}'" width="10%" class="w3-cell-middle">
            </td>
        </tr>
    </c:forEach>
</table>

<h2 class="w3-container w3-blue-grey w3-opacity w3-center" >Add and Search</h2>
<div align="center ">
<img src="https://image.flaticon.com/icons/svg/109/109433.svg" onclick="location.href='add-page'" width="5%" class="w3-cell-middle" >
<img src="https://www.flaticon.com/premium-icon/icons/svg/954/954591.svg" onclick="location.href='search-page'" width="5%" class="w3-cell-middle" >
</div>
</body>
</html>
