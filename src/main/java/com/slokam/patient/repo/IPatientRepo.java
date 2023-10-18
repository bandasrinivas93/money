package com.slokam.patient.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.patient.entity.Patient;

@Repository
public interface IPatientRepo extends JpaRepository<Patient, Integer> {

	
}
