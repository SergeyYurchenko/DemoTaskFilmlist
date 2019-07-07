<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Something goes wrong</title>
</head>
<body>
<div class="w3-container w3-blue-grey w3-opacity w3-center">
    <h3 align="center"> Sorry, something went wrong :(</h3>
    <h5><c:out value="${errorMessage}"/></h5>
</div>
<div class="w3-container w3-center">
<img src="https://image.flaticon.com/icons/svg/1660/1660192.svg" style="vertical-align:middle">
</div>
</body>
</html>
