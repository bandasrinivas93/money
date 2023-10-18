package com.slokam.patient.exception;

public class PatientException extends Exception{

	public PatientException() {
		
	}
	
	public PatientException(String message) {
		super(message);
	}
	
	public PatientException(String message, Throwable throwable) {
		 super(message,throwable);
	}
	
	
	
}
