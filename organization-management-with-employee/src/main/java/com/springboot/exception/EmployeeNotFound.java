package com.springboot.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;  

@ResponseStatus(HttpStatus.NOT_FOUND)  
public class EmployeeNotFound extends RuntimeException {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeNotFound(String message)   
	{  
		super(message);  
	} 
}
