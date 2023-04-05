package com.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class DepartmentBO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "d_id")
	private Long dID;
	
	@Column(name = "department_name", nullable = false)
	private String departmentName;

	public Long getdID() {
		return dID;
	}

	public void setdID(Long dID) {
		this.dID = dID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public DepartmentBO(Long dID, String departmentName) {
		super();
		this.dID = dID;
		this.departmentName = departmentName;
	}

	public DepartmentBO() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	
	
	

}
