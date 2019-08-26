package com.fms.exceptions;

public class InvalidChoiceException extends RuntimeException{
	public InvalidChoiceException(){
		System.out.println("Enter the choice in Number Format");
	}

}
