package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.dto.EmployeeDto;
import com.springboot.entity.EmployeeBO;
import com.springboot.serviceImpl.DepartmentServiceImpl;
import com.springboot.serviceImpl.EmployeeServiceImpl;
import com.springboot.serviceImpl.OrganizationServiceImpl;

@Controller
public class EmpController {
	

	@Autowired
	EmployeeServiceImpl employeeService;
	
	@Autowired
	OrganizationServiceImpl organizationService;
	
	@Autowired
	DepartmentServiceImpl departmentService;

	@GetMapping("/employee-list")
	public String allEmployee(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployee());
		return "employee-list";
	}

	@GetMapping("/employee/new")
	public String createEmployeeForm(Model model) {

		EmployeeBO employeeBO = new EmployeeBO();
		
		model.addAttribute("employee", employeeBO);
		model.addAttribute("listOrg", organizationService.getAllOrganization());
		model.addAttribute("listDept", departmentService.getAllDepartment());
		return "create-employee";

	}

	@PostMapping("/employee")
	public String saveEmployee(@ModelAttribute("employee") EmployeeDto employeeDto) {
		employeeService.createEmployee(employeeDto);
		return "redirect:/employee-list";
	}

	@GetMapping("/employee/edit/{id}")
	public String editEmployeeForm(@PathVariable String id, Model model) throws Exception {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		model.addAttribute("listOrg", organizationService.getAllOrganization());
		model.addAttribute("listDept", departmentService.getAllDepartment());
		return "edit-employee";
	}

	@PostMapping("/employee/{id}")
	public String updateEmployee(@PathVariable String id, @ModelAttribute("employee") EmployeeDto employeeDto,
			Model model) throws Exception {

		EmployeeDto existingEmployee = employeeService.getEmployeeById(id);

		existingEmployee.seteID(Long.parseLong(id));
		existingEmployee.setFirstName(employeeDto.getFirstName());
		existingEmployee.setLastName(employeeDto.getLastName());
		existingEmployee.setContactNo(employeeDto.getContactNo());
		existingEmployee.setDesignation(employeeDto.getDesignation());
		existingEmployee.setdID(employeeDto.getdID());
		existingEmployee.setoID(employeeDto.getoID());
		

		employeeService.editEmployee(existingEmployee);
		return "redirect:/employee-list";
	}

	@GetMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable String id) {
		employeeService.deleteEmployee(id);
		return "redirect:/employee-list";
	}
}
