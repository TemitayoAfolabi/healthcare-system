package com.nu.daos;

import com.nu.models.TelemedicineSession;
import com.nu.models.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TelemedicineSessionDAO {

    public void createSession(TelemedicineSession session) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "INSERT INTO telemedicine_sessions (patient_id, doctor_id, start_time, end_time) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, session.getPatientId());
        stmt.setInt(2, session.getDoctorId());
        stmt.setTimestamp(3, new java.sql.Timestamp(session.getStartTime().getTime()));
        stmt.setTimestamp(4, new java.sql.Timestamp(session.getEndTime().getTime()));
        stmt.executeUpdate();
    }

    public List<TelemedicineSession> getSessionsByPatientId(int patientId) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM telemedicine_sessions WHERE patient_id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, patientId);
        ResultSet rs = stmt.executeQuery();

        List<TelemedicineSession> sessions = new ArrayList<>();
        while (rs.next()) {
            TelemedicineSession session = new TelemedicineSession();
            session.setSessionId(rs.getInt("session_id"));
            session.setPatientId(rs.getInt("patient_id"));
            session.setDoctorId(rs.getInt("doctor_id"));
            session.setStartTime(rs.getTimestamp("start_time"));
            session.setEndTime(rs.getTimestamp("end_time"));
            sessions.add(session);
        }

        return sessions;
    }
}

