package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.OrganizationBO;


public interface OrganizationRepository extends JpaRepository<OrganizationBO, Long>{

	public Boolean existsByName(String name);		
	OrganizationBO findByName(String name);
}
