package com.slokam.patient.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slokam.patient.dto.PatientDTO;
import com.slokam.patient.exception.PatientException;
import com.slokam.patient.service.IPatientService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("patient")
@Slf4j
public class PatientController {

	@Autowired
	private IPatientService patientService;

	@PostMapping
	public ResponseEntity<PatientDTO> savePatient(@RequestBody @Valid PatientDTO patientDto) throws PatientException {
		log.trace("Entered into savePatient");

		if (patientDto != null)
			log.debug(patientDto.toString());

		patientService.savePatient(patientDto);

		log.trace("Exit from savePatient");
		return ResponseEntity.ok(patientDto);
	}
   
	@GetMapping("/{id}")
	public ResponseEntity<PatientDTO> getPatientById(@PathVariable("id") Integer id) throws PatientException {
		
		log.trace("Entered into getPatientById");
		PatientDTO patientDto = patientService.getPatientById(id);
		log.trace("Exit from getPatientById");
		return ResponseEntity.ok(patientDto);
		
	}
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<PatientDTO>> getAllPatients() throws PatientException {
		
		log.trace("Entered into getAllPatients");
		List<PatientDTO> patientDtoList = patientService.getPatieList();
		log.trace("Exit from getAllPatients");
		return ResponseEntity.ok(patientDtoList);
		
	}
	
	
}
