/**
 * This file represents the MatchingService class, which is responsible for handling matching operations in the healthcare system.
 * It is located in the com.nu.controllers package.
 * 
 * The MatchingService class is a part of the healthcare system's main Java source code directory.
 * It contains the logic for matching operations, such as matching patients with healthcare providers based on certain criteria.
 * 
 * The MatchingService class is an essential component of the healthcare system, as it ensures efficient and accurate matching of patients and providers.
 * It plays a crucial role in optimizing the healthcare system's operations and improving patient care.
 */
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