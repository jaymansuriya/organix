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

import com.springboot.dto.DepartmentDto;
import com.springboot.entity.DepartmentBO;
import com.springboot.serviceImpl.DepartmentServiceImpl;

@RestController
public class DepartmentController {

	@Autowired
	DepartmentServiceImpl departmentService;

	@GetMapping("/api/departments")
	public List<DepartmentBO> getDepartments() {
		return departmentService.getAllDepartment();
	}

	@GetMapping("/api/departments/{departmentId}")
	public DepartmentDto getDepartment(@PathVariable("departmentId") String id) throws Exception {
		return departmentService.getDepartmentById(id);

	}

	@PostMapping("/api/add-department")
	public ResponseEntity<DepartmentDto> createDpartment( @RequestBody DepartmentDto departmentDto) {
		return new ResponseEntity<>(departmentService.createDepartment(departmentDto), HttpStatus.CREATED);

	}

	@PutMapping("/api/update-department")
	public DepartmentDto updateDepartment(@RequestBody DepartmentDto departmentDto) throws Exception {
		return departmentService.editDepartment(departmentDto);
	}

	@DeleteMapping("/api/delete-department/{departmentId}")
	public ResponseEntity<?> deleteDepertment(@PathVariable("departmentId") String id) throws Exception {
		
		try {
			return departmentService.deleteDepartment(id);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		
		
	}

}
