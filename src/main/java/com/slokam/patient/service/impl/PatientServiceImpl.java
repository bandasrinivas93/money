package com.slokam.patient.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.slokam.patient.dto.PatientDTO;
import com.slokam.patient.entity.Patient;
import com.slokam.patient.exception.PatientException;
import com.slokam.patient.repo.IPatientRepo;
import com.slokam.patient.service.IPatientService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PatientServiceImpl implements IPatientService {
	@Autowired
	private IPatientRepo patientRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public void savePatient(PatientDTO patientDto) throws PatientException {
		
		Patient patient = modelMapper.map(patientDto, Patient.class);
		
		log.trace("Entered into savePatient");
		
		if(patientDto!=null)
		  log.debug(patientDto.toString());
		
		/*
		 * Patient patient = new Patient(); patient.setId(patientDto.getId());
		 * patient.setName(patientDto.getName());
		 * patient.setPhone(patientDto.getPhone());
		 * patient.setAddress(patientDto.getAddress());
		 */
		try {
			 this.patientRepo.save(patient);
		}catch(DataAccessException exception ) {
			log.error("SQL Issue ..."+exception.getMessage());
			throw new PatientException("Exception due to db. ",exception) ;
		}
		  
		log.trace("Exit from savePatient");
	}
	
	@Override
	public List<PatientDTO> getPatieList() throws PatientException {
		log.trace("Entered into getPatieList");
		List<PatientDTO> listDto ;
		try {
			List<Patient> listEntity =  this.patientRepo.findAll();
			
			PatientDTO[] patientsDtoArr = modelMapper.map(listEntity, PatientDTO[].class) ;
			listDto = Arrays.asList(patientsDtoArr);
			
		}catch(DataAccessException exception ) {
			log.error("SQL Issue ..."+exception.getMessage());
			throw new PatientException("Exception due to db. ",exception) ;
		}
		
		log.trace("Exit from getPatieList");
		return listDto;
	}
	
	@Override
	public PatientDTO getPatientById(Integer id) throws PatientException {
		log.trace("Entered into getPatientById");
		PatientDTO patientDto = null;
		try {
			 Optional<Patient> patientEntityOpational = this.patientRepo.findById(id);
			 if(patientEntityOpational.isPresent()) {
				 log.debug("Data present for the id given.");
				 Patient patientEntity=  patientEntityOpational.get();
				 patientDto = modelMapper.map(patientEntity, PatientDTO.class);
			 }
		}catch(DataAccessException exception ) {
			log.error("SQL Issue ..."+exception.getMessage());
			throw new PatientException("Exception due to db. ",exception) ;
		}
		log.trace("Exit from getPatientById");
		return patientDto;
	}
	
}
