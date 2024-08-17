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
