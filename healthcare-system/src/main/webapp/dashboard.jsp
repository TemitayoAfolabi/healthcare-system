<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <h1>Providence Health Care</h1>
<head>
    <title>Dashboard</title>
</head>
<body>
    <h1>Welcome, ${patient.name}</h1>
    <p>Age: ${patient.age}</p>
    <p>Email: ${patient.email}</p>
    <h2>Real-time Heart Activity</h2>
    <div style="border: 1px solid black; padding: 10px;">
        <p>Heart Rate: ${patient.heartRate}</p>
        <p>ECG Data: ${patient.ecgData}</p>
    </div>
    <h2>Alerts</h2>
    <div style="border: 1px solid black; padding: 10px;">
        <c:forEach var="alert" items="${alerts}">
            <p>${alert.message} - ${alert.timestamp}</p>
        </c:forEach>
    </div>
    <h2>Schedule a Telemedicine Session</h2>
    <div style="border: 1px solid black; padding: 10px;">
        <form action="telemedicine" method="post">
            <input type="hidden" name="action" value="create">
            <input type="hidden" name="patientId" value="${patient.id}">
            <label for="doctorId">Doctor ID:</label>
            <input type="number" id="doctorId" name="doctorId" required><br>
            <button type="submit">Schedule</button>
        </form>
    </div>
    <p>Heart Rate: ${patient.heartRate}</p>
    <p>ECG Data: ${patient.ecgData}</p>
    <h2>Alerts</h2>
    <c:forEach var="alert" items="${alerts}">
        <p>${alert.message} - ${alert.timestamp}</p>
    </c:forEach>
    <h2>Schedule a Telemedicine Session</h2>
    <form action="telemedicine" method="post">
        <input type="hidden" name="action" value="create">
        <input type="hidden" name="patientId" value="${patient.id}">
        <label for="doctorId">Doctor ID:</label>
        <input type="number" id="doctorId" name="doctorId" required><br>
        <button type="submit">Schedule</button>
    </form>
</body>
</html>
