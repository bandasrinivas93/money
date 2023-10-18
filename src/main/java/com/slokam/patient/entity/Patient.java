package com.slokam.patient.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Patient {

	@Id
	@GeneratedValue
	private Integer id;
	@NotBlank
	private String name;
	@NotNull
	private Long phone;
	@NotBlank
	private String address;
	
	
}
