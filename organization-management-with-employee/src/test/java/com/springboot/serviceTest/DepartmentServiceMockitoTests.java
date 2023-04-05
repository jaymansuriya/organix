package com.springboot.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.dto.DepartmentDto;
import com.springboot.entity.DepartmentBO;
import com.springboot.repository.DepartmentRepository;
import com.springboot.serviceImpl.DepartmentServiceImpl;

@SpringBootTest(classes = {DepartmentServiceMockitoTests.class})
public class DepartmentServiceMockitoTests {
	
	@Mock
	DepartmentRepository departmentRepository;
	
	@InjectMocks
	DepartmentServiceImpl departmentService;
	
	public List<DepartmentDto> myDepartments;
	
	@Test 
	@Order(1)
	public void test_getAllDepartment() {
		
		List<DepartmentBO> myDepartments = new ArrayList<DepartmentBO>();
		myDepartments.add(new DepartmentBO((long) 1,"HR"));
		myDepartments.add(new DepartmentBO((long) 2,"Finance"));
		
		when(departmentRepository.findAll()).thenReturn(myDepartments);//Mocking
		assertEquals(2, departmentService.getAllDepartment().size());
	}
	
	
//	@Test 
//	@Order(1)
//	public void test_getDepartmentById() {
//		
//		List<DepartmentDto> myDepartments = new ArrayList<DepartmentDto>();
//		myDepartments.add(new DepartmentDto((long) 1,"HR"));
//		myDepartments.add(new DepartmentDto((long) 2,"Finance"));
//		
//		Long deptId = 1L;
//		
//		when(departmentRepository.findById(deptId)).thenReturn(myDepartments);//Mocking
//		assertEquals(2, departmentService.getAllDepartment().size());
//	}
	

}
