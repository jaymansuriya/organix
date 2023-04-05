package com.springboot.dto;

public class DepartmentDto {

	private Long dID;
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

	public DepartmentDto(Long dID, String departmentName) {
		super();
		this.dID = dID;
		this.departmentName = departmentName;
	}

	public DepartmentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
