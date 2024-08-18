/**
 * This file represents the DoctorDAO class, which is responsible for handling data access operations related to doctors in the healthcare system.
 * It is located in the com.nu.daos package.
 * 
 * The DoctorDAO class provides methods for retrieving, creating, updating, and deleting doctor records in the database.
 * It interacts with the underlying database to perform these operations.
 * 
 * Usage:
 * 1. Instantiate the DoctorDAO class to access its methods.
 * 2. Use the provided methods to perform CRUD operations on doctor records.
 * 
 * Example:
 * DoctorDAO doctorDAO = new DoctorDAO();
 * Doctor doctor = new Doctor("John Doe", "Cardiology");
 * doctorDAO.create(doctor);
 * 
 * Note: This class assumes the existence of a database connection and appropriate table schema for storing doctor records.
 */
package com.nu.daos;

import com.nu.models.Doctor;
import com.nu.models.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    public List<Doctor> getAvailableDoctorsBySpecialty(String specialty) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM doctors WHERE specialty = ? AND availability = true";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, specialty);
        ResultSet rs = stmt.executeQuery();

        List<Doctor> doctors = new ArrayList<>();
        while (rs.next()) {
            Doctor doctor = new Doctor();
            doctor.setId(rs.getInt("id"));
            doctor.setName(rs.getString("name"));
            doctor.setSpecialty(rs.getString("specialty"));
            doctor.setAvailability(rs.getBoolean("availability"));
            doctors.add(doctor);
        }

        return doctors;
    }

    public Doctor getDoctorById(int id) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM doctors WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Doctor doctor = new Doctor();
            doctor.setId(rs.getInt("id"));
            doctor.setName(rs.getString("name"));
            doctor.setSpecialty(rs.getString("specialty"));
            doctor.setEmail(rs.getString("email"));
            doctor.setPassword(rs.getString("password"));
            doctor.setAvailability(rs.getBoolean("availability"));
            return doctor;
        }

        return null;
    }

    public boolean registerDoctor(Doctor doctor) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "INSERT INTO doctors (name, specialty, email, password, availability) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, doctor.getName());
        stmt.setString(2, doctor.getSpecialty());
        stmt.setString(3, doctor.getEmail());
        stmt.setString(4, doctor.getPassword());
        stmt.setBoolean(5, doctor.isAvailability());

        return stmt.executeUpdate() > 0;
    }

    public Doctor loginDoctor(String email, String password) throws SQLException {
        Connection conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM doctors WHERE email = ? AND password = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, email);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Doctor doctor = new Doctor();
            doctor.setId(rs.getInt("id"));
            doctor.setName(rs.getString("name"));
            doctor.setSpecialty(rs.getString("specialty"));
            doctor.setEmail(rs.getString("email"));
            doctor.setPassword(rs.getString("password"));
            doctor.setAvailability(rs.getBoolean("availability"));
            return doctor;
        }

        return null;
    }
}