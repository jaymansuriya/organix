package com.example.bean;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("student")
@Scope("singleton")
public class Student {
	
	@Value("demo name")
	private String name;
	
	@Value("110")
	private int rollNo;
	
	@Value("#{marks}")
	private ArrayList<Integer> marks;
	
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int rollNo, ArrayList<Integer> marks) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public ArrayList<Integer> getMarks() {
		return marks;
	}
	public void setMarks(ArrayList<Integer> marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + ", marks=" + marks + "]";
	}
	
	

}
