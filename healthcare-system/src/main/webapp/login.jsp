<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<h1>Providence Health Care</h1>
<head>
    <title>Login</title>
</head>
<body>
    <form action="patient?action=login" method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        <button type="submit">Login</button>
    </form>
    <a href="signup.jsp">Sign up</a>
</body>
</html>