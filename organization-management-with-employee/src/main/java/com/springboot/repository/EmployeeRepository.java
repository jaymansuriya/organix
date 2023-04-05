package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.entity.DepartmentBO;
import com.springboot.entity.EmployeeBO;
import com.springboot.entity.OrganizationBO;


public interface EmployeeRepository extends JpaRepository<EmployeeBO, Long> {

	List<EmployeeBO> findByoID(OrganizationBO organizationBO);
	
	List<EmployeeBO> findBydID(DepartmentBO dID);
	
	@Query(value = "SELECT * FROM organization.employee  WHERE o_id = ?1 " +  "AND d_id = ?2 ", nativeQuery = true)
	List<EmployeeBO> findByoIDAnddID(Long oID, Long dID);
	
}
