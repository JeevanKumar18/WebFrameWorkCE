package com.example.medical.controller;



import org.springframework.web.bind.annotation.RestController;

import com.example.medical.model.Medicine;
import com.example.medical.service.MedicineService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class MedicineController {

    private MedicineService medicineService;



    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping("/api/medicine")
    public ResponseEntity postMethodName(@RequestBody Medicine medicine) {

        if(medicineService.savaMedicine(medicine) == true){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }

    @GetMapping("/api/medicines")
    public List<Medicine> getAllDetail() {
        return medicineService.getAllMedicine();
    }


    @GetMapping("/api/medicine/{medicineId}")
    public Optional<Medicine> getDetailById(@PathVariable int medicineId) {
        return medicineService.getMedicineById(medicineId);
    }
    

}
