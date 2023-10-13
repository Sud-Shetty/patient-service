package com.sudarshan.patientservice.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sudarshan.patientservice.dto.PatientRequest;
import com.sudarshan.patientservice.model.Patient;
import com.sudarshan.patientservice.service.PatientService;

@RestController
@RequestMapping("/api/v1/patient")
@RequiredArgsConstructor
public class PatientController {
  private final PatientService patientService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void addPatient(@RequestBody PatientRequest patientRequest){
    patientService.addPatient(patientRequest);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Patient> getAllPatients(){
    return patientService.getAllPatients();
  }

  @GetMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public Patient getPatientByID(@PathVariable Long id){
    return patientService.getPatientById(id);
  }

  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public Patient updatePatient(@PathVariable Long id, @RequestBody PatientRequest patientRequest){
    return patientService.updatePatient(id, patientRequest);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public void deletePatientByID(@PathVariable Long id){
    patientService.deletePatientById(id);
  }
}
