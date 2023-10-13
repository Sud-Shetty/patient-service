package com.sudarshan.patientservice.service;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sudarshan.patientservice.dto.PatientRequest;
import com.sudarshan.patientservice.exception.ResourceNotFoundException;
import com.sudarshan.patientservice.model.Patient;
import com.sudarshan.patientservice.repository.PatientRepository;

@Service
@RequiredArgsConstructor
public class PatientService {
  private final PatientRepository patientRepository;

  public void addPatient(PatientRequest patientRequest){
    Patient patient = Patient.builder()
        .name(patientRequest.getName())
        .age(patientRequest.getAge())
        .build();
    patientRepository.save(patient);
  }

  public List<Patient> getAllPatients(){
    return patientRepository.findAll();
  }

  public Patient getPatientById(Long id) {
    return patientRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + id));
  }

  public Patient updatePatient(Long id, PatientRequest updatedPatient) {
    Patient existingPatient = getPatientById(id);

    existingPatient.setName(updatedPatient.getName());
    existingPatient.setAge(updatedPatient.getAge());

    return patientRepository.save(existingPatient);
  }

  public void deletePatientById(Long id) {
    Patient existingPatient = getPatientById(id);
    patientRepository.delete(existingPatient);
  }
}
