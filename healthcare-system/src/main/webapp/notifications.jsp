<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Notifications</title>
</head>
<body>
    <h1>Notifications</h1>
    <c:forEach var="notification" items="${notifications}">
        <p>${notification.message} - ${notification.timestamp}</p>
    </c:forEach>
</body>
</html>
