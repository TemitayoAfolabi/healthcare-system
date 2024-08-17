package com.nu.daos;

import com.nu.models.Alert;
import com.nu.models.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlertDAO {

    public void saveAlert(Alert alert) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "INSERT INTO alerts (patient_id, message) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, alert.getPatientId());
        stmt.setString(2, alert.getMessage());
        stmt.executeUpdate();
    }
    
    public List<Alert> getAlertsByPatientId(int patientId) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM alerts WHERE patient_id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, patientId);
        ResultSet rs = stmt.executeQuery();

        List<Alert> alerts = new ArrayList<>();
        while (rs.next()) {
            Alert alert = new Alert();
            alert.setId(rs.getInt("id"));
            alert.setPatientId(rs.getInt("patient_id"));
            alert.setMessage(rs.getString("message"));
            alert.setTimestamp(rs.getTimestamp("timestamp"));
            alerts.add(alert);
        }

        return alerts;
    }
}