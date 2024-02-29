package com.example.medical.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.medical.model.Medicine;



@Repository
public interface MedicineRepo extends JpaRepository<Medicine , Integer >{

    
}
