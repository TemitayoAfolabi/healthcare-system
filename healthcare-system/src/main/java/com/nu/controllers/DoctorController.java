package com.nu.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nu.daos.DoctorDAO;
import com.nu.models.Doctor;
import com.nu.models.Patient;
import com.nu.models.Notification;
import com.nu.daos.NotificationDAO;
import com.nu.daos.PatientDAO;

@WebServlet("/doctor")
public class DoctorController extends HttpServlet {
    private DoctorDAO doctorDAO = new DoctorDAO();
    private PatientDAO patientDAO = new PatientDAO();
    private NotificationDAO notificationDAO = new NotificationDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("signup".equals(action)) {
            signup(request, response);
        } else if ("login".equals(action)) {
            login(request, response);
        }
    }

    private void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String specialty = request.getParameter("specialty");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setSpecialty(specialty);
        doctor.setEmail(email);
        doctor.setPassword(password);
        doctor.setAvailability(true);

        try {
            if (doctorDAO.registerDoctor(doctor)) {
                response.sendRedirect("doctorLogin.jsp");
            } else {
                response.sendRedirect("doctorSignup.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Doctor doctor = doctorDAO.loginDoctor(email, password);
            if (doctor != null) {
                request.getSession().setAttribute("doctor", doctor);

                // Fetch matched patients
                List<Patient> matchedPatients = patientDAO.getPatientsBySpecialty(doctor.getSpecialty());
                request.getSession().setAttribute("matchedPatients", matchedPatients);

                // Fetch notifications
                List<Notification> notifications = notificationDAO.getNotificationsByDoctorId(doctor.getId());
                request.getSession().setAttribute("notifications", notifications);

                response.sendRedirect("doctorDashboard.jsp");
            } else {
                response.sendRedirect("doctorLogin.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}