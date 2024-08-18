/**
 * This file represents the NotificationController class, which is responsible for handling notifications in the healthcare system.
 * It is located in the package com.nu.controllers.
 * 
 * The NotificationController class extends the HttpServlet class and is annotated with @WebServlet("/notifications") to map the servlet to the "/notifications" URL.
 * 
 * The class has a private instance variable notificationDAO of type NotificationDAO, which is used to interact with the database and perform CRUD operations on notifications.
 * 
 * The doGet() method is overridden from the HttpServlet class and is responsible for handling HTTP GET requests to the "/notifications" URL.
 * It retrieves the doctorId parameter from the request and parses it to an integer.
 * Then, it calls the getNotificationsByDoctorId() method of the notificationDAO to retrieve a list of notifications associated with the specified doctorId.
 * The retrieved notifications are set as an attribute in the request using request.setAttribute() method.
 * Finally, the request is forwarded to the "/notifications.jsp" page to display the notifications to the user.
 * 
 * If any SQLException occurs during the database operation, it is caught and the stack trace is printed.
 * 
 */package com.nu.controllers;

import com.nu.daos.NotificationDAO;
import com.nu.models.Notification;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/notifications")
public class NotificationController extends HttpServlet {
    private NotificationDAO notificationDAO = new NotificationDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int doctorId = Integer.parseInt(request.getParameter("doctorId"));
        try {
            List<Notification> notifications = notificationDAO.getNotificationsByDoctorId(doctorId);
            request.setAttribute("notifications", notifications);
            request.getRequestDispatcher("/notifications.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}