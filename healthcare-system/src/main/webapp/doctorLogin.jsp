<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<h1>Providence Health care</h1>
<h2>Doctor login</h2>
<head>
    <title>Doctor Login</title>
</head>
<body>
    <form action="doctor?action=login" method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br>
        <button type="submit">Login</button>
    </form>
    <a href="doctorSignup.jsp">Sign up</a>
</body>
</html>
