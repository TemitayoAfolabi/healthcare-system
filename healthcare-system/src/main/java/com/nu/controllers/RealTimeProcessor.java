
/**
 * The RealTimeProcessor class is responsible for processing real-time heart data and generating alerts if necessary.
 * It contains a method, processHeartData, which takes in a patient ID and heart rate as parameters and checks if the heart rate exceeds a threshold.
 * If the heart rate exceeds the threshold, an alert is created and saved using the AlertDAO class.
 * 
 * Example Usage:
 * RealTimeProcessor realTimeProcessor = new RealTimeProcessor();
 * realTimeProcessor.processHeartData(123, 110.5);
 * 
 * This will check the heart rate of the patient with ID 123 and if it exceeds the threshold of 100.0, an alert will be created and saved.
 * The alert message will indicate that irregular heart activity has been detected and the patient should contact a doctor.
 * 
 * Note: This class assumes that the PatientDAO and AlertDAO classes are properly implemented and accessible.
 */
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
