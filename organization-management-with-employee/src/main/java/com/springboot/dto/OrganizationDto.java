package com.springboot.dto;


public class OrganizationDto {

	private Long oID;

	private String name;

	private String address;

	private String contactNo;

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

	public OrganizationDto(Long oID, String name, String address, String contactNo, String ownerName) {
		super();
		this.oID = oID;
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
		this.ownerName = ownerName;
	}

	public OrganizationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
