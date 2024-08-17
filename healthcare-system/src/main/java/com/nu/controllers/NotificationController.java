package com.nu.controllers;

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