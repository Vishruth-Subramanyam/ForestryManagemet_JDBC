package com.fms.exceptions;

public class InvalidEmailException extends RuntimeException{
	 public InvalidEmailException(){
		 System.out.println("Enter Proper Email ID");
	 }
}
