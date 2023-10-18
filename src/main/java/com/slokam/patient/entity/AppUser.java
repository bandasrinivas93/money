package com.slokam.patient.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AppUser {

	@Id
	@GeneratedValue
	private Integer id;
	private String passord;
	private String userName;
	
	
}
