package com.example.patient_cw4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Patient {

    @Id
    private int patientId;

    private String patientName,doctorName,disease,medication;
    public Patient() {
    }
    public Patient(int patientId, String patentName, String doctorName, String disease, String medication) {
        this.patientId = patientId;
        this.patientName = patentName;
        this.doctorName = doctorName;
        this.disease = disease;
        this.medication = medication;
    }
    public int getPatientId() {
        return patientId;
    }
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    public String getPatientName() {
        return patientName;
    }
    public void setPatientName(String patentName) {
        this.patientName = patentName;
    }
    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    public String getDisease() {
        return disease;
    }
    public void setDisease(String disease) {
        this.disease = disease;
    }
    public String getMedication() {
        return medication;
    }
    public void setMedication(String medication) {
        this.medication = medication;
    }

    

}