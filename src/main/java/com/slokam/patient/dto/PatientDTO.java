package com.slokam.patient.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PatientDTO {

	private Integer id;
	@NotBlank
	private String name;
	@NotNull
	private Long phone;
	@NotBlank
	private String address;
	
}
