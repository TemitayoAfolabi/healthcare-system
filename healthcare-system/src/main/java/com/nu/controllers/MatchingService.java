package com.nu.controllers;


import com.nu.daos.DoctorDAO;
import com.nu.models.Doctor;

import java.sql.SQLException;
import java.util.List;

public class MatchingService {

    private DoctorDAO doctorDAO = new DoctorDAO();

    public Doctor matchPatientToDoctor(String condition) throws SQLException {
        // Here, we're simply matching based on doctor's specialty
        List<Doctor> availableDoctors = doctorDAO.getAvailableDoctorsBySpecialty(condition);
        if (!availableDoctors.isEmpty()) {
            // Return the first available doctor for simplicity
            return availableDoctors.get(0);
        }
        return null;
    }
}