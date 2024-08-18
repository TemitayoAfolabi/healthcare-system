/**
 * This file represents the TelemedicineSessionController class, which is responsible for handling telemedicine session related operations.
 * It is located in the com.nu.controllers package.
 * 
 * The TelemedicineSessionController class is a part of the healthcare-system project and is used to manage telemedicine sessions.
 * 
 * This class contains methods and functionalities related to telemedicine session management, such as creating a new session, updating session details, and retrieving session information.
 * 
 * The TelemedicineSessionController class is designed to handle the business logic and communication between the front-end and the back-end for telemedicine session operations.
 * 
 * It is used in conjunction with other classes and components to provide a comprehensive telemedicine session management system.
 */
package com.nu.controllers;


import com.nu.daos.TelemedicineSessionDAO;
import com.nu.models.TelemedicineSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

@WebServlet("/telemedicine")
public class TelemedicineSessionController extends HttpServlet {
    private TelemedicineSessionDAO sessionDAO = new TelemedicineSessionDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            createSession(request, response);
        }
    }

    private void createSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int patientId = Integer.parseInt(request.getParameter("patientId"));
        int doctorId = Integer.parseInt(request.getParameter("doctorId"));
        Date startTime = new Date(); // Current time for simplicity
        Date endTime = new Date(startTime.getTime() + 30 * 60 * 1000); // 30 minutes session

        TelemedicineSession session = new TelemedicineSession();
        session.setPatientId(patientId);
        session.setDoctorId(doctorId);
        session.setStartTime(startTime);
        session.setEndTime(endTime);

        try {
            sessionDAO.createSession(session);
            response.sendRedirect("dashboard.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
