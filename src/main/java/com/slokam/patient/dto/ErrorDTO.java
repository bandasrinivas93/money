package com.slokam.patient.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {

	private Integer AppStatusCode;
	private String  AppStusDescription;
	private String  message;
	@JsonIgnore
	private Throwable cause; 
	
}
