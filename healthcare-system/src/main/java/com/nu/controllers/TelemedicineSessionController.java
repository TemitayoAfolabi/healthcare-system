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
