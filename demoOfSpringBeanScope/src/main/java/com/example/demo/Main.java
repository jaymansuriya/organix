package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.bean.Student;
import com.example.bean.Teacher;

public class Main {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/example/bean/config.xml");

		Student s1 = context.getBean("student", Student.class);

		System.out.println(
				"==========================================================================================================================");

		System.out.println("Object of Student s1 : " + s1);

		Student s2 = context.getBean("student", Student.class);

		System.out.println("Object of Student s2 : " + s2);

		System.out.println("Hash code of s1 : " + s1.hashCode() + " \nHash code of s2 : " + s2.hashCode());

		System.out.println("Comparing Hash code of s1 and s2 : " + (s1.hashCode() == s2.hashCode()));

		System.out.println(
				"==========================================================================================================================");

		Teacher t1 = context.getBean("teacher", Teacher.class);

		System.out.println("Object of Teacher t1 : " + t1);

		Teacher t2 = context.getBean("teacher", Teacher.class);

		System.out.println("Object of Teacher t2 : " + t2);
		
		System.out.println("Hash code of t1 : " + t1.hashCode() + " \nHash code of t2 : " + t2.hashCode());

		System.out.println("Comparing Hash code of t1 and t2 : " + (t1.hashCode() == t2.hashCode()));

	}
}
