package com.springmvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
