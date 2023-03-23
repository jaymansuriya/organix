package com.college.model;

public class Student {
	private int id;
	private int rollNo;
	private String name;
	private String department;
	private int sem;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSem() {
		return sem;
	}
	public void setSem(int sem) {
		this.sem = sem;
	}
	public Student(int id, int rollNo, String name, String department, int sem) {
		super();
		this.id = id;
		this.rollNo = rollNo;
		this.name = name;
		this.department = department;
		this.sem = sem;
	}
	public Student(int rollNo, String name, String department, int sem) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.department = department;
		this.sem = sem;
	}
	
	
	

}
