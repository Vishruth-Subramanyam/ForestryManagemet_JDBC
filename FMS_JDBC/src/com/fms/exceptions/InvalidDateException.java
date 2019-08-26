package com.fms.exceptions;

public class InvalidDateException extends RuntimeException{
	public InvalidDateException() {
		System.out.println("Enter Date format in YYYY-MM-DD ");
	}
	 
}
