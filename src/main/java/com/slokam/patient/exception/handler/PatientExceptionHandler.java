package com.slokam.patient.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.slokam.patient.dto.ErrorDTO;
import com.slokam.patient.exception.PatientException;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class PatientExceptionHandler {

	@ExceptionHandler(PatientException.class)
	public ResponseEntity<ErrorDTO> handlePatientException(PatientException pe){
		log.error(pe.getMessage());
		log.error("Original Exception."+pe.getCause().getMessage());
		ErrorDTO errorDto = new ErrorDTO(1,"DB Related",pe.getMessage(),pe.getCause());
		return new ResponseEntity<ErrorDTO>(errorDto,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
