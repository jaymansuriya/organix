package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.DepartmentBO;


public interface DepartmentRepository extends JpaRepository<DepartmentBO, Long> {
	
	public Boolean existsByDepartmentName(String departmentName);
	DepartmentBO findByDepartmentName(String name);

}
