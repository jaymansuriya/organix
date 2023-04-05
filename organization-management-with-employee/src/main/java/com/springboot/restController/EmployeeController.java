package com.springboot.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.EmployeeDto;
import com.springboot.entity.EmployeeBO;
import com.springboot.serviceImpl.EmployeeServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeServiceImpl employeeService;

	@GetMapping("/api/employees")
	public List<EmployeeBO> getEmployees() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/api/employees/{employeeId}")
	public EmployeeDto getEmployee(@PathVariable("employeeId") String id) throws Exception {
		return employeeService.getEmployeeById(id);

	}

	@PostMapping("/api/add-employee")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);

	}

	@PutMapping("/api/update-employee")
	public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto) throws Exception {
		return employeeService.editEmployee(employeeDto);
	}

	@DeleteMapping("/api/delete-employee/{employeeId}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("employeeId") String id) throws Exception {

		try {
			return employeeService.deleteEmployee(id);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/api/employees/organization/{organizationName}")
	public List<EmployeeBO> getEmployeesByOrganizationName(@PathVariable("organizationName") String organizationName) {
		return employeeService.getEmployeeByOrganizationName(organizationName);
	}
	
	@GetMapping("/api/employees/department/{departmentName}")
	public List<EmployeeBO> getEmployeesByDepartmentName(@PathVariable("departmentName") String departmentName) {
		return employeeService.getEmployeeByDepartmentName(departmentName);
	}
	
	@GetMapping("/api/employees/organization/{organizationName}/department/{departmentName}")
	public List<EmployeeBO> getEmployeeByOrganizationNameAndDepartmentName(@PathVariable("organizationName") String organizationName, @PathVariable("departmentName") String departmentName) {
		return employeeService.getEmployeeByOrganizationNameAndDepartmentName(organizationName,departmentName);
	}

}
