package com.nu.controllers;

import com.nu.daos.PatientDAO;
import com.nu.models.Patient;

import com.nu.models.Alert;
import com.nu.daos.AlertDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/patient")
public class PatientController extends HttpServlet {
    private PatientDAO patientDAO = new PatientDAO();
    private AlertDAO alertDAO = new AlertDAO();

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
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Patient patient = new Patient();
        patient.setName(name);
        patient.setAge(age);
        patient.setEmail(email);
        patient.setPassword(password);

        try {
            if (patientDAO.registerPatient(patient)) {
                response.sendRedirect("login.jsp");
            } else {
                response.sendRedirect("signup.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Patient patient = patientDAO.loginPatient(email, password);
            if (patient != null) {
                request.getSession().setAttribute("patient", patient);

                List<Alert> alerts = alertDAO.getAlertsByPatientId(patient.getId());
                request.getSession().setAttribute("alerts", alerts);

                response.sendRedirect("dashboard.jsp");
            } else {
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}