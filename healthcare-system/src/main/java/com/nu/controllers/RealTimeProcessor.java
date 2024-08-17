// src/com/example/controller/RealTimeProcessor.java
package com.nu.controllers;

import com.nu.daos.AlertDAO;
import com.nu.daos.PatientDAO;
import com.nu.models.Alert;
import com.nu.models.Patient;

import java.sql.SQLException;

public class RealTimeProcessor {

    private PatientDAO patientDAO = new PatientDAO();
    private AlertDAO alertDAO = new AlertDAO();

    public void processHeartData(int patientId, double heartRate) throws SQLException {
        // Simple threshold-based alert
        double threshold = 100.0; // Example threshold
        if (heartRate > threshold) {
            Patient patient = patientDAO.getPatientById(patientId);
            if (patient != null) {
                Alert alert = new Alert();
                alert.setPatientId(patientId);
                alert.setMessage("Irregular heart activity detected. Please contact a doctor.");

                alertDAO.saveAlert(alert);

                // Optionally, send an email or SMS to the patient
            }
        }
    }
}
