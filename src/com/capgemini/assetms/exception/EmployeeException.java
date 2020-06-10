package com.capgemini.assetms.exception;

public class EmployeeException extends RuntimeException {
	public EmployeeException() {
		System.err.println("Employee Exception");
		System.err.println("Please check the values you have entered");
	}

}// end of class
