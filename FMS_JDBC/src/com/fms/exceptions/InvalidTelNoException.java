package com.fms.exceptions;

public class InvalidTelNoException extends RuntimeException{
	 public InvalidTelNoException(){
		 System.out.println("Enter Valid 10 digit Telephone Number");
	 }
}
