package com.fms.exceptions;

public class InvalidPostCodeException extends RuntimeException{
	public InvalidPostCodeException() {
		System.out.println("Enter valid six digit PostCode ");
	}
	 
}
