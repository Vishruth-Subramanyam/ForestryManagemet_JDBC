package com.fms.app;

import java.io.IOException;
import java.util.Scanner;

import com.fms.exceptions.InvalidChoiceException;
import com.fms.services.Validation;

public class ForestryApp {
public static void main(String[] args) throws IOException {
	System.out.println("Welcome to Forestry Management System");
	System.out.println("******************************************************************");
	Scanner scanner = new Scanner(System.in);
	do{
		System.out.println("1.Contract");
		System.out.println("2.Customer");
		System.out.println("3.Haulier");
		System.out.println("4.Order");
		System.out.println("5.Product");
		System.out.println("6.Exit");
		System.out.println("Enter The Choice");
		String custChoice = scanner.next();
		while(!Validation.isValidId(custChoice)) {
			try{
				throw new InvalidChoiceException();
			}catch(InvalidChoiceException e){
				System.out.println("Enter your choice :");
				custChoice = scanner.next();
			}
		}

		switch(Integer.parseInt(custChoice)) {
		case 1:
			ContractApp.contractApp();
			break;
		case 2:
			CustomerApp.customerApp();
			break;
		case 3:
			HaulierApp.haulierApp();
			break;
		case 4:
			OrdersApp.ordersApp();
			break;
		case 5:
			ProductApp.productApp();
			break;
		case 6:
			System.exit(0);
		default:
			System.out.println("Enter Valid Choice");
			break;
			
		}

	}while(true);
}
}
