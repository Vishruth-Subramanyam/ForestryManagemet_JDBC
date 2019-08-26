package com.fms.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	public static boolean isEmailValid(String email) {
		boolean valid = false;
		Pattern pat = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher mat = pat.matcher(email);
		valid = mat.matches();
		return valid;
	}
	public static boolean isValidTelNum(String telephoneNumber) {
		boolean valid = false;
				Pattern pat = Pattern.compile("\\d{10}");
				Matcher mat = pat.matcher(telephoneNumber);
				valid = mat.matches();
		return valid;
	}
	public static boolean isValidPostCode(String postCode) {//Charsequence instead of string
		boolean valid = false;
		Pattern pat = Pattern.compile("\\d{6}");
		Matcher mat = pat.matcher(postCode);
		valid = mat.matches();
		return valid;
	}
	public static boolean isValidName(String name) {
		boolean valid = false;
		Pattern pat = Pattern.compile("^[A-Za-z][\\w+]*$");
		Matcher mat = pat.matcher(name);
		valid = mat.matches();
		return valid;
	}
	public static boolean isValidId(String identificationNumber) {
		boolean valid = false;
		Pattern pat = Pattern.compile("\\d+");
		Matcher mat = pat.matcher(identificationNumber);
		valid = mat.matches();
		return valid;
	}
	public static boolean isValidtownCity(String townCity) {
		boolean valid = false;
		Pattern pat = Pattern.compile("^[A-Za-z]*$");
		Matcher mat = pat.matcher(townCity);
		valid = mat.matches();
		return valid;
	}
	public static boolean isValidDate(String date) {
		boolean valid = false;
		Pattern pat = Pattern.compile("^(\\d{4})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$");
		Matcher mat = pat.matcher(date);
		valid = mat.matches();
		return valid;
	}
	public static boolean isValidDay(String day) {
		boolean valid = false;
		Pattern pat = Pattern.compile("^(monday|tuesday|wednesday|thursday|friday|saturday|sunday)$",Pattern.CASE_INSENSITIVE);
		Matcher mat = pat.matcher(day);
		valid = mat.matches();
		return valid;
	}
	public static boolean isValidPassword(String password) {
		boolean valid = false;
		/*	    At least one upper case English letter, (?=.*?[A-Z])
		At least one lower case English letter, (?=.*?[a-z])
		At least one digit, (?=.*?[0-9])
		At least one special character, (?=.*?[#?!@$%^&*-])
    	Minimum eight in length .{8,} (with the anchors)    
		 */	
		Pattern pat = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");  
		Matcher mat = pat.matcher(password);
		valid = mat.matches();
		return valid;
	}
}
