<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Doctor Dashboard</title>
</head>
<body>
    <h1>Welcome, ${doctor.name}</h1>
    <h2>Matched Patients</h2>
    <c:forEach var="patient" items="${matchedPatients}">
        <p>Patient ID: ${patient.id}, Name: ${patient.name}, Age: ${patient.age}</p>
        <a href="patientData.jsp?patientId=${patient.id}">View Patient Data</a>
    </c:forEach>
    <h2>Notifications</h2>
    <c:forEach var="notification" items="${notifications}">
        <p>${notification.message} - ${notification.timestamp}</p>
    </c:forEach>
</body>
</html>
