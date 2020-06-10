package com.capgemini.assetms.exception;

public class AssetException extends RuntimeException {
	public AssetException() {
		System.err.println("Asset Exception");
		System.err.println("Please check the values you have entered");
	}

}// end of class
