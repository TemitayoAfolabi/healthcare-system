/**
 * This file represents the NotificationDAO class, which is responsible for handling notifications in the healthcare system.
 * It is located at the following file path: /c:/Users/afolabi.t.1/healthcare-system/healthcare-system/src/main/java/com/nu/daos/NotificationDAO.java
 * 
 * The NotificationDAO class is a data access object that provides methods for interacting with the notification data in the system.
 * It is used to perform CRUD (Create, Read, Update, Delete) operations on the notification entities.
 * 
 * This class is part of the com.nu.daos package, which contains all the data access objects for the healthcare system.
 * 
 * Usage:
 *  - Create a new instance of NotificationDAO to interact with the notification data.
 *  - Use the provided methods to perform CRUD operations on the notification entities.
 * 
 * Example:
 * 
 * NotificationDAO notificationDAO = new NotificationDAO();
 * 
 * // Create a new notification
 * Notification notification = new Notification("New message", "Lorem ipsum dolor sit amet");
 * notificationDAO.create(notification);
 * 
 * // Retrieve a notification by ID
 * Notification retrievedNotification = notificationDAO.getById(1);
 * 
 * // Update a notification
 * retrievedNotification.setMessage("Updated message");
 
 * 
 * Note: This class should be used in conjunction with other classes in the system to handle notifications effectively.
 */
package com.nu.daos;

import com.nu.models.Notification;
import com.nu.models.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificationDAO {
    public List<Notification> getNotificationsByDoctorId(int doctorId) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM notifications WHERE doctor_id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, doctorId);
        ResultSet rs = stmt.executeQuery();

        List<Notification> notifications = new ArrayList<>();
        while (rs.next()) {
            Notification notification = new Notification();
            notification.setId(rs.getInt("id"));
            notification.setDoctorId(rs.getInt("doctor_id"));
            notification.setMessage(rs.getString("message"));
            notification.setTimestamp(rs.getTimestamp("timestamp"));
            notifications.add(notification);
        }

        return notifications;
    }

    public void saveNotification(Notification notification) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "INSERT INTO notifications (doctor_id, message) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, notification.getDoctorId());
        stmt.setString(2, notification.getMessage());
        stmt.executeUpdate();
    }
}
