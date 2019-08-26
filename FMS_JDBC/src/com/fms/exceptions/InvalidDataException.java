package com.fms.exceptions;

public class InvalidDataException extends NullPointerException{
	public InvalidDataException() {
		System.out.println("No Data Available in the Database");
	}

}
