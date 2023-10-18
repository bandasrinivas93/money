package com.slokam.patient.service;

import java.util.List;

import com.slokam.patient.dto.PatientDTO;
import com.slokam.patient.exception.PatientException;

public interface IPatientService {

	public void savePatient(PatientDTO patient )throws PatientException;
	
	public PatientDTO getPatientById(Integer id) throws PatientException;
	
	public List<PatientDTO> getPatieList()  throws PatientException;
}
