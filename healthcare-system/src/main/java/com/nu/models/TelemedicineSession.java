package com.nu.models;

import java.util.Date;

public class TelemedicineSession {

    private int sessionId;
    private int patientId;
    private int doctorId;
    private Date startTime;
    private Date endTime;
    
    public TelemedicineSession(int sessionId, int patientId, int doctorId, Date startTime, Date endTime) {
        this.sessionId = sessionId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public TelemedicineSession() {
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "TelemedicineSession [sessionId=" + sessionId + ", patientId=" + patientId + ", doctorId=" + doctorId
                + ", startTime=" + startTime + ", endTime=" + endTime + "]";
    }

    
}
