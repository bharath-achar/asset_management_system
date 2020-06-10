package com.capgemini.assetms.exception;

public class LoginException extends RuntimeException {

	public LoginException() {
		System.err.println("Login Exception");
		System.err.println("Please enter proper credentials");
	}

}// end of class
