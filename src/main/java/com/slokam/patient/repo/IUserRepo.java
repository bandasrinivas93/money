package com.slokam.patient.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.slokam.patient.entity.AppUser;

@Repository
public interface IUserRepo extends JpaRepository<AppUser , Integer> {

	public AppUser findByUserName(String name);
}
