package com.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "organization")
public class OrganizationBO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "o_id")
	private Long oID;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "contact_no", nullable = false)
	private String contactNo;
	
	@Column(name = "owner_name", nullable = false)
	private String ownerName;

	public Long getoID() {
		return oID;
	}

	public void setoID(Long oID) {
		this.oID = oID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public OrganizationBO(Long oID, String name, String address, String contactNo, String ownerName) {
		super();
		this.oID = oID;
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
		this.ownerName = ownerName;
	}

	public OrganizationBO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	
	
	
	
	
	
}
