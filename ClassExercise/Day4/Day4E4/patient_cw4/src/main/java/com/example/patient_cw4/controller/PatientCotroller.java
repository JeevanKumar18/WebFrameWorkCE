package com.example.patient_cw4.controller;



import org.springframework.web.bind.annotation.RestController;

import com.example.patient_cw4.model.Patient;
import com.example.patient_cw4.service.PatientService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class PatientCotroller {

    private PatientService patientService;



    

    public PatientCotroller(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/api/patient")
    public ResponseEntity postMethodName(@RequestBody Patient patient) {

        Patient p = patientService.savaPatient(patient);
        return new ResponseEntity<>(p,HttpStatus.CREATED);
    }

    @GetMapping("/api/patient")
    public List<Patient> getAllDetail() {
        return patientService.getAllMedicine();
    }


    @GetMapping("/api/patient/{patientId}")
    public Patient getDetailById(@PathVariable int patientId) {
        return patientService.getMedicineById(patientId);
    }
    

}
