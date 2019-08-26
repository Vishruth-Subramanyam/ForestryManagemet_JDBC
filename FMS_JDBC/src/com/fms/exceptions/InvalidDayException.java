package com.fms.exceptions;

public class InvalidDayException extends RuntimeException{
	public InvalidDayException() {
		System.out.println("Enter in correct day format i.e., tuesday/TUESDAY[case insensitive] ");
	}
	 
}
