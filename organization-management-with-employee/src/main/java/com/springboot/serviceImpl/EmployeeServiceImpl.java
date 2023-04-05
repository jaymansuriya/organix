package com.springboot.serviceImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springboot.dto.EmployeeDto;
import com.springboot.entity.DepartmentBO;
import com.springboot.entity.EmployeeBO;
import com.springboot.entity.OrganizationBO;
import com.springboot.exception.EmployeeNotFound;
import com.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private OrganizationServiceImpl organizationService;

	@Autowired
	private DepartmentServiceImpl departmentService;

	@Autowired
	private ModelMapper modelMapper;

	public List<EmployeeBO> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		
		System.out.println(employeeDto);

		EmployeeBO employeeBO = modelMapper.map(employeeDto, EmployeeBO.class);
		
		System.out.println(employeeBO);

		employeeBO.setFirstName(employeeDto.getFirstName());
		employeeBO.setLastName(employeeDto.getLastName());
		employeeBO.setContactNo(employeeDto.getContactNo());
		employeeBO.setdID(employeeDto.getdID());
		employeeBO.setDesignation(employeeDto.getDesignation());
		employeeBO.setoID(employeeDto.getoID());

		employeeRepository.save(employeeBO);

		return modelMapper.map(employeeBO, EmployeeDto.class);
	}

	public EmployeeDto editEmployee(EmployeeDto employeeDto) throws Exception {
		EmployeeBO employeeBO = employeeRepository.findById(employeeDto.geteID())
				.orElseThrow(() -> new Exception("Employee not found with this id::" + employeeDto.geteID()));
		employeeBO.setFirstName(employeeDto.getFirstName());
		employeeBO.setLastName(employeeDto.getLastName());
		employeeBO.setContactNo(employeeDto.getContactNo());
		employeeBO.setdID(employeeDto.getdID());
		employeeBO.setDesignation(employeeDto.getDesignation());
		employeeBO.setoID(employeeDto.getoID());

		employeeRepository.save(employeeBO);
		return modelMapper.map(employeeBO, EmployeeDto.class);
	}

	public EmployeeDto getEmployeeById(String id) throws Exception {
		return modelMapper.map(employeeRepository.findById(Long.parseLong(id))
				.orElseThrow(() -> new Exception("Employee not found with this id::" + id)), EmployeeDto.class);
	}

	public ResponseEntity<?> deleteEmployee(String id) {
		try {
			employeeRepository.deleteById(Long.parseLong(id));
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

	public List<EmployeeBO> getEmployeeByOrganizationName(String name) {

		OrganizationBO organizationBO = organizationService.getIDByName(name);

		return (List<EmployeeBO>) employeeRepository.findByoID(organizationBO);
	}

	public List<EmployeeBO> getEmployeeByDepartmentName(String name) {

		DepartmentBO departmentBO = departmentService.getIDByDepartmentName(name);

		return (List<EmployeeBO>) employeeRepository.findBydID(departmentBO);
	}

	public List<EmployeeBO> getEmployeeByOrganizationNameAndDepartmentName(String oName, String dName) {

		OrganizationBO organizationBO = organizationService.getIDByName(oName);

		DepartmentBO departmentBO = departmentService.getIDByDepartmentName(dName);
		List<EmployeeBO> list;

		if (organizationBO != null && departmentBO != null) {
			list = employeeRepository.findByoIDAnddID(organizationBO.getoID(), departmentBO.getdID());
		} else {
			throw new EmployeeNotFound("Employee not found with organization " + oName + " and department "+ dName);
		}
		
		return list;

	}

}
