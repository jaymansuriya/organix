package com.springmvc.service;

import java.util.List;

import com.springmvc.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public void saveEmployee(Employee employee);
	
	public Employee getEmployeeById(Long id);
	
	public Employee updateEmployee(Employee employee);
	
	public void deleteEmployeeById(Long id);
}
