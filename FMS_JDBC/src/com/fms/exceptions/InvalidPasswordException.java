package com.fms.exceptions;

public class InvalidPasswordException extends RuntimeException{
	 public InvalidPasswordException(){
		 System.out.println("Enter valid Password  i.e., it should contain minimum 8 characters ,atleast 1 Uppercase Letter,atleast 1 Lowercase Letter,atleast 1 special character ");
	 }
}
