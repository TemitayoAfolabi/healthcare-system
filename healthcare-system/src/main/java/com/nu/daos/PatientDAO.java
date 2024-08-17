package com.nu.daos;

import com.nu.models.Patient;
import com.nu.models.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
    
    public Patient getPatientById(int id) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM patients WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Patient patient = new Patient();
            patient.setId(rs.getInt("id"));
            patient.setName(rs.getString("name"));
            patient.setAge(rs.getInt("age"));
            patient.setEmail(rs.getString("email"));
            patient.setPassword(rs.getString("password"));
            patient.setHeartRate(rs.getDouble("heart_rate"));
            patient.setEcgData(rs.getString("ecg_data"));
            return patient;
        }

        return null;
    }

    public boolean registerPatient(Patient patient) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "INSERT INTO patients (name, age, email, password) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, patient.getName());
        stmt.setInt(2, patient.getAge());
        stmt.setString(3, patient.getEmail());
        stmt.setString(4, patient.getPassword());

        return stmt.executeUpdate() > 0;
    }

    public Patient loginPatient(String email, String password) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM patients WHERE email = ? AND password = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, email);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Patient patient = new Patient();
            patient.setId(rs.getInt("id"));
            patient.setName(rs.getString("name"));
            patient.setAge(rs.getInt("age"));
            patient.setEmail(rs.getString("email"));
            patient.setPassword(rs.getString("password"));
            patient.setHeartRate(rs.getDouble("heart_rate"));
            patient.setEcgData(rs.getString("ecg_data"));
            return patient;
        }

        return null;
    }

     public List<Patient> getPatientsBySpecialty(String specialty) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM patients WHERE condition = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, specialty);
        ResultSet rs = stmt.executeQuery();

        List<Patient> patients = new ArrayList<>();
        while (rs.next()) {
            Patient patient = new Patient();
            patient.setId(rs.getInt("id"));
            patient.setName(rs.getString("name"));
            patient.setAge(rs.getInt("age"));
            patient.setEmail(rs.getString("email"));
            patient.setPassword(rs.getString("password"));
            patient.setHeartRate(rs.getDouble("heart_rate"));
            patient.setEcgData(rs.getString("ecg_data"));
            patients.add(patient);
        }

        return patients;
    }
}
