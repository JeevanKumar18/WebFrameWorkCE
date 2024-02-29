package com.example.patient_cw4.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.patient_cw4.model.Patient;
import com.example.patient_cw4.repository.PatientRepo;




@Service
public class PatientService {
    
    private PatientRepo medicineRepo;

    public PatientService(PatientRepo medicineRepo) {
        this.medicineRepo = medicineRepo;
    }

    public Patient savaPatient(Patient medicine){

        return medicineRepo.save(medicine);
    }

    public List<Patient> getAllMedicine(){

        return medicineRepo.findAll();
    }

    public Patient getMedicineById(int id){
        return medicineRepo.findById(id).orElse(null);
    }
}
