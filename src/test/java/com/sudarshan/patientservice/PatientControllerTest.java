//package com.sudarshan.patientservice;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import java.util.Optional;
//
//import com.sudarshan.patientservice.controller.PatientController;
//import com.sudarshan.patientservice.model.Patient;
//import com.sudarshan.patientservice.service.PatientService;
//
//@WebMvcTest(PatientController.class)
//public class PatientControllerTest {
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Mock
//	private PatientService patientService;
//
//	@InjectMocks
//	private PatientController patientController;
//
//	@BeforeEach
//	public void setup() {
//		mockMvc = MockMvcBuilders.standaloneSetup(patientController).build();
//	}
//
//	@Test
//	public void testGetPatientById() throws Exception {
//		// Arrange
//		Long patientId = 1L;
//		Patient mockPatient = new Patient();
//		mockPatient.setId(patientId);
//		mockPatient.setName("abc");
//		mockPatient.setAge(30);
//
//		// Mock the behavior of the service
//		Mockito.when(patientService.getPatientById(patientId)).thenReturn(Optional.of(mockPatient));
//
//		// Act and Assert
//		mockMvc.perform(MockMvcRequestBuilders
//						.get("/patients/{id}", patientId)
//						.accept(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().isOk())
//				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("abc"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.age").value(30));
//	}
//}
