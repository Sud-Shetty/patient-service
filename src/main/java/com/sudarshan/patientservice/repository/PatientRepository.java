package com.sudarshan.patientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sudarshan.patientservice.model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Long> {

}
