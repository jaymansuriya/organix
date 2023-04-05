package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.dto.DepartmentDto;
import com.springboot.entity.DepartmentBO;
import com.springboot.serviceImpl.DepartmentServiceImpl;

@Controller
public class DeptController {

	@Autowired
	DepartmentServiceImpl departmentService;

	@GetMapping("/")
	public String allDepartment(Model model) {

		model.addAttribute("departments", departmentService.getAllDepartment());
		return "department-list";
	}

	@GetMapping("/department/new")
	public String createDepartmentForm(Model model) {

		DepartmentBO departmentBO = new DepartmentBO();
		model.addAttribute("department", departmentBO);
		return "create-department";

	}

	@PostMapping("/department")
	public String saveDepartment(@ModelAttribute("department") DepartmentDto departmentDto) {
		departmentService.createDepartment(departmentDto);
		return "redirect:/";
	}

	@GetMapping("/department/edit/{id}")
	public String editDepartmentForm(@PathVariable String id, Model model) throws Exception {
		model.addAttribute("department", departmentService.getDepartmentById(id));
		return "edit-department";
	}

	@PostMapping("/department/{id}")
	public String updateDepartment(@PathVariable String id, @ModelAttribute("department") DepartmentDto departmentDto,
			Model model) throws Exception {

		DepartmentDto existingDepartment = departmentService.getDepartmentById(id);

		existingDepartment.setdID(Long.parseLong(id));
		existingDepartment.setDepartmentName(departmentDto.getDepartmentName());

		departmentService.editDepartment(existingDepartment);
		return "redirect:/";
	}

	@GetMapping("/department/{id}")
	public String deleteDepartment(@PathVariable String id) {
		departmentService.deleteDepartment(id);
		return "redirect:/";
	}

}
