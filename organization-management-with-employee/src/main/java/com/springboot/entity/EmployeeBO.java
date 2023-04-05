package com.springboot.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeBO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "e_id")
	private Long eID;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@ManyToOne
	@Nonnull
	@JoinColumn(name = "o_id")
	private OrganizationBO oID;
	
	@ManyToOne
	@Nonnull
	@JoinColumn(name = "d_id")
	private DepartmentBO dID;
	
	@Column(name = "contact_no", nullable = false)
	private String contactNo;
	
	@Column(name = "designation", nullable = false)
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

	public EmployeeBO(Long eID, String firstName, String lastName, OrganizationBO oID, DepartmentBO dID,
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

	public EmployeeBO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "EmployeeBO [eID=" + eID + ", firstName=" + firstName + ", lastName=" + lastName + ", oID=" + oID
				+ ", dID=" + dID + ", contactNo=" + contactNo + ", designation=" + designation + "]";
	}
	
	

	
}
