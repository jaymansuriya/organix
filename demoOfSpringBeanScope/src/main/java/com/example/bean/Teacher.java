package com.example.bean;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("teacher")
@Scope("prototype")
public class Teacher {
	
	@Value("demo teacher name")
	private String name;
	
	@Value("50000")
	private int salary;
	
	@Value("#{number}")
	private ArrayList<Integer> number;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public ArrayList<Integer> getNumber() {
		return number;
	}
	public void setNumber(ArrayList<Integer> number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "Teacher [name=" + name + ", salary=" + salary + ", number=" + number + "]";
	}
	public Teacher(String name, int salary, ArrayList<Integer> number) {
		super();
		this.name = name;
		this.salary = salary;
		this.number = number;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
} 
