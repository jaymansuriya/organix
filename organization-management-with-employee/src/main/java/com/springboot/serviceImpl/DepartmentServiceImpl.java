package com.springboot.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.dto.DepartmentDto;
import com.springboot.entity.DepartmentBO;
import com.springboot.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ModelMapper modelMapper;

	public List<DepartmentBO> getAllDepartment() {
		return departmentRepository.findAll();
	}

	public DepartmentDto createDepartment(DepartmentDto departmentDto) {

		DepartmentBO departmentBO = modelMapper.map(departmentDto, DepartmentBO.class);

		departmentBO.setDepartmentName(departmentDto.getDepartmentName());

		if (departmentRepository.existsByDepartmentName(departmentDto.getDepartmentName())) {
			throw new RuntimeException("Department is already exists");
		}

		departmentRepository.save(departmentBO);

		return modelMapper.map(departmentBO, DepartmentDto.class);
	}

	public DepartmentDto editDepartment(DepartmentDto departmentDto) throws Exception {
		
		if (departmentRepository.existsByDepartmentName(departmentDto.getDepartmentName())) {
			throw new RuntimeException("Department is already exists");
		}
		
		DepartmentBO departmentBO = departmentRepository.findById(departmentDto.getdID())
				.orElseThrow(() -> new Exception("Department not found with this id::" + departmentDto.getdID()));
		departmentBO.setDepartmentName(departmentDto.getDepartmentName());
		departmentRepository.save(departmentBO);
		return modelMapper.map(departmentBO, DepartmentDto.class);
	}

	public DepartmentDto getDepartmentById(String id) throws Exception {
		return modelMapper.map(departmentRepository.findById(Long.parseLong(id))
				.orElseThrow(() -> new Exception("Department not found with this id::" + id)), DepartmentDto.class);

	}

	public ResponseEntity<?> deleteDepartment(String id) {
		try {
			departmentRepository.deleteById(Long.parseLong(id));
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}
	
	public DepartmentBO getIDByDepartmentName(String name) {

		DepartmentBO departmentBO = departmentRepository.findByDepartmentName(name);
		return departmentBO;

	}

}
