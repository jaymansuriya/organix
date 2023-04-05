package com.springboot.dto;

import com.springboot.entity.DepartmentBO;
import com.springboot.entity.OrganizationBO;


public class EmployeeDto {

	private Long eID;

	private String firstName;

	private String lastName;

	private OrganizationBO oID;

	private DepartmentBO dID;

	private String contactNo;

	private String designation;

	public Long geteID() {
		return eID;
	}

	public void seteID(Long eID) {
		this.eID = eID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public OrganizationBO getoID() {
		return oID;
	}

	public void setoID(OrganizationBO oID) {
		this.oID = oID;
	}

	public DepartmentBO getdID() {
		return dID;
	}

	public void setdID(DepartmentBO dID) {
		this.dID = dID;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public EmployeeDto(Long eID, String firstName, String lastName, OrganizationBO oID, DepartmentBO dID,
			String contactNo, String designation) {
		super();
		this.eID = eID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.oID = oID;
		this.dID = dID;
		this.contactNo = contactNo;
		this.designation = designation;
	}

	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmployeeDto [eID=" + eID + ", firstName=" + firstName + ", lastName=" + lastName + ", oID=" + oID
				+ ", dID=" + dID + ", contactNo=" + contactNo + ", designation=" + designation + "]";
	}
	
	
	

}
